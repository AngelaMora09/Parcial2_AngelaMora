package modelos;

import datos.Dataset;

/**
 * Modelo de regresión. Hiperparámetro: grado del polinomio.
 */
public class ModeloRegresion extends Modelo {

    private int grado;

    public ModeloRegresion(String nombre, int maxEpocas, int grado) {
        super(nombre, maxEpocas);
        this.grado = grado;
    }

    @Override
    public double entrenar(Dataset dataset) {
        // TODO: implementar
        int maxEpocas = getLossPorEpoca().length;
        int lossInicial = Math.max(10, grado * 20);

        for (int i = 0; i < maxEpocas; i++) {
            int lossActual = Math.max(1, lossInicial - (i * 2));
            registrarEpoca(lossActual);
        }

        return mejorLoss();
    }

    public int getGrado() { return grado; }
}