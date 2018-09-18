package com.codingmanstudio.courses.bootstrap;

import com.codingmanstudio.courses.domain.*;
import com.codingmanstudio.courses.repository.*;
import com.codingmanstudio.courses.Utils.EncrytedPasswordUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final AccountRepository accountRepository;
    private final CategoryRepository categoryRepository;
    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;
    private final SectionRepository sectionRepository;
    private final InstructorRepository instructorRepository;
    private final TopicRepository topicRepository;
    private final AccountCourseRepository accountCourseRepository;

    public DataLoader(RoleRepository roleRepository, AccountRepository accountRepository, CategoryRepository categoryRepository, CourseRepository courseRepository, LessonRepository lessonRepository, SectionRepository sectionRepository, InstructorRepository instructorRepository, TopicRepository topicRepository, AccountCourseRepository accountCourseRepository) {
        this.roleRepository = roleRepository;
        this.accountRepository = accountRepository;
        this.categoryRepository = categoryRepository;
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
        this.sectionRepository = sectionRepository;
        this.instructorRepository = instructorRepository;
        this.topicRepository = topicRepository;
        this.accountCourseRepository = accountCourseRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {

            //Init topic--------------------------------------------------------------------------------------------------------

            Topic website = new Topic();
            website.setName("Website programming");
            Topic savedTopicWebsite = topicRepository.save(website);

            Topic frontend = new Topic();
            frontend.setName("Front-end");
            Topic savedTopicFrontend = topicRepository.save(frontend);

            Topic backend = new Topic();
            backend.setName("Back-end");
            Topic savedTopicBackend = topicRepository.save(backend);


            //Init Course ----------------------------------------------------------------------------------------------------------

            Course nodeJs = new Course();
            nodeJs.setName("Node JS Basic");
            nodeJs.setCost(300L);
            nodeJs.setRating(3L);
            nodeJs.getTopics().add(savedTopicWebsite);
            nodeJs.getTopics().add(savedTopicBackend);
            nodeJs.setDescription("Similarly, any interface we define by extending the ExtendedRepository interface will have the same method");
            nodeJs.setDateCreate("03-04-2018");

            Course reactJs = new Course();
            reactJs.setName("React JS Basic");
            reactJs.getTopics().add(savedTopicWebsite);
            reactJs.getTopics().add(savedTopicFrontend);
            reactJs.setCost(350L);
            reactJs.setRating(3L);
            reactJs.setDescription("Similarly, any interface we define by extending the ExtendedRepository interface will have the same method");
            reactJs.setDateCreate("03-04-2018");

            Course vueJs = new Course();
            vueJs.getTopics().add(savedTopicWebsite);
            vueJs.getTopics().add(savedTopicFrontend);
            vueJs.setName("Vue JS Basic");
            vueJs.setCost(350L);
            vueJs.setRating(3L);
            vueJs.setDescription("have the same method");
            vueJs.setDateCreate("03-04-2018");

            //Init category----------------------------------------------------------------------------------------------------

            Category cat1 = new Category();
            cat1.setName("Programming");
            vueJs.setCategory(cat1);
            cat1.getCourses().add(vueJs);
            cat1.setDescription("That’s all you have to do to let Hibernate generate UUIDs as primary key values. You can see an example of it in the following code snippet");

            Category cat2 = new Category();
            nodeJs.setCategory(cat2);
            reactJs.setCategory(cat2);
            cat2.getCourses().add(nodeJs);
            cat2.getCourses().add(reactJs);
            cat2.setName("Business");
            cat2.setDescription("That’s all you have to do to let Hibernate generate UUIDs as primary key values. You can see an example of it in the following code snippet");

            //Init Lesson ----------------------------------------------------------------------------------------------------------

            Lesson nodeJsLesson1 = new Lesson();
            nodeJsLesson1.setName("Node js chap 1");
            nodeJsLesson1.setDescription("YG Entertainment Inc. (thay mặt cho YG Entertainment); ASCAP, Abramus Digital, SODRAC, UMPG Publishing, UBEM và 13 Hội bảo vệ quyền âm nhạc");
            nodeJsLesson1.setCourse(nodeJs);
            nodeJs.getLessons().add(nodeJsLesson1);

            Lesson nodeJsLesson2 = new Lesson();
            nodeJsLesson2.setName("Node js chap 2");
            nodeJsLesson2.setDescription("Warning: Establishing SSL connection without server's identity verification is not recommended [duplicate]");
            nodeJsLesson2.setCourse(nodeJs);
            nodeJs.getLessons().add(nodeJsLesson2);

            Lesson nodeJsLesson3 = new Lesson();
            nodeJsLesson3.setName("Node js chap 3");
            nodeJsLesson3.setDescription("Establishing SSL connection without server's identity verification is not recommended." +
                    " According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set.");
            nodeJsLesson3.setCourse(nodeJs);
            nodeJs.getLessons().add(nodeJsLesson3);

            Lesson reactJsLesson1 = new Lesson();
            reactJsLesson1.setName("React js chap 1");
            reactJsLesson1.setDescription("YG Entertainment Inc. (thay mặt cho YG Entertainment); ASCAP, Abramus Digital, SODRAC, UMPG Publishing, UBEM và 13 Hội bảo vệ quyền âm nhạc");
            reactJsLesson1.setCourse(reactJs);
            reactJs.getLessons().add(reactJsLesson1);

            Lesson reactJsLesson2 = new Lesson();
            reactJsLesson2.setName("React js chap 2");
            reactJsLesson2.setDescription("Cascading the one-to-one persist operation\n" +
                    "The CascadeType.PERSIST comes along with the CascadeType.ALL configuration, so we only have to persist the Post entity, and the associated PostDetails entity is persisted as well");
            reactJsLesson2.setCourse(reactJs);
            reactJs.getLessons().add(reactJsLesson2);


            Lesson reactJsLesson3 = new Lesson();
            reactJsLesson3.setName("React js chap 3");
            reactJsLesson3.setDescription("Cascading the one-to-one persist operation\n" +
                    "The CascadeType.PERSIST comes along with the CascadeType.ALL configuration, so we only have to persist the Post entity, and the associated PostDetails entity is persisted as well");
            reactJsLesson3.setCourse(reactJs);
            reactJs.getLessons().add(reactJsLesson3);

            Lesson vueJsLesson1 = new Lesson();
            vueJsLesson1.setName("Vue js chap 1");
            vueJsLesson1.setDescription("Cascading the one-to-one persist operation\n" +
                    "The CascadeType.PERSIST comes along with the CascadeType.ALL configuration, so we only have to persist the Post entity, and the associated PostDetails entity is persisted as well");
            vueJsLesson1.setCourse(vueJs);
            vueJs.getLessons().add(vueJsLesson1);

            Lesson vueJsLesson2 = new Lesson();
            vueJsLesson2.setName("Vue js chap 2");
            vueJsLesson2.setDescription("Cascading the one-to-one persist operation\n" +
                    "The CascadeType.PERSIST comes along with the CascadeType.ALL configuration, so we only have to persist the Post entity, and the associated PostDetails entity is persisted as well");
            vueJsLesson2.setCourse(vueJs);
            vueJs.getLessons().add(vueJsLesson2);

            Lesson vueJsLesson3 = new Lesson();
            vueJsLesson3.setName("Vue js chap 3");
            vueJsLesson3.setDescription("Cascading the one-to-one persist operation\n" +
                    "The CascadeType.PERSIST comes along with the CascadeType.ALL configuration, so we only have to persist the Post entity, and the associated PostDetails entity is persisted as well");
            vueJsLesson3.setCourse(vueJs);
            vueJs.getLessons().add(vueJsLesson3);

            //Init Section ----------------------------------------------------------------------------------------------------------

            Section sec1Node1 = new Section();
            sec1Node1.setDescription("Sự phù hợp với đặc tả của JPA");
            sec1Node1.setContent("Hibernate là cài đặt ORM Java thành công nhất. Không ngạc nhiên khi mà các đặc tả cho Java persistence API (JPA) bị ảnh hưởng nhiều bởi Hibernate API. Cũng không ngạc nhiên khi Hibernate là ORM Framework phổ biến nhất.");
            sec1Node1.setLesson(nodeJsLesson1);
            nodeJsLesson1.getSections().add(sec1Node1);

            Section sec2Node1 = new Section();
            sec2Node1.setDescription(" Sự khác nhau giữa các hành động thực thi");
            sec2Node1.setContent("Các method persist, save, update, merge, saveOrUpdate không lập tức đưa ra kết quả tương ứng SQL UPDATE hoặc INSERT. Thực tế thì việc cập nhật dữ liệu vào database xảy ra khi transaction được commit hoặc flushing session. Cũng không ngạc nhiên khi Hibernate là ORM Framework phổ biến nhất.");
            sec2Node1.setLesson(nodeJsLesson1);
            nodeJsLesson1.getSections().add(sec2Node1);

            Section sec3Node1 = new Section();
            sec3Node1.setDescription("Persist");
            sec3Node1.setContent("Điều gì xảy ra sau khi method persist được gọi? Đối tượng person bị đổi trạng thái từ transient sang persistent. Đối tượng vào trong persistence context nhưng vẫn chưa được lưu vào database.");
            sec3Node1.setLesson(nodeJsLesson1);
            nodeJsLesson1.getSections().add(sec3Node1);

            Section sec1Node2 = new Section();
            sec1Node2.setDescription("Sự phù hợp với đặc tả của JPA");
            sec1Node2.setContent("Hibernate là cài đặt ORM Java thành công nhất. Không ngạc nhiên khi mà các đặc tả cho Java persistence API (JPA) bị ảnh hưởng nhiều bởi Hibernate API. Cũng không ngạc nhiên khi Hibernate là ORM Framework phổ biến nhất.");
            sec1Node2.setLesson(nodeJsLesson2);
            nodeJsLesson2.getSections().add(sec1Node2);

            Section sec2Node2 = new Section();
            sec2Node2.setDescription(" Sự khác nhau giữa các hành động thực thi");
            sec2Node2.setContent("Các method persist, save, update, merge, saveOrUpdate không lập tức đưa ra kết quả tương ứng SQL UPDATE hoặc INSERT. Thực tế thì việc cập nhật dữ liệu vào database xảy ra khi transaction được commit hoặc flushing session. Cũng không ngạc nhiên khi Hibernate là ORM Framework phổ biến nhất.");
            sec2Node2.setLesson(nodeJsLesson2);
            nodeJsLesson2.getSections().add(sec2Node2);

            Section sec3Node2 = new Section();
            sec3Node2.setDescription("Persist");
            sec3Node2.setContent("Điều gì xảy ra sau khi method persist được gọi? Đối tượng person bị đổi trạng thái từ transient sang persistent. Đối tượng vào trong persistence context nhưng vẫn chưa được lưu vào database.");
            sec3Node2.setLesson(nodeJsLesson2);
            nodeJsLesson2.getSections().add(sec3Node2);

            Section sec1Node3 = new Section();
            sec1Node3.setDescription("Sự phù hợp với đặc tả của JPA");
            sec1Node3.setContent("Hibernate là cài đặt ORM Java thành công nhất. Không ngạc nhiên khi mà các đặc tả cho Java persistence API (JPA) bị ảnh hưởng nhiều bởi Hibernate API. Cũng không ngạc nhiên khi Hibernate là ORM Framework phổ biến nhất.");
            sec1Node3.setLesson(nodeJsLesson3);
            nodeJsLesson3.getSections().add(sec1Node3);

            Section sec2Node3 = new Section();
            sec2Node3.setDescription(" Sự khác nhau giữa các hành động thực thi");
            sec2Node3.setContent("Các method persist, save, update, merge, saveOrUpdate không lập tức đưa ra kết quả tương ứng SQL UPDATE hoặc INSERT. Thực tế thì việc cập nhật dữ liệu vào database xảy ra khi transaction được commit hoặc flushing session. Cũng không ngạc nhiên khi Hibernate là ORM Framework phổ biến nhất.");
            sec2Node3.setLesson(nodeJsLesson3);
            nodeJsLesson3.getSections().add(sec2Node3);

            Section sec3Node3 = new Section();
            sec3Node3.setDescription("Persist");
            sec3Node3.setContent("Điều gì xảy ra sau khi method persist được gọi? Đối tượng person bị đổi trạng thái từ transient sang persistent. Đối tượng vào trong persistence context nhưng vẫn chưa được lưu vào database.");
            sec3Node3.setLesson(nodeJsLesson3);
            nodeJsLesson3.getSections().add(sec3Node3);

            //Init Role ----------------------------------------------------------------------------------------------------------
            Role role_user = new Role();
            role_user.setRole("ROLE_USER");
            Role saved_role_user = roleRepository.save(role_user);

            Role role_learner = new Role();
            role_learner.setRole("ROLE_LEARNER");
            Role saved_role_learner = roleRepository.save(role_learner);

            Role role_admin = new Role();
            role_admin.setRole("ROLE_ADMIN");
            Role saved_role_admin = roleRepository.save(role_admin);



            //Save Category, Role, Lesson, Course, Section ----------------------------------------------------------------------------------------------------------

            Category savedcat1 = categoryRepository.save(cat1);
            Category savedcat2 = categoryRepository.save(cat2);

            Course savedVueJs = courseRepository.save(vueJs);
            Course savedNodeJs = courseRepository.save(nodeJs);
            Course savedReactJS = courseRepository.save(reactJs);

            Lesson savedNodeJsLesson1 = lessonRepository.save(nodeJsLesson1);
            Lesson savedNodeJsLesson2 = lessonRepository.save(nodeJsLesson2);
            Lesson savedNodeJsLesson3 = lessonRepository.save(nodeJsLesson3);
            Lesson saveReactJsLesson1 = lessonRepository.save(reactJsLesson1);
            Lesson saveReactJsLesson2 = lessonRepository.save(reactJsLesson2);
            Lesson saveReactJsLesson3 = lessonRepository.save(reactJsLesson3);
            Lesson savedVueJsLesson1 = lessonRepository.save(vueJsLesson1);
            Lesson savedVueJsLesson2 = lessonRepository.save(vueJsLesson2);
            Lesson savedVueJsLesson3 = lessonRepository.save(vueJsLesson3);

            //Init Instructor ----------------------------------------------------------------------------------------------------------

            Instructor alex = new Instructor();
            alex.setName("Alex Jefferson");
            alex.setEmail("alex@gmail.com");
            alex.setCompany("FPT");
            alex.setQuote("Không có gì quý hơn độc lập tự do hạnh phúc");
            alex.getCourses().add(savedNodeJs);
            alex.getCourses().add(savedVueJs);
            Instructor savedA = instructorRepository.save(alex);

            Instructor quill = new Instructor();
            quill.setName("Quilliam Johnson");
            quill.setCompany("TMA Solutions");
            quill.setEmail("quill@tma.com");
            quill.setQuote("This is fucking awesome");
            quill.getCourses().add(savedReactJS);
            Instructor savedQ = instructorRepository.save(quill);

            //Init Account ----------------------------------------------------------------------------------------------------------

            Account user1 = new Account();
            user1.setUsername("quang");
            user1.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            user1.getRoles().add(saved_role_admin);
            user1.getRoles().add(saved_role_user);
            user1.addCourse(savedNodeJs);
            user1.addCourse(savedReactJS);
            Account savedUser1 = accountRepository.save(user1);

            Account user2 = new Account();
            user2.setUsername("thang");
            user2.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            user2.getRoles().add(saved_role_learner);
            Account savedUser2= accountRepository.save(user2);

            Account user3 = new Account();
            user3.setUsername("hai");
            user3.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            Account savedUser3 = accountRepository.save(user3);

//            savedUser1.getCourses().add(ac1);
//            savedNodeJs.getAccounts().add(ac1);
//
//            accountRepository.save(savedUser1);
//            courseRepository.save(savedNodeJs);
//            for (Section s: savedNodeJsLesson1.getSections()) {
//                System.out.println(s.getDescription());
//            }
//            System.out.println("--------------------");
//
//            for(Course c: savedA.getCourses()){
//                System.out.println(c.getName());
//            }

            Optional<Account> accountOptional = accountRepository.findByUsername("quang");
            if (accountOptional.isPresent()) {
                System.out.println("found");
                System.out.println(accountOptional.get().getEncrytedPassword());

                System.out.println(accountOptional.get().getCourses().size());
                for (AccountCourse ac: accountOptional.get().getCourses()
                     ) {
                    System.out.println(ac.getCourse().getName());
                }
            }

        }


    }

}
