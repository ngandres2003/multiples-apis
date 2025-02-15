
import express, { json } from 'express';
import cors from 'cors'
const app = express();
app.use(json());
app.use(cors())
const PORT = process.env.PORT || 3003;


const movies = [
    { id: 1, nombre: "El Acorazado Potemkin", director: "Sergei Eisenstein", ano: 1925, genero: "Drama Histórico", duracion: 75 },
    { id: 2, nombre: "Andrei Rublev", director: "Andrei Tarkovsky", ano: 1966, genero: "Drama Histórico", duracion: 205 },
    { id: 3, nombre: "La Balada de Narayama", director: "Shohei Imamura", ano: 1983, genero: "Drama", duracion: 130 },
    { id: 4, nombre: "Rashomon", director: "Akira Kurosawa", ano: 1950, genero: "Drama", duracion: 88 },
    { id: 5, nombre: "Los Siete Samuráis", director: "Akira Kurosawa", ano: 1954, genero: "Acción", duracion: 207 },
    { id: 6, nombre: "Cuentos de la Luna Pálida", director: "Kenji Mizoguchi", ano: 1953, genero: "Fantasía", duracion: 97 },
    { id: 7, nombre: "El Viaje de Chihiro", director: "Hayao Miyazaki", ano: 2001, genero: "Animación", duracion: 125 },
    { id: 8, nombre: "La Dolce Vita", director: "Federico Fellini", ano: 1960, genero: "Drama", duracion: 174 },
    { id: 9, nombre: "Cinema Paradiso", director: "Giuseppe Tornatore", ano: 1988, genero: "Drama", duracion: 155 },
    { id: 10, nombre: "El Bueno, el Malo y el Feo", director: "Sergio Leone", ano: 1966, genero: "Western", duracion: 161 },
    { id: 11, nombre: "La Strada", director: "Federico Fellini", ano: 1954, genero: "Drama", duracion: 108 },
    { id: 12, nombre: "El Gatopardo", director: "Luchino Visconti", ano: 1963, genero: "Drama Histórico", duracion: 186 },
    { id: 13, nombre: "Farewell My Concubine", director: "Chen Kaige", ano: 1993, genero: "Drama", duracion: 171 },
    { id: 14, nombre: "El Tigre y el Dragón", director: "Ang Lee", ano: 2000, genero: "Acción", duracion: 120 },
    { id: 15, nombre: "Hero", director: "Zhang Yimou", ano: 2002, genero: "Acción", duracion: 99 },
    { id: 16, nombre: "La Casa de los Espíritus", director: "Bille August", ano: 1993, genero: "Drama", duracion: 140 },
    { id: 17, nombre: "El Último Emperador", director: "Bernardo Bertolucci", ano: 1987, genero: "Drama Histórico", duracion: 163 },
    { id: 18, nombre: "La Vida de los Otros", director: "Florian Henckel von Donnersmarck", ano: 2006, genero: "Drama", duracion: 137 },
    { id: 19, nombre: "El Espejo", director: "Andrei Tarkovsky", ano: 1975, genero: "Drama", duracion: 108 },
    { id: 20, nombre: "Solaris", director: "Andrei Tarkovsky", ano: 1972, genero: "Ciencia Ficción", duracion: 167 }
];
app.get('/', (req, res) => {
    res.json({'Api con node de peliculas':"express"});
});


app.get('/movies', (req, res) => {
    res.json(movies);
});

app.get('/movies/:id', (req, res) => {
    const movie = movies.find(m => m.id === parseInt(req.params.id));
    if (!movie) return res.status(404).send('Película no encontrada');
    res.json(movie);
});


app.post('/movies', (req, res) => {
    const movie = {
        id: movies.length + 1,
        nombre: req.body.nombre,
        director: req.body.director,
        ano: req.body.ano,
        genero: req.body.genero,
        duracion: req.body.duracion
    };
    movies.push(movie);
    res.status(201).json(movie);
});



app.listen(PORT, () => {
    console.log(`http://localhost:${PORT}`);
});
