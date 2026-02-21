import java.util.*;

public class StreamingApp {
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando aplicativo de streaming de áudio");

        // Criando usuários
        UsuarioGratuito usuarioGratuito = new UsuarioGratuito(1, "Augustinho", "carrara@email.com", true);
        UsuarioPremium usuarioPremium = new UsuarioPremium(2, "Ana Maria Braga", "lorujosé@email.com", 19.90);
        UsuarioFamilia usuarioFamilia = new UsuarioFamilia(3, "Família Nazaré", "vilaododestino@email.com", 4);

        // Criando artistas, narradores e apresentadores
        Artista artista = new Artista(4, "Nazaré", "viladodestino@email.com", "Novela Dramática");
        Narrador narrador = new Narrador(5, "Augustinho", "carrara@email.com", "Comédia");
        Apresentador apresentador = new Apresentador(6, "Ana Maria Braga", "lorujosé@email.com", "Culinária & Variedades");

        // Exibindo informações dos usuários
        System.out.println("\n--- Informações dos Usuários ---");
        usuarioGratuito.exibirInfo();
        usuarioPremium.exibirInfo();
        usuarioFamilia.exibirInfo();
        artista.exibirInfo();
        narrador.exibirInfo();
        apresentador.exibirInfo();

        // Criando álbuns
        Album album1 = new Album("Receitas Musicais da Ana", 2022);
        Album album2 = new Album("Tramas da Nazaré", 2023);

        // Criando conteúdos
        Musica musica = new Musica(1, "Pegadinha do Carrara", 3.5, artista, album1);
        Podcast podcast = new Podcast(2, "Café com a Ana", 45.0, apresentador, 10);
        Audiobook audiobook = new Audiobook(3, "Planos Infalíveis da Nazaré", 360.0, narrador, 12);

        // Adicionando músicas ao álbum2
        album2.addMusica("Olhar de Vilã");
        album2.addMusica("Empurrão na Escada");

        // Manipulando conteúdos
        System.out.println("\n--- Manipulação de Conteúdos ---");
        musica.tocar();
        podcast.ouvir();
        audiobook.ouvir();

        // Criando e manipulando playlists
        System.out.println("\n--- Playlists e Histórico ---");
        Playlist playlist = new Playlist(apresentador, 5);
        playlist.reproduzir();

        Historico historico = new Historico("Momentos mais icônicos");
        historico.exibir();

        // Adicionando músicas ao álbum
        album1.addMusica("Louro José Remix");
        album1.addMusica("Receita de Amor");

        // Exibindo informações dos álbuns
        System.out.println("\n--- Informações dos Álbuns ---");
        album1.exibirInfo();
        album2.exibirInfo();

        // Processando pagamentos e assinaturas
        System.out.println("\n--- Pagamentos e Assinaturas ---");
        Pagamento pagamento = new Pagamento("Cartão de Crédito", 19.90);
        pagamento.processar();

        Assinatura assinatura = new Assinatura();
        assinatura.setTipo("Premium");
        assinatura.setPreco(19.90);
        assinatura.exibir();

        // Avaliações e comentários
        System.out.println("\n--- Avaliações e Comentários ---");
        Avaliacao avaliacao = new Avaliacao("Hilário!", 5);
        avaliacao.avaliar();

        Comentario comentario = new Comentario("Amei esse episódio com a Ana!", usuarioPremium);
        System.out.println("Comentário de " + comentario.getUsuario().getNome() + ": " + comentario.getTexto());

        // Gêneros e recomendações
        Genero genero = new Genero("Novela Hits");
        System.out.println("Gênero criado: " + genero.getNome());
        Recomendacao recomendacao = new Recomendacao("Baseado no seu amor por novelas e comédia");
        recomendacao.sugerir();

        // Demonstração de funcionalidades específicas
        System.out.println("\n--- Funcionalidades Específicas ---");
        usuarioPremium.baixar("Música: Pegadinha do Carrara");
        usuarioGratuito.ouvirAnuncio();
        usuarioFamilia.adicionarMembro();
        artista.publicarConteudo();
        narrador.narrar();
        apresentador.apresentar();

        System.out.println("\nAplicativo encerrado com sucesso!");
    }
}

// ======= Classes do modelo =======
// (resto do código permanece o mesmo)

// ======= Classes do modelo =======
abstract class Usuario {
    protected int id;
    protected String nome;
    protected String email;

    public Usuario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public String getNome() { return nome; }

    public void exibirInfo() {
        System.out.println("ID: " + id + " | Nome: " + nome + " | E-mail: " + email);
    }
}

class UsuarioGratuito extends Usuario {
    private boolean temAnuncios;

    public UsuarioGratuito(int id, String nome, String email, boolean temAnuncios) {
        super(id, nome, email);
        this.temAnuncios = temAnuncios;
    }

 
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Tipo: Gratuito | Recebe anúncios: " + (temAnuncios ? "Sim" : "Não"));
    }

    public void ouvirAnuncio() {
        System.out.println(nome + " está ouvindo um anúncio...");
    }
}

class UsuarioPremium extends Usuario {
    private double precoMensal;

    public UsuarioPremium(int id, String nome, String email, double precoMensal) {
        super(id, nome, email);
        this.precoMensal = precoMensal;
    }

  
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Tipo: Premium | Preço mensal: R$ " + precoMensal);
    }

    public void baixar(String conteudo) {
        System.out.println(nome + " baixou: " + conteudo);
    }
}

class UsuarioFamilia extends Usuario {
    private int membros;

    public UsuarioFamilia(int id, String nome, String email, int membros) {
        super(id, nome, email);
        this.membros = membros;
    }

  
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Tipo: Família | Membros permitidos: " + membros);
    }

    public void adicionarMembro() {
        membros++;
        System.out.println("Novo membro adicionado. Total agora: " + membros);
    }
}

class Artista extends Usuario {
    private String estilo;

    public Artista(int id, String nome, String email, String estilo) {
        super(id, nome, email);
        this.estilo = estilo;
    }

  
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Função: Artista | Estilo: " + estilo);
    }

    public void publicarConteudo() {
        System.out.println(nome + " publicou novo conteúdo musical!");
    }
}

class Narrador extends Usuario {
    private String estilo;

    public Narrador(int id, String nome, String email, String estilo) {
        super(id, nome, email);
        this.estilo = estilo;
    }

   
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Função: Narrador | Estilo: " + estilo);
    }

    public void narrar() {
        System.out.println(nome + " está narrando um capítulo...");
    }
}

class Apresentador extends Usuario {
    private String tema;

    public Apresentador(int id, String nome, String email, String tema) {
        super(id, nome, email);
        this.tema = tema;
    }

  
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Função: Apresentador | Tema: " + tema);
    }

    public void apresentar() {
        System.out.println(nome + " está apresentando o programa: " + tema);
    }
}

class Album {
    private String titulo;
    private int ano;
    private List<String> musicas = new ArrayList<>();

    public Album(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public void addMusica(String nome) {
        musicas.add(nome);
        System.out.println("Música '" + nome + "' adicionada ao álbum '" + titulo + "'.");
    }

    public void exibirInfo() {
        System.out.println("Álbum: " + titulo + " (" + ano + ")");
        System.out.println("Faixas: " + String.join(", ", musicas));
    }
}

abstract class Conteudo {
    protected int id;
    protected String titulo;
    protected double duracao; // em minutos

    public Conteudo(int id, String titulo, double duracao) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
    }

    public abstract void tocar();
}

class Musica extends Conteudo {
    private Artista artista;
    private Album album;

    public Musica(int id, String titulo, double duracao, Artista artista, Album album) {
        super(id, titulo, duracao);
        this.artista = artista;
        this.album = album;
        if (album != null) album.addMusica(titulo);
    }

  
    public void tocar() {
        System.out.println("Tocando música: " + titulo + " - " + artista.getNome() + " (" + duracao + " min)");
    }
}

class Podcast extends Conteudo {
    private Apresentador apresentador;
    private int episodios;

    public Podcast(int id, String titulo, double duracao, Apresentador apresentador, int episodios) {
        super(id, titulo, duracao);
        this.apresentador = apresentador;
        this.episodios = episodios;
    }

    public void ouvir() {
        System.out.println("Ouvindo podcast: " + titulo + " com " + apresentador.getNome() + " (" + duracao + " min)");
    }

  
    public void tocar() { ouvir(); }
}

class Audiobook extends Conteudo {
    private Narrador narrador;
    private int capitulos;

    public Audiobook(int id, String titulo, double duracao, Narrador narrador, int capitulos) {
        super(id, titulo, duracao);
        this.narrador = narrador;
        this.capitulos = capitulos;
    }

    public void ouvir() {
        System.out.println("Ouvindo audiobook: " + titulo + " narrado por " + narrador.getNome() + " (" + duracao + " min)");
    }

    
    public void tocar() { ouvir(); }
}

class Playlist {
    private Usuario dono;
    private int tamanho;

    public Playlist(Usuario dono, int tamanho) {
        this.dono = dono;
        this.tamanho = tamanho;
    }

    public void reproduzir() {
        System.out.println("Reproduzindo playlist de " + dono.getNome() + " com " + tamanho + " itens.");
    }
}

class Historico {
    private String titulo;

    public Historico(String titulo) { this.titulo = titulo; }

    public void exibir() { System.out.println("Histórico: " + titulo); }
}

class Pagamento {
    private String metodo;
    private double valor;

    public Pagamento(String metodo, double valor) {
        this.metodo = metodo; this.valor = valor;
    }

    public void processar() {
        System.out.println("Processando pagamento de R$ " + valor + " via " + metodo + "...");
        System.out.println("Pagamento concluído com sucesso.");
    }
}

class Assinatura {
    private String tipo;
    private double preco;

    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setPreco(double preco) { this.preco = preco; }
    public void exibir() { System.out.println("Assinatura: " + tipo + " | Preço: R$ " + preco); }
}

class Avaliacao {
    private String texto;
    private int nota;

    public Avaliacao(String texto, int nota) { this.texto = texto; this.nota = nota; }

    public void avaliar() { System.out.println("Avaliação: " + texto + " | Nota: " + nota + "/5"); }
}

class Comentario {
    private String texto;
    private Usuario usuario;

    public Comentario(String texto, Usuario usuario) { this.texto = texto; this.usuario = usuario; }

    public String getTexto() { return texto; }
    public Usuario getUsuario() { return usuario; }
}

class Genero {
    private String nome;
    public Genero(String nome) { this.nome = nome; }
    public String getNome() { return nome; }
}

class Recomendacao {
    private String motivo;
    public Recomendacao(String motivo) { this.motivo = motivo; }
    public void sugerir() { System.out.println("Recomendação: " + motivo); }
}
