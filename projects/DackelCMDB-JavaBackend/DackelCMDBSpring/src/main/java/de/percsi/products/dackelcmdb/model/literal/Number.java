package de.percsi.products.dackelcmdb.model.literal;


public class Number extends ValueType<Double>{

  private Number(Double value) {
    super(value);
  }

  public static Number of(Double value) {
    return new Number(value);
  }

  public static Number of(Integer value) {
    return new Number(Double.valueOf(value));
  }

  public static Number of(String value) {
    return new Number(Double.valueOf(value));
  }

  public double getDouble() {
    return this.getValue();
  }

  public long getLong() {
    return Math.round(this.getValue());
  }
}
