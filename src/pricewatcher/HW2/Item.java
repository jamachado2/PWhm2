package pricewatcher.HW2;

import java.text.DecimalFormat;
import java.util.Date;

public class Item {

        private String url;
        private String name;
        private double price;
        private double priceChange;//percentage
        private Date date;
        priceFinder pf = new priceFinder();
        DecimalFormat formatter = new DecimalFormat("#0.00");

        public Item(){
            date = new Date();
        }
        /**
         * Item constructor
         * @param url link to the item
         * @param name name of the item
         * @param price price of item
         * */
        public Item(String url, String name, double price) {
            this.url = url;
            this.name = name;
            this.price = price;
            this.priceChange = 0.0;
            this.date = new Date();
        }

        public String getUrl() {
            return url;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {//current price
            return Double.parseDouble(formatter.format(price));
        }

        public Date getDate() {
            return date;
        }

        public double getprice() {
        return price;
    }

        public double getPriceChange() {
        return Double.parseDouble(formatter.format(priceChange));
    }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setPriceChange(double priceChange) {
            this.priceChange = priceChange;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setName(String name) {
            this.name = name;
        }

    /**
     * checks the price and if there is a change in the price
     * it then calculates the price difference
     * */

    public void checkPrice(){

        double tmp = getPrice();//original price

        setPrice(pf.simulatedPrice());// change the price
        if (tmp != getPrice()){
            double newPrice = tmp - getPrice();
            double tmp2 = ( tmp + getPrice() ) / 2;
            double j = (newPrice / tmp2) * 100;
            setPriceChange(j);
        }
    }
        /*
        * String representation of the Item object*/
        public String toString(){

            return
                "Name:   " + getName() +
                "\nUrl:    " + getUrl()+
                "\nPrice:  $" + getPrice()+
                "\nChange: " + formatter.format(getPriceChange()) + "%"+
                "\nAdded:  " + getDate();
            }
        }
