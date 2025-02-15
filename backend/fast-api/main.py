from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel
from typing import List

app = FastAPI()

# Configuración de CORS
origins = [
    "http://localhost:3000",
    "http://localhost:8000",
    "http://localhost:3001",
    # Agrega aquí otros orígenes que necesites permitir
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

class Movie(BaseModel):
    id: int
    nombre: str
    director: str
    ano: int
    genero: str
    duracion: int

movies = [
    Movie(id=1, nombre="El Padrino", director="Francis Ford Coppola", ano=1972, genero="Crimen", duracion=175),
    Movie(id=2, nombre="Pulp Fiction", director="Quentin Tarantino", ano=1994, genero="Crimen", duracion=154),
    Movie(id=3, nombre="El Caballero Oscuro", director="Christopher Nolan", ano=2008, genero="Acción", duracion=152),
    Movie(id=4, nombre="Forrest Gump", director="Robert Zemeckis", ano=1994, genero="Drama", duracion=142),
    Movie(id=5, nombre="Inception", director="Christopher Nolan", ano=2010, genero="Ciencia Ficción", duracion=148),
    Movie(id=6, nombre="Matrix", director="Lana Wachowski, Lilly Wachowski", ano=1999, genero="Ciencia Ficción", duracion=136),
    Movie(id=7, nombre="Fight Club", director="David Fincher", ano=1999, genero="Drama", duracion=139),
    Movie(id=8, nombre="Gladiador", director="Ridley Scott", ano=2000, genero="Acción", duracion=155),
    Movie(id=9, nombre="Interstellar", director="Christopher Nolan", ano=2014, genero="Ciencia Ficción", duracion=169),
    Movie(id=10, nombre="El Señor de los Anillos: La Comunidad del Anillo", director="Peter Jackson", ano=2001, genero="Fantasía", duracion=178),
    Movie(id=11, nombre="Los Vengadores", director="Joss Whedon", ano=2012, genero="Acción", duracion=143),
    Movie(id=12, nombre="El Silencio de los Inocentes", director="Jonathan Demme", ano=1991, genero="Thriller", duracion=118),
    Movie(id=13, nombre="Titanic", director="James Cameron", ano=1997, genero="Drama", duracion=195),
    Movie(id=14, nombre="Avatar", director="James Cameron", ano=2009, genero="Ciencia Ficción", duracion=162),
    Movie(id=15, nombre="La La Land", director="Damien Chazelle", ano=2016, genero="Musical", duracion=128),
    Movie(id=16, nombre="Coco", director="Lee Unkrich, Adrian Molina", ano=2017, genero="Animación", duracion=105),
    Movie(id=17, nombre="Los Increíbles", director="Brad Bird", ano=2004, genero="Animación", duracion=115),
    Movie(id=18, nombre="Jurassic Park", director="Steven Spielberg", ano=1993, genero="Aventura", duracion=127),
    Movie(id=19, nombre="Toy Story", director="John Lasseter", ano=1995, genero="Animación", duracion=81),
    Movie(id=20, nombre="Buscando a Nemo", director="Andrew Stanton", ano=2003, genero="Animación", duracion=100)
]

@app.get("/")
def leer_raiz():
    return {"mensaje": "Api de peliculas con python"}

@app.get("/movies")
def get_movies():
    return movies

@app.get("/movies/{id}")
def get_movie_by_id(id: int):
    movie = next((m for m in movies if m.id == id), None)
    return movie if movie else {"error": "Pelicula no encontrada"}

@app.post("/movies")
def create_movie(movie: Movie):
    movies.append(movie)
    return movie

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="localhost", port=8000, reload=True)
