package ru.netology.taxes;

// УСН доходы минус расходы — налог 15% от разницы доходов и расходов
public class UsnProfit extends TaxSystem{
    private static final double TAX_RATE = 0.15;

    @Override
    public int calcTaxFor(int debit, int credit) {
        int profit = debit - credit;
        int value = (int) Math.round(profit * TAX_RATE);

        return Math.max(value, 0);
    };
}
