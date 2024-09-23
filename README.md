
# APIRestWSpring

**A reusable REST API project built with Spring Boot, designed for easy integration and scalability in various applications.**

## Description
This project is a REST API built using Spring Boot. It provides a simple and reusable structure for handling common API functionalities such as managing entities, handling relations, and auditing. The API includes examples of how to implement One-to-One, One-to-Many, and Many-to-Many relationships, making it a flexible and adaptable solution for various needs.

## Features
- REST API for managing entities.
- Use of Spring Data JPA for database interactions.
- Auditing support via Hibernate Envers.
- Entity relationships:
  - One-to-One (`Persona` ↔ `Domicilio`)
  - One-to-Many (`Persona` ↔ `Libro`)
  - Many-to-Many (`Libro` ↔ `Autor`)
- Cross-Origin Resource Sharing (CORS) enabled for external access to the API.
- Reusable base controller structure for CRUD operations.

## Technologies
- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate Envers** for auditing
- **MySQL** database
- **Lombok** for reducing boilerplate code

## Requirements
- JDK 11+
- MySQL
- Maven

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/GabrielKitanovich/APIRestWSpring.git
   ```

2. Configure your database settings in the `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your-database
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```

## Example Entities

### Persona
The `Persona` entity represents a person and includes fields for `nombre`, `apellido`, `dni`, and relationships to `Domicilio` and `Libro`.

```java
@Entity
@Table(name = "persona")
public class Persona extends Base {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dni")
    private int dni;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "persona_libro",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    private List<Libro> libros = new ArrayList<>();
}
```

### Libro
The `Libro` entity contains the book's `titulo`, `fecha`, `genero`, and `paginas`, and it holds a Many-to-Many relationship with `Autor`.

```java
@Entity
@Table(name = "libro")
public class Libro extends Base {
    
    @Column(name = "titulo")
    private String titulo;

    @Column(name = "fecha")
    private int fecha;

    @Column(name = "genero")
    private String genero;

    @Column(name = "paginas")
    private int paginas;

    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores = new ArrayList<>();
}
```

## Example Request (POST) to Add a Persona

```json
{
    "nombre": "Lorenzo",
    "apellido": "Pereira",
    "dni": 555555555,
    "domicilio": {
        "calle": "San Martín",
        "numero": 123,
        "localidad": {
            "id": 2,
            "denominacion": "Lujan de Cuyo"
        }
    },
    "libros": [
        {
            "titulo": "1984",
            "fecha": 1949,
            "genero": "Dystopian",
            "paginas": 328,
            "autores": [
                {
                    "id": 1,
                    "nombre": "George Orwell"
                }
            ]
        },
        {
            "titulo": "The Name of the Wind",
            "fecha": 2007,
            "genero": "Fantasy",
            "paginas": 662,
            "autores": [
                {
                    "id": 2,
                    "nombre": "Patrick Rothfuss"
                }
            ]
        }
    ]
}
```

## Annotations Used

- `@RestController`: Defines the class as a controller that handles RESTful web requests.
- `@CrossOrigin(origins = "*")`: Allows cross-origin requests from all sources.
- `@RequestMapping`: Maps HTTP requests to handler methods of MVC controllers.
- `@Autowired`: Dependency injection for service classes.
- `@Entity`: Specifies that the class is an entity and is mapped to a database table.
- `@Table`: Defines the name of the table associated with the entity.
- `@Audited`: Enables Hibernate Envers for auditing changes to the entity.
- `@OneToOne`, `@OneToMany`, `@ManyToMany`: Define relationships between entities.

