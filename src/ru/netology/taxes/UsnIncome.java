package ru.netology.taxes;

// УСН доходы — налог 6% от доходов
public class UsnIncome extends TaxSystem {
    private static final double TAX_RATE = 0.06;

    @Override
    public int calcTaxFor(int debit, int credit) {
        return (int) Math.round(debit * TAX_RATE);
    };
}
