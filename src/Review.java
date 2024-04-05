class Review {
    private final Hotel hotel;
    private final String reviewText;
    private final int rating;

    public Review(Hotel hotel, String reviewText, int rating) {
        this.hotel = hotel;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public String getReviewText() {
        return reviewText;
    }

    public int getRating() {
        return rating;
    }
}
