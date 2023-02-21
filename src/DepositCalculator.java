import java.util.Scanner;

public class DepositCalculator {

    double calculate_Complex_Percent(double firstAngle, double secondAngle, int thirdAngle) {
        double pay = firstAngle * Math.pow((1 + secondAngle / 12), 12 * thirdAngle);
        return getRound(pay, 2);
    }

    double calculate_Simple_Percent(double doubleAmount, double double_year_rate, int deposit_period) {
        return getRound(doubleAmount + doubleAmount * double_year_rate * deposit_period, 2);
    }

    double getRound(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void showDoImportantJob() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double out = 0;
        if (action == 1) {
            out = calculate_Simple_Percent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculate_Complex_Percent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().showDoImportantJob();
    }

}

