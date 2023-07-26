package Garage;

import java.util.ArrayList;

public class Fees extends Register
implements Membership{
    private double fees;

    public Fees(int garageid, double fees) {
        super(garageid);
        this.fees = fees;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    @Override
    public void displayAllSales(ArrayList<Fees> fees) {
    }
}
