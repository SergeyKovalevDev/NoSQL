import redis.clients.jedis.Jedis;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try (Jedis jedis = new Jedis()) {
            System.out.println(jedis.ping());
            jedis.set("TestKey","TestValue");
            System.out.println("Метод для проверки наличия индекса");
            System.out.println(jedis.exists("TestKey"));
            System.out.println(jedis.exists("FalseTestKey"));

            System.out.println("Метод добавления словаря");
            System.out.println(jedis.hset("TestSetKey", "Field", "Value"));
            System.out.println(jedis.hset("TestSetKey", "another", "testvalue"));
            //Вывод в результат в одного значения
            System.out.println(jedis.hget("TestSetKey", "another"));

            //Карта всех значений
            Map<String, String> fields = jedis.hgetAll("TestSetKey");
            for (String field:fields.keySet()){
                System.out.println(field);
            }
            //Вывод значения конкретно поля уже из полученного множества
            System.out.println(fields.get("another"));
            //Удаляем карту
            System.out.println(jedis.del("TestSetKey"));
        }
    }
}
