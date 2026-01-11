package ru.netology.company;

import ru.netology.deal.Deal;
import ru.netology.taxes.TaxSystem;

public class Company {
    private final String title;
    private TaxSystem taxSystem;
    private int debit;
    private int credit;

    public Company (String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
        this.debit = 0;
        this.credit = 0;
    }

    public void setTaxSystem (TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            this.debit += amount;
        } else if (amount < 0) {
            this.credit += Math.abs(amount);
        }
    }

    public void payTaxes() {
        int taxAmount = this.taxSystem.calcTaxFor(debit, credit);

        this.debit = 0;
        this.credit = 0;

        System.out.printf("Компания %s уплатила налог в размере: %d руб.\n", this.title, taxAmount);
    }

    public int applyDeals(Deal[] deals) {
        if (deals == null) return 0;

        int initialDebit = this.debit;
        int initialCredit = this.credit;

        for (Deal deal : deals) {
            if (deal != null) {
                System.out.println("Сделка: " + deal.getComment());
                this.debit += deal.getDebitChange();
                this.credit += deal.getCreditChange();
            }
        }

        this.payTaxes();

        return (initialDebit - initialCredit);
    }
}
