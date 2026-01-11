import ru.netology.company.Company;
import ru.netology.deal.Deal;
import ru.netology.deal.Expenditure;
import ru.netology.deal.Sale;
import ru.netology.taxes.UsnProfit;


public class Main {
    public static void main(String[] args) {
        Company company = new Company("ИП Пупкин с УСН по расходам", new UsnProfit());

        company.shiftMoney(200000);
        company.shiftMoney(-150000);

        Deal[] deals = {
                new Sale("Ноутбук", 50000),
                new Expenditure("Принтер", 15000),
        };

        int initialProfit = company.applyDeals(deals);
        System.out.printf("Разница доходов и расходов на момент старта: %d руб.", initialProfit);
    }
}
