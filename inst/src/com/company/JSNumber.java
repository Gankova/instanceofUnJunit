package com.company;

public class JSNumber<T> {
    private T value;
    private Double doubleRepresentation;

    public static class UnsupportTypeException extends RuntimeException{
        public UnsupportTypeException() {
            super("unsupported type");
        }
    }
    //констурктор принимает на вход value
    public JSNumber(T value) {
        this.value = value;

        if (value instanceof String){
            this.doubleRepresentation = Double.parseDouble((String)value);// parse.... - преобразует строку в ...
            return;

        }
        if (value instanceof Integer){
            this.doubleRepresentation = (double)(int)((Integer)value);
            return;

        }
        if (value instanceof Float) {
            this.doubleRepresentation = (double) (float) ((Float) value);
            return;
        }
        if (value instanceof Double) {
            this.doubleRepresentation = (Double) value;
            return;
        }
        throw new UnsupportTypeException();

    }
    @Override
    public boolean equals(Object o){
        // accept : String, Integer, Float, Double
        // other type: -> Exeption
        if (o.hashCode() == this.hashCode()){
            return true;
        }
        // instanceof => возвращает либо true false
        double oDouble = 0;

        if (o instanceof String){
            oDouble =Double.parseDouble((String)o);
        }
        if (o instanceof Integer){
            oDouble = (Integer)o;
        }
        if (o instanceof Float) {
            oDouble = (Float) o;
        }
        if (o instanceof Double) {
            oDouble = (Double) o;
        }


        return oDouble == this.doubleRepresentation;
    }
}
