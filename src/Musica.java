/**
 * PROJETO: SwiftScore
 * OBJETIVO TÉCNICO:
 * - Demonstrar HERANÇA (extends Audio).
 * - Demonstrar ENCAPSULAMENTO (atributos privados com getters e setters).
 * - Demonstrar POLIMORFISMO / SOBRESCRITA (@Override no método reproduzir).
 */
public class Musica extends Audio {
    private String artista;
    private String album;
    private String genero;

    // --- GETTERS E SETTERS ESPECÍFICOS DE MÚSICA ---

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // --- SOBRESCRITA DE MÉTODOS (POLIMORFISMO) ---

    @Override
    public void reproduzir() {
        System.out.println("▶️ TOCANDO MÚSICA: " + getTitulo() + " - " + this.artista);
    }
}
