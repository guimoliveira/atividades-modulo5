class Carro implements IMeioTransporte {

    @Override
    public void acelerar() {
        IO.println("vruuuuum");
    }

    @Override
    public void frear() {
        IO.println("iirrrrrr");
    }
}
