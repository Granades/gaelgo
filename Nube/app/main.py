from fastapi import FastAPI
from app.routes import health, info

app = FastAPI(title="Nube API")

@app.get("/")
def root():
    return {"message": "Nube FastAPI is running"}

app.include_router(health.router)
app.include_router(info.router)
