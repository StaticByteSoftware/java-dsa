"""Rebuild the Index table in README.md from the header comment of every solution file.

Usage:
    python3 tools/build_index.py
"""
import pathlib
import re

ROOT = pathlib.Path(__file__).resolve().parent.parent
README = ROOT / "README.md"
START, END = "<!-- INDEX:START -->", "<!-- INDEX:END -->"
FIELDS = ("Problem", "Difficulty", "Link", "Pattern", "Time", "Space", "Solved")


def read_header(path: pathlib.Path) -> dict:
    head = path.read_text().split("*/", 1)[0]
    info = {}
    for field in FIELDS:
        match = re.search(rf"^\s*\*\s*{field}:\s*(.+?)\s*$", head, re.MULTILINE)
        info[field] = match.group(1) if match else ""
    return info


def row(path: pathlib.Path) -> tuple:
    info = read_header(path)
    number, _, title = info["Problem"].partition(". ")
    num = int(number) if number.isdigit() else 0
    title = title or path.stem
    problem = f"[{title}]({info['Link']})" if info["Link"] else title
    code = path.relative_to(ROOT).as_posix()
    cells = [str(num) if num else "", f"{problem} ([code]({code}))", info["Difficulty"],
             info["Pattern"], info["Time"], info["Space"], info["Solved"]]
    return (path.parent.name, num, "| " + " | ".join(c.replace("|", "\\|") for c in cells) + " |")


def main() -> None:
    files = sorted(p for p in ROOT.glob("[0-9][0-9]-*/*.java"))
    rows = sorted(row(p) for p in files)
    table = ["| # | Problem | Difficulty | Pattern | Time | Space | Solved |",
             "| --- | --- | --- | --- | --- | --- | --- |"] + [r[2] for r in rows]
    text = README.read_text()
    before, rest = text.split(START, 1)
    _, after = rest.split(END, 1)
    README.write_text(before + START + "\n" + "\n".join(table) + "\n" + END + after)
    print(f"Index rebuilt: {len(rows)} problem(s).")


if __name__ == "__main__":
    main()
