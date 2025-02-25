public class Dish {
   int id;
   public String name;
   public String description;
   public double price;
   public int calories;
   public String category;
   public String servingSize;
   protected String dateOfAdding;
   public String cuisineType;
   protected String cookTime;
   protected double specialPrice;
   public String imageURL;
   public boolean avaibility;

    public Dish(int id, boolean avaibility, String name, String description, double price, int calories, String category, String servingSize, String dateOfAdding, String cuisineType, String cookTime, double specialPrice, String imageURL) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.price = price;
        this.calories = calories;
        this.category = category;
        this.servingSize = servingSize;
        this.dateOfAdding = dateOfAdding;
        this.cuisineType = cuisineType;
        this.cookTime = cookTime;
        this.specialPrice = specialPrice;
        this.imageURL = imageURL;
        this.avaibility = avaibility;
    }

    public String DishToString(int id, boolean avaibility, String name, String description, double price, int calories, String category, String servingSize, String dateOfAdding, String cuisineType, String cookTime, double specialPrice, String imageURL) {
        return "Plat [id = " + id + "name=" + name + ", description=" + description + ", price=" + price + ", calories=" + calories + ", category=" + category + ", servingSize=" + servingSize + ", dateOfAdding=" + dateOfAdding + ", cuisineType=" + cuisineType + ", cookTime=" + cookTime + ", specialPrice=" + specialPrice + ", imageURL=" + imageURL + ", avaibility=" + avaibility + "]";
    }






    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }






    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }





    public int getCalories() {
        return this.calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }







    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



}
