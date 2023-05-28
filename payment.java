import java.util.Date;
import java.util.*;

public class payment {
    public int payment_id;
    public int customer_id;
    public int provider_id;
    public Date date_time;
    public int car_id;
    public float price;
    public PaymentMethod payment_method;

    public enum PaymentMethod {
        PAYPAL,
        CARD
    }

    // Constructor
    public payment(int payment_id, int customer_id, int provider_id, Date date_time, int car_id, float price, PaymentMethod payment_method) {
        this.payment_id = payment_id;
        this.customer_id = customer_id;
        this.provider_id = provider_id;
        this.date_time = date_time;
        this.car_id = car_id;
        this.price = price;
        this.payment_method = payment_method;
    }

    // Getters
    public int getPaymentId() {
        return payment_id;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public int getProviderId() {
        return provider_id;
    }

    public Date getDateTime() {
        return date_time;
    }

    public int getCarId() {
        return car_id;
    }

    public float getPrice() {
        return price;
    }

    public PaymentMethod getPaymentMethod() {
        return payment_method;
    }

    // Methods
    public void payCard() {
        Scanner scanner = new Scanner(System.in);
        boolean validCardNumber = false;
        String cardNumber = "";

        while (!validCardNumber) {
            System.out.println("Enter the card number:");
            cardNumber = scanner.nextLine();

            // Check if the card number has the correct number of digits (16)
            if (cardNumber.length() == 16) {
                validCardNumber = true;
            } else {
                System.out.println("Invalid card number. Please enter a 16-digit card number.");
            }
        }

        System.out.println("Enter the name on the card:");
        String cardName = scanner.nextLine();

        // Expiration date validation
        boolean validExpirationDate = false;
        String expirationDate = "";

        while (!validExpirationDate) {
            System.out.println("Enter the expiration date (MM/YY):");
            expirationDate = scanner.nextLine();

            // Validate expiration date format (MM/YY)
            if (expirationDate.matches("\\d{2}/\\d{2}")) {
                validExpirationDate = true;
            } else {
                System.out.println("Invalid expiration date format. Please enter the expiration date in the format MM/YY.");
            }
        }

        System.out.println("Enter the CVV number:");
        String cvv = scanner.nextLine();

        // CVV validation
        boolean validCVV = false;

        while (!validCVV) {
            // Validate CVV length (3 digits)
            if (cvv.length() == 3) {
                validCVV = true;
            } else {
                System.out.println("Invalid CVV. Please enter a 3-digit CVV number.");
            }
        }

        // Get the card balance from the appropriate source
        float cardBalance ; //API call to the bank in order to obtain the balance


        float price = getPrice();

        if (cardBalance >= price) {
            cardBalance -= price;
            //API call to the bank to report the transaction
            paymentApproved();
        } else {
            // If the card balance is less than the price, call the paymentRejected() method
            paymentRejected();
        }
    }

    public void payPayPal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your PayPal account email:");
        String email = scanner.nextLine();

        System.out.println("Enter your PayPal account password:");
        String password = scanner.nextLine();

        // Validate PayPal account information
        boolean validAccountInfo = true ; //validatePayPalAccount(email, password)

        if (validAccountInfo) {
            // Assuming the price is obtained from somewhere
            float price = getPrice(); // Replace with your implementation

            // Get the PayPal account balance from the appropriate source
            float accountBalance;  //getPayPalAccountBalance(email); // Replace with your implementation

            if (accountBalance >= price) {

                accountBalance -= price;
                paymentApproved();

            } else {
                paymentRejected();
            }
        } else {

            paymentRejected();
        }
    }

    public void paymentRejected() {

        System.out.println("Payment rejected.");
        //redirect to the default payment page
    }

    public void paymentApproved() {
        System.out.println("Payment approved.");
        //redirect to home page
    }
}
