# Comprensión del diseño — Enunciado B
**Nombre:** Luz Angela Mora
**Fecha:** 19/10/2026

Responde con tus palabras, basándote en `docs/UML-final.md`. Respuestas
concisas (2–4 líneas por pregunta). Evidencia que entendiste el contrato
**antes** de programar.

---

### 1. Herencia y polimorfismo
¿Por qué `Modelo` es una clase abstracta y no concreta? Menciona qué método
obliga a cada subclase a implementar y qué gana el sistema con eso.

> _Tu respuesta:_ Lo es porque Modelo es como la idea de “animal” (no existe un animal cualquiera, existen varios). Por eso nadie crea un Modelo solo, solo sus "hijos" (CNN, RNN, Regresión). Todos están obligados a implementar entrenar(Dataset dataset), y así Experimento les dice “entrena” a todos de la misma forma, sin saber cuál es cuál.

---

### 2. Composición vs. agregación
Explica la diferencia entre `Experimento ◆— Modelo` (composición) y
`Plataforma ◇— Experimento` (agregación). ¿Qué pasaría con el modelo si se
elimina el experimento? ¿Y con los experimentos si se elimina la plataforma?

> _Tu respuesta:_ Composición: el modelo es como el corazón del experimento; si el experimento desaparece, el modelo desaparece con él. Agregación: la plataforma es como una bolsa de mercado con verduraas; si la bolsa se rompe, las verduras (experimentos) siguen existiendo.

---

### 3. Asociación
En `Investigador — Experimento`, ¿quién es dueño de quién? ¿Por qué se modela
como N:M y no como composición?

> _Tu respuesta:_ Ninguno es dueño del otro, son como amigos, pues cada uno es independiente. Es N:M porque un investigador puede trabajar en muchos experimentos, y un experimento puede tener muchos investigadores. Si uno desaparece, el otro sigue existiendo.

---

### 4. Dependencia
¿Por qué `Modelo` **depende** de `MetricaEvaluacion` en lugar de **tenerlo**
como atributo? ¿Qué ventaja tiene pasar el servicio como parámetro?

> _Tu respuesta:_ Modelo no se queda con la métrica guardada, solo se la da un momento para evaluar. Así puede usar distintas métricas sin cambiar nada de su propio código.

---

### 5. Listas
En este proyecto se usan dos estructuras distintas:
- `int[] lossPorEpoca` en `Modelo`
- `ArrayList<Experimento>` en `Plataforma`

Explica por qué en cada caso se eligió esa estructura y no la otra.

int[] en Modelo: se sabe desde el inicio cuántas épocas habrá (maxEpocas). ArrayList en Plataforma: no se sabe cuántos experimentos habrá.