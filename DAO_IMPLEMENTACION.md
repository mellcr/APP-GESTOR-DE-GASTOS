# DAOImpl - Documentación

## Descripción

`DAOImpl` es una clase abstracta que proporciona una implementación base para operaciones de acceso a datos (DAO) en una base de datos relacional. Incluye métodos para manejar transacciones, ejecutar consultas y modificaciones, y gestionar la conexión con la base de datos.

## Características Principales

- Manejo de transacciones (inicio, confirmación y rollback).
- Ejecución de sentencias SQL para inserciones, modificaciones y eliminaciones.
- Generación dinámica de consultas SQL.
- Listado y obtención de registros por ID.
- Manejo de conexiones a la base de datos.

## Atributos

| Atributo                   | Tipo                 | Descripción |
|----------------------------|----------------------|-------------|
| `nombre_tabla`             | `String`            | Nombre de la tabla asociada al DAO. |
| `conexion`                 | `Connection`        | Conexión a la base de datos. |
| `statement`                | `CallableStatement` | Sentencia SQL preparada. |
| `resultSet`                | `ResultSet`         | Resultado de una consulta SQL. |
| `mostrarSentenciaSQL`      | `Boolean`           | Indica si se deben mostrar las sentencias SQL ejecutadas. |
| `retornarLlavePrimaria`    | `Boolean`           | Determina si se debe retornar la clave primaria tras una inserción. |
| `usarTransaccion`          | `Boolean`           | Define si se debe usar transacciones en las operaciones. |
| `tipo_Operacion`           | `TipoOperacion`     | Tipo de operación que se está ejecutando (INSERTAR, MODIFICAR, ELIMINAR). |

## Métodos Principales

### Manejo de Transacciones

- `iniciarTransaccion()`: Abre una conexión y desactiva el autocommit.
- `comitarTransaccion()`: Confirma los cambios en la base de datos.
- `rollbackTransaccion()`: Revierte los cambios en caso de error.
- `abrirConexion()`: Obtiene una conexión de `DBManagerEncrip`.
- `cerrarConexion()`: Cierra la conexión actual.

### Ejecución de SQL

- `colocarSQLenStatement(String sql)`: Prepara una sentencia SQL.
- `ejecutarModificacionEnBD(String sql)`: Ejecuta una modificación (INSERT, UPDATE, DELETE).
- `ejecutarConsultaEnBD(String sql)`: Ejecuta una consulta y almacena el resultado en `resultSet`.

### Operaciones CRUD

- `insertar()`: Ejecuta una inserción en la base de datos.
- `modificar()`: Ejecuta una modificación en la base de datos.
- `eliminar()`: Realiza una eliminación lógica estableciendo `activo=0`.
- `listarTodos(Integer limite)`: Lista todos los registros activos con un límite opcional.
- `obtenerPorId()`: Obtiene un registro por su ID.

### Generación Dinámica de SQL (Métodos Abstractos)

Las siguientes funciones deben ser implementadas por las clases concretas que extiendan `DAOImpl`:

- `obtenerListaDeAtributosParaInsercion()`: Retorna los atributos de la tabla a insertar.
- `incluirListaDeParametrosParaInsercion()`: Retorna la lista de parámetros SQL para la inserción.
- `incluirValorDeParametrosParaInsercion()`: Asigna valores a los parámetros de inserción.
- `obtenerListaDeValoresYAtributosParaModificacion()`: Retorna los atributos y valores para una modificación.
- `obtenerPredicadoParaLlavePrimaria()`: Define la condición WHERE basada en la clave primaria.
- `incluirValorDeParametrosParaModificacion()`: Asigna valores a los parámetros en una modificación.
- `obtenerProyeccionParaSelect()`: Define las columnas a seleccionar en un `SELECT`.
- `agregarObjetoALaLista(List lista, ResultSet resultSet)`: Convierte un `ResultSet` en objetos de la entidad.
- `instanciarObjetoDelResultSet()`: Crea una instancia de la entidad a partir de un `ResultSet`.
- `limpiarObjetoDelResultSet()`: Resetea la instancia de la entidad cuando no se encuentra un registro.

### Manejo de Tipos de Datos en SQL

- `incluirParametroString(Integer numeroParametro, String valor)`: Asigna un `String` a un parámetro SQL.
- `incluirParametroInt(Integer numeroParametro, Integer valor)`: Asigna un `Integer`.
- `incluirParametroDouble(Integer numeroParametro, Double valor)`: Asigna un `Double`.
- `incluirParametroDate(Integer numeroParametro, Date valor)`: Asigna una fecha SQL.
- `incluirParametroBoolean(Integer numeroParametro, Boolean valor)`: Asigna un `Boolean` como `1` o `0`.

### Obtención de la Última Clave Primaria Insertada

- `retornarUltimoAutoGenerado()`: Retorna el último ID insertado en la base de datos.

## Uso

Para usar esta clase, se debe crear una subclase que implemente los métodos abstractos y defina la estructura de la entidad correspondiente. Por ejemplo:

```java
public class UsuarioDAO extends DAOImpl {
    
    public UsuarioDAO() {
        super("usuarios");
    }
    
    @Override
    protected String obtenerListaDeAtributosParaInsercion() {
        return "nombre, email, clave";
    }
    
    @Override
    protected String incluirListaDeParametrosParaInsercion() {
        return "?, ?, ?";
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.incluirParametroString(1, "Ejemplo");
        this.incluirParametroString(2, "ejemplo@email.com");
        this.incluirParametroString(3, "clave123");
    }
}
```

Con esta estructura, `UsuarioDAO` puede heredar y utilizar los métodos definidos en `DAOImpl`, asegurando una gestión estructurada y reutilizable del acceso a la base de datos.


