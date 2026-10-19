package plataforma;

import datos.Dataset;
import modelos.*;

/**
 * Experimento que COMPONE un modelo.
 * El modelo se crea dentro del constructor (composición real).
 */
public class Experimento {

    private String id;
    private Modelo modelo;

    /**
     * Crea el modelo según el tipo indicado.
     * Tipo: "CNN", "RNN", "REGRESION".
     * Si el tipo es inválido, el modelo queda null.
     */
    public Experimento(String id, String tipoModelo, int maxEpocas) {
        this.id = id;
        // TODO: implementar composición (factory simple con switch)
        if (tipoModelo != null) {
            switch (tipoModelo.toUpperCase()) {
                case "CNN":
                    this.modelo = new ModeloCNN("CNN-" + id, maxEpocas, 32);
                    break;
                case "RNN":
                    this.modelo = new ModeloRNN("RNN-" + id, maxEpocas, 2);
                    break;
                case "REGRESION":
                    this.modelo = new ModeloRegresion("REG-" + id, maxEpocas, 3);
                    break;
                default:
                    this.modelo = null;
                    break;
            }
        } else {
            this.modelo = null;
        }
    }

    /** Ejecuta el entrenamiento del modelo sobre el dataset. */
    public double ejecutar(Dataset dataset) {
        // TODO: implementar
        if (modelo == null) {
            return 0.0;
        }
        return modelo.entrenar(dataset);
    }

    public String getId() { return id; }
    public Modelo getModelo() { return modelo; }
}