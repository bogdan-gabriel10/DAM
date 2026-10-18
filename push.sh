#!/bin/bash
# Urcă pe GitHub tot ce e nou în repo-ul DAM.
#
# Folosire:
#   ./push.sh "Seminar04: RecyclerView"
#   ./push.sh                  -> mesaj automat cu data de azi
#
# Din terminalul Android Studio, când ești în SeminarXX:
#   ../push.sh "mesaj"

cd "$(dirname "$0")" || exit 1

MSG="${1:-Update seminare $(date '+%Y-%m-%d')}"

git add -A

if git diff --cached --quiet; then
  echo "Nimic nou de commis."
else
  echo "Fișiere care urcă:"
  git diff --cached --name-status
  echo
  git commit -q -m "$MSG" || exit 1
fi

# Aduce întâi ce ai modificat direct pe GitHub (ex. README), apoi urcă
git pull --rebase -q && git push
