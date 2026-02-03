# Nube — FastAPI Starter

## Guidelines
- Keep endpoints small and focused.
- Use `/health` for uptime checks.
- Prefer environment variables for secrets.
- Add features in routes (`app/routes`).
- Keep config in `app/core`.

## Setup
```bash
python -m venv .venv
.venv\Scripts\activate
pip install -r requirements.txt
```

## Run
```bash
uvicorn app.main:app --reload
```

Open: http://127.0.0.1:8000
Docs: http://127.0.0.1:8000/docs

## Firestore (optional)
If you want `/api/firestore-check` to work:
```bash
pip install google-cloud-firestore
set GOOGLE_APPLICATION_CREDENTIALS=creation-test-key.json
```
