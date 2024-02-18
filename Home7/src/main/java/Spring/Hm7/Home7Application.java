package Spring.Hm7;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*Условие:
Вам предстоит создать приложение для управления списком задач с использованием Spring Boot и Spring Data JPA.
 Требуется реализовать следующие функции:

Добавление задачи.
Просмотр всех задач.
Просмотр задач по статусу (например, "завершена", "в процессе", "не начата").
Изменение статуса задачи.
Удаление задачи.
Структура задачи:

ID (автоинкрементное)
Описание (не может быть пустым)
Статус (одно из значений: "не начата", "в процессе", "завершена")
Дата создания (автоматически устанавливается при создании задачи)


Домашнее задание

1) Выполнить задание к уроку 5
2) Добавить сущность исполнитель
3) Каждая задача может быть назначена на исполнителя
4) Исполнителей задачи может быть несколько

Дополнительное задание
Релизовать автоматическое документирование API c помощью springdoc

 */

@SpringBootApplication
public class Home7Application {

	public static void main(String[] args) {
	SpringApplication.run(Home7Application.class);
//		UserRepository  userRepository = SpringApplication.run(Home6Application.class,args).getBean(UserRepository.class);
//		User Alex = new User();
//		Alex.setEmail("jujax@mail.ru");
//		Alex.setName("Alex");
//		Alex.setLogin("Alex");
//		Alex.setId(999L);
//		Alex.setPassword("pass");
//		Alex.setRole(Roles.ADMIN);
//		userRepository.save(Alex);
	}

}
