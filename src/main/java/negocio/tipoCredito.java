package negocio;

public enum tipoCredito {
    // Tasa, Plazo Mínimo (años), % Comisión Director, % Comisión Asesor
    VEHICULO(0.02f, 5, 0.03f, 0.02f),
    VIVIENDA(0.009f, 15, 0.04f, 0.025f),
    LIBREINVERSION(0.05f, 3, 0.025f, 0.015f);

    private final float tasa;
    private final int plazoMinimoAnios;
    private final float comisionDirector;
    private final float comisionAsesor;

    tipoCredito(float tasa, int plazoMinimoAnios, float comisionDirector, float comisionAsesor) {
        this.tasa = tasa;
        this.plazoMinimoAnios = plazoMinimoAnios;
        this.comisionDirector = comisionDirector;
        this.comisionAsesor = comisionAsesor;
    }

    public float getTasa() { return tasa; }
    public int getPlazoMinimoAnios() { return plazoMinimoAnios; }
    public float getComisionDirector() { return comisionDirector; }
    public float getComisionAsesor() { return comisionAsesor; }
}