package dat3.cars.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  @Column(name="car_brand",length = 50, nullable = false)
  String brand;

  @Column(name="car_model",length = 60, nullable = false)
  String model;

  @Column(name="rental_price-day")
  double pricePrDay;

  @Column(name="max_discount")
  int bestDiscount;

}
