import os

ENV = os.getenv("ENV", "local")

IS_CLOUD = ENV == "cloud"