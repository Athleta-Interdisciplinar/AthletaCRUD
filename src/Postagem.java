public class Postagem {
    private int id_postagem;
    private Data dt_postagem;
    private String texto;
    private String imagem;

    public Postagem(int id, Data data, String texto, String imagem){
        this.id_postagem=id;
        this.dt_postagem=data;
        this.texto=texto;
        this.imagem=imagem;
    }

    public int getId_postagem() {
        return id_postagem;
    }

    public Data getDt_postagem() {
        return dt_postagem;
    }

    public String getTexto() {
        return texto;
    }

    public String getImagem() {
        return imagem;
    }

    
}
