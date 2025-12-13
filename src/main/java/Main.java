import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String greeting = "Здравствуйте! Вас приветствует консольное приложение '24 часа Ле-Мана'!\n" +
                "Для определения лидера гонки введите данные %d автомобилей";
        Scanner scanner = new Scanner(System.in);

        int participantCount = 3;
        Race race = new Race();

        System.out.println("=".repeat(greeting.length()));
        System.out.printf((greeting) + "%n", participantCount);

        for (int i = 1; i <= participantCount; ++i) {

            System.out.println("Введите название машины №" + i);
            String name = scanCarName(scanner);

            System.out.println("Введите скорость машины №" + i);
            int speed = scanCarSpeed(scanner);

            race.processParticipant(new Car(name, speed));
        }

        System.out.println("Самая быстрая машина: " + race.leaderName);

        System.out.println("=".repeat(greeting.length()));
    }

    private static String scanCarName(Scanner scanner) {
        while (true) {
            String name = scanner.nextLine();
            if (name.isBlank()) {
                System.out.println("Название машины не может быть пустым, попробуйте еще раз");
            } else {
                return name;
            }
        }
    }

    private static int scanCarSpeed(Scanner scanner) {
        while (true) {
            int speed;
            if (scanner.hasNextInt()) {
                speed = scanner.nextInt();
                scanner.nextLine();//нужно, чтобы съедать символ переноса строки
            } else {
                System.out.println("Скорость должна быть указана в целочисленном типе, попробуйте еще раз");
                scanner.nextLine();//нужно, чтобы съедать символ переноса строки
                continue;
            }

            if (!(speed >=0 && speed <= 250)) {
                System.out.println("Скорость машины должна быть в допустимом диапазоне от 0 до 250, попробуйте еще раз");
            } else {
                return speed;
            }
        }
    }
}