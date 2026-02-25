
//Esse eu fiz mais completo, com estado ligado e desligado, velocidade máxima, parar, combustível e consumo, abastatecimento com limite do tanque.

public class Main {
    public static void main(String[] args) {
        Veiculo carro = new Veiculo("Volkswagen", "Gol", 0, 180, 50); // tanque cheio 50L

        carro.mostrarInfo();
        carro.ligar();
        carro.acelerar(60);
        carro.acelerar(80);
        carro.frear(30);
        carro.acelerar(200); // tenta passar do limite
        carro.abastecer(10);
        carro.parar();
        carro.desligar();
        carro.mostrarInfo();
    }
}

class Veiculo {
    private String marca;
    private String modelo;
    private int velocidade;
    private int velocidadeMaxima;
    private boolean ligado;
    private double combustivel;       // litros no tanque
    private double consumoPorKm = 0.1; // litros por km/h (simulação simples)
    private double capacidadeTanque;

    public Veiculo(String marca, String modelo, int velocidadeInicial, int velocidadeMaxima, double capacidadeTanque) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidade = velocidadeInicial;
        this.velocidadeMaxima = velocidadeMaxima;
        this.ligado = false;
        this.capacidadeTanque = capacidadeTanque;
        this.combustivel = capacidadeTanque; // inicia cheio
    }

    public void ligar() {
        if (combustivel <= 0) {
            System.out.println("Não é possível ligar. Tanque vazio!");
        } else if (!ligado) {
            ligado = true;
            System.out.println("O veículo foi ligado.");
        } else {
            System.out.println("O veículo já está ligado.");
        }
    }

    public void desligar() {
        if (ligado && velocidade == 0) {
            ligado = false;
            System.out.println("O veículo foi desligado.");
        } else if (velocidade > 0) {
            System.out.println("Não é possível desligar o veículo em movimento!");
        } else {
            System.out.println("O veículo já está desligado.");
        }
    }

    public void acelerar(int valor) {
        if (!ligado) {
            System.out.println("Não é possível acelerar. O veículo está desligado.");
            return;
        }
        if (combustivel <= 0) {
            velocidade = 0;
            ligado = false;
            System.out.println("O carro parou! Acabou o combustível.");
            return;
        }

        if (velocidade + valor > velocidadeMaxima) {
            velocidade = velocidadeMaxima;
            System.out.println("Velocidade máxima atingida: " + velocidade + " km/h");
        } else {
            velocidade += valor;
            System.out.println("Acelerando... Velocidade atual: " + velocidade + " km/h");
        }

        // Consome combustível proporcional à aceleração
        double gasto = valor * consumoPorKm;
        combustivel -= gasto;
        if (combustivel < 0) combustivel = 0;
        System.out.println("Combustível restante: " + combustivel + " L");
    }

    public void frear(int valor) {
        if (!ligado) {
            System.out.println("Não é possível frear. O veículo está desligado.");
            return;
        }
        velocidade -= valor;
        if (velocidade < 0) velocidade = 0;
        System.out.println("Freando... Velocidade atual: " + velocidade + " km/h");
    }

    public void parar() {
        if (!ligado) {
            System.out.println("O veículo já está desligado e parado.");
        } else {
            velocidade = 0;
            System.out.println("O veículo parou.");
        }
    }

    public void abastecer(double litros) {
        if (litros <= 0) {
            System.out.println("Quantidade inválida para abastecer.");
            return;
        }
        if (combustivel + litros > capacidadeTanque) {
            combustivel = capacidadeTanque;
            System.out.println("Tanque cheio! Capacidade máxima: " + capacidadeTanque + " L");
        } else {
            combustivel += litros;
            System.out.println("Abastecido com " + litros + " L. Combustível atual: " + combustivel + " L");
        }
    }

    public void mostrarInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidade atual: " + velocidade + " km/h");
        System.out.println("Velocidade máxima: " + velocidadeMaxima + " km/h");
        System.out.println("Estado: " + (ligado ? "Ligado" : "Desligado"));
        System.out.println("Combustível no tanque: " + combustivel + " L");
        System.out.println("Capacidade do tanque: " + capacidadeTanque + " L");
        System.out.println("---------------------------");
    }
}
