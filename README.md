### Proyecto Java — Inicio basado en diagrama

Este repositorio incluye un esqueleto mínimo en Java para empezar a implementar el dominio a partir de un diagrama UML/PlantUML.

#### Cómo continuar
- Coloca tu diagrama en `/workspace` o dentro de `docs/` con una de estas extensiones: `.puml`, `.plantuml`, `.uml`, `.drawio`, `.png`, `.pdf`.
- Indica el nombre del archivo del diagrama si no está claro (o súbelo con el nombre `model.puml`).
- A partir de ese diagrama, se generarán/crearán las clases en `src/main/java` siguiendo el paquete `com.example` (o el que nos indiques).

#### Ejecutar la app
```bash
javac -d out $(find src/main/java -name "*.java") && java -cp out com.example.App
```

#### Estructura
```
src/
  main/
    java/
      com/
        example/
          App.java
docs/ (opcional: coloca aquí el diagrama)
```

Si prefieres Maven o Gradle, lo puedo configurar en cuanto confirmes la preferencia. Por ahora se usa `javac` para compilar sin dependencias externas.

