"""Create a new solution file from templates/ProblemTemplate.java.

Usage:
    python3 tools/new_problem.py <folder> <number> "<title>" <difficulty> <link>

Example:
    python3 tools/new_problem.py 01-hash-maps 1 "Two Sum" Easy https://leetcode.com/problems/two-sum/
"""
import datetime
import pathlib
import re
import sys

ROOT = pathlib.Path(__file__).resolve().parent.parent
TEMPLATE = ROOT / "templates" / "ProblemTemplate.java"


def class_name(number: int, title: str) -> str:
    words = re.findall(r"[A-Za-z0-9]+", title)
    return f"P{number:04d}" + "".join(w[:1].upper() + w[1:] for w in words)


def pattern_name(folder: str) -> str:
    name = re.sub(r"^\d+-", "", folder).replace("-", " ")
    return name[:1].upper() + name[1:]


def main() -> None:
    if len(sys.argv) != 6:
        print(__doc__)
        sys.exit(1)
    folder, number, title, difficulty, link = sys.argv[1:]
    number = int(number)
    name = class_name(number, title)
    target = ROOT / folder / f"{name}.java"
    if target.exists():
        print(f"Already exists: {target.relative_to(ROOT)}")
        sys.exit(1)
    text = TEMPLATE.read_text()
    text = (text.replace("{{NUMBER}}", str(number))
                .replace("{{TITLE}}", title)
                .replace("{{DIFFICULTY}}", difficulty)
                .replace("{{LINK}}", link)
                .replace("{{PATTERN}}", pattern_name(folder))
                .replace("{{DATE}}", datetime.date.today().isoformat())
                .replace("ProblemTemplate", name))
    target.parent.mkdir(parents=True, exist_ok=True)
    target.write_text(text)
    print(f"Created {target.relative_to(ROOT)}")
    print(f"Run it:  java {target.relative_to(ROOT)}")


if __name__ == "__main__":
    main()
