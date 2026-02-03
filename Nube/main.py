from fastapi import FastAPI

app = FastAPI(title="Nube API")

@app.get("/")
def root():
    return {"message": "Nube FastAPI is running"}

@app.get("/health")
def health():
    return {"status": "ok"}
