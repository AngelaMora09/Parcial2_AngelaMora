package plataforma;

import java.util.ArrayList;
import java.util.List;

/**
 * Plataforma que AGREGA experimentos.
 */
public class Plataforma {

    private String nombre;
    private ArrayList<Experimento> experimentos;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.experimentos = new ArrayList<>();
    }

    /** Agrega un experimento ya existente (agregación). */
    public void agregarExperimento(Experimento experimento) {
        // TODO: implementar
        if (experimento != null) {
            this.experimentos.add(experimento);
        }
    }

    /**
     * Reporte: una línea por experimento con su id y el mejor loss de su modelo.
     */
    public List<String> reporteMejorLoss() {
        // TODO: implementar
        List<String> reporte = new ArrayList<>();
        for (Experimento exp : experimentos) {
            if (exp != null) {
                int mejorLoss = (exp.getModelo() != null) ? exp.getModelo().mejorLoss() : Integer.MAX_VALUE;
                reporte.add(exp.getId() + ":" + mejorLoss);
            }
        }
        return reporte;
    }

    public String getNombre() { return nombre; }
    public ArrayList<Experimento> getExperimentos() { return experimentos; }
}