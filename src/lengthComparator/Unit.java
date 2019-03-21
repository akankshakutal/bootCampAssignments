package lengthComparator;

import java.math.BigDecimal;

class Unit {

  private BigDecimal ratio;
  static Unit FEET  = new Unit(new BigDecimal(12));
  static Unit INCH = new Unit(new BigDecimal(1));
  static Unit CM = new Unit(new BigDecimal(0.4));
  static Unit MM = new Unit(new BigDecimal(0.04));

  private Unit(BigDecimal ratio) {
    this.ratio = ratio;
  }


  BigDecimal convert(BigDecimal value){
    return BigDecimal.valueOf(this.ratio.multiply(value).floatValue());
  }

}
