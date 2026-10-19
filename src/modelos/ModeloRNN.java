package modelos;

import datos.Dataset;

/**
 * Modelo RNN. Hiperparámetro: número de capas.
 */
public class ModeloRNN extends Modelo {

    private int numCapas;

    public ModeloRNN(String nombre, int maxEpocas, int numCapas) {
        super(nombre, maxEpocas);
        this.numCapas = numCapas;
    }

    @Override
    public double entrenar(Dataset dataset) {
        // TODO: implementar
        int maxEpocas = getLossPorEpoca().length;
        int lossInicial = Math.max(10, numCapas * 15);

        for (int i = 0; i < maxEpocas; i++) {
            int lossActual = Math.max(1, lossInicial - (i * 2));
            registrarEpoca(lossActual);
        }

        return mejorLoss();
    }

    public int getNumCapas() { return numCapas; }
}