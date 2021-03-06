package com.example.carmanagement.domain.model;

//@Entity
//@Table(name = "rent")
//public class Rent extends AbstractEntity<RentId> {
//
//    private LocalDateTime rentTime;
////    private Money total;
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    private List<RentedCar> rentedCarSet = new ArrayList<>();
//
//    @AttributeOverride(name="id", column = @Column(name = "user_id", nullable = false))
//    private UserId userId;
//
//    @Column(name="rent_currency")
//    @Enumerated(EnumType.STRING)
//    private Currency currency;
//
//    public Rent() {
//        super(RentId.randomId(RentId.class));
//    }
//
//    public Rent(LocalDateTime now, @NotNull Currency currency, @NotNull UserId userId) {
//        super(RentId.randomId(RentId.class));
//        this.rentTime = now;
//        this.currency = currency;
//        this.userId = userId;
//    }
//
//
//    public Money total() {
//        return rentedCarSet.stream().map(RentedCar::subtotal).reduce(new Money(currency, 0), Money::add);
//    }
//
//    public RentedCar addCar(@NonNull Car car, @NonNull User user, LocalDateTime from, LocalDateTime to, int days) {
//        Objects.requireNonNull(car, "cannot be null");
//        var item = new RentedCar(car.getId(), car.getPrice(), user.getId(), from, to, days);
//        rentedCarSet.add(item);
//        return item;
//    }
//
//    public void removeCar(@NonNull RentedCarId rentedCarId) {
//        Objects.requireNonNull(rentedCarId, "cannot be null");
//        rentedCarSet.removeIf(c -> c.getCarId().equals(rentedCarId));
//    }
//
//    public List<RentedCar> getAllRentedCars() {
//        return  rentedCarSet;
//    }
//}
