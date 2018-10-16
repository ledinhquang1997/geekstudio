package com.codingmanstudio.courses.bootstrap;

import com.codingmanstudio.courses.domain.*;
import com.codingmanstudio.courses.repository.*;
import com.codingmanstudio.courses.Utils.EncrytedPasswordUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    private final AdminRepository adminRepository;

    public DataLoader(RoleRepository roleRepository, AccountRepository accountRepository, CategoryRepository categoryRepository, CourseRepository courseRepository, LessonRepository lessonRepository, SectionRepository sectionRepository, InstructorRepository instructorRepository, TopicRepository topicRepository, AdminRepository adminRepository) {
        this.roleRepository = roleRepository;
        this.accountRepository = accountRepository;
        this.categoryRepository = categoryRepository;
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
        this.sectionRepository = sectionRepository;
        this.instructorRepository = instructorRepository;
        this.topicRepository = topicRepository;
        this.adminRepository = adminRepository;
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


            Topic bussiness = new Topic();
            bussiness.setName("Bussiness");
            Topic savedBussiness = topicRepository.save(bussiness);

            Topic advertisement = new Topic();
            advertisement.setName("Advertisement");
            Topic savedAd = topicRepository.save(advertisement);

            Topic influncerMarketing = new Topic();
            influncerMarketing.setName("Influencer marketing");
            Topic savedInfluncerMarketing = topicRepository.save(influncerMarketing);


            Topic onlineMakerting = new Topic();
            onlineMakerting.setName("Online Makerting");
            Topic savedonlineMakerting = topicRepository.save(onlineMakerting);


            Topic seo = new Topic();
            seo.setName("SEO");
            Topic savedSeo = topicRepository.save(seo);


            Topic engineering = new Topic();
            engineering.setName("Engineering");
            Topic savedEngineering = topicRepository.save(engineering);
            //Init Course ----------------------------------------------------------------------------------------------------------

            Course nodeJs = new Course();
            nodeJs.setName("Conquer Node JS");
            nodeJs.setCost(300L);
            nodeJs.setRating(1);
            nodeJs.setAmountStudent(303);
            nodeJs.setImage("nodejs1.jpg");
            nodeJs.getTopics().add(savedTopicWebsite);
            nodeJs.getTopics().add(savedTopicBackend);
            nodeJs.setDescription("Node.js là một hệ thống phần mềm được thiết kế để viết các ứng dụng internet có khả năng mở rộng, đặc biệt là máy chủ web. Chương trình được viết bằng JavaScript, sử dụng kỹ thuật điều khiển theo sự kiện, nhập/xuất không đồng bộ để tối tiểu tổng chi phí và tối đại khả năng mở rộng");
            nodeJs.setDateCreate("03-04-2018");

            Course reactJs = new Course();
            reactJs.setName("ReactJS is easy");
            reactJs.getTopics().add(savedTopicWebsite);
            reactJs.getTopics().add(savedTopicFrontend);
            reactJs.setImage("reactjs.jpg");
            reactJs.setAmountStudent(401);
            reactJs.setCost(350L);
            reactJs.setRating(1.4);
            reactJs.setDescription("Similarly, any interface we define by extending the ExtendedRepository interface will have the same method");
            reactJs.setDateCreate("03-04-2018");

            Course vueJs = new Course();
            vueJs.getTopics().add(savedTopicWebsite);
            vueJs.getTopics().add(savedTopicFrontend);
            vueJs.setName("Vue JS in real word");
            vueJs.setCost(350L);
            vueJs.setRating(3.4);
            vueJs.setImage("vuejs.png");
            vueJs.setAmountStudent(233);
            vueJs.setDescription("Vue.js, gọi tắt là Vue, là một framework linh động dùng để xây dựng giao diện người dùng. Khác với các framework nguyên khối, Vue được thiết kế từ đầu theo hướng cho phép và khuyến khích việc phát triển ứng dụng theo các bước");
            vueJs.setDateCreate("03-04-2018");

            Course business = new Course();
            business.getTopics().add(savedBussiness);
            business.setName("Market Leader");
            business.setCost(350L);
            business.setRating(2.4);
            business.setImage("business1.jpg");
            business.setAmountStudent(123);
            business.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            business.setDateCreate("03-04-2018");

            Course marketingCourse = new Course();
            marketingCourse.getTopics().add(savedBussiness);
            marketingCourse.setName("Marketing Leader");
            marketingCourse.setCost(350L);
            marketingCourse.setRating(3.6);
            marketingCourse.setImage("marketing.jpg");
            marketingCourse.setAmountStudent(923);
            marketingCourse.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            marketingCourse.setDateCreate("03-04-2018");

            Course electronicCourse = new Course();
            electronicCourse.getTopics().add(savedEngineering);
            electronicCourse.setName("Master Electrons");
            electronicCourse.setCost(350L);
            electronicCourse.setRating(4.5);
            electronicCourse.setImage("electonic.jpg");
            electronicCourse.setAmountStudent(923);
            electronicCourse.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            electronicCourse.setDateCreate("03-04-2018");

            Course dockerCourse = new Course();
            dockerCourse.getTopics().add(savedBussiness);
            dockerCourse.setName("Docker - magic tool");
            dockerCourse.setCost(350L);
            dockerCourse.setRating(2.5);
            dockerCourse.setImage("docker.png");
            dockerCourse.setAmountStudent(943);
            dockerCourse.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            dockerCourse.setDateCreate("03-04-2018");

            Course phpCourse = new Course();
            phpCourse.getTopics().add(savedTopicBackend);
            phpCourse.setName("Website with PHP");
            phpCourse.setCost(353L);
            phpCourse.setRating(3.1);
            phpCourse.setImage("php.jpg");
            phpCourse.setAmountStudent(716);
            phpCourse.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            phpCourse.setDateCreate("03-04-2018");

            Course cScharp = new Course();
            cScharp.getTopics().add(savedTopicBackend);
            cScharp.setName("C# Core");
            cScharp.setCost(350L);
            cScharp.setRating(4.2);
            cScharp.setImage("csharp1.png");
            cScharp.setAmountStudent(12);
            cScharp.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            cScharp.setDateCreate("03-04-2018");

            Course java = new Course();
            java.getTopics().add(savedTopicBackend);
            java.setName("Java Core");
            java.setCost(120L);
            java.setRating(4);
            java.setImage("java.jpg");
            java.setAmountStudent(12);
            java.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            java.setDateCreate("03-04-2018");


            Course css = new Course();
            css.getTopics().add(savedTopicBackend);
            css.setName("CSS wonderful");
            css.setCost(350L);
            css.setRating(4.7);
            css.setImage("css-wonderful.png");
            css.setAmountStudent(12);
            css.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            css.setDateCreate("03-04-2018");

            Course linux = new Course();
            linux.getTopics().add(savedTopicBackend);
            linux.setName("Linux");
            linux.setCost(350L);
            linux.setRating(4.7);
            linux.setImage("css-wonderful.png");
            linux.setAmountStudent(12);
            linux.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            linux.setDateCreate("03-04-2018");


            Course html = new Course();
            html.getTopics().add(savedTopicBackend);
            html.setName("HTML is not programming lang");
            html.setCost(350L);
            html.setRating(3.4);
            html.setImage("html.jpg");
            html.setAmountStudent(12);
            html.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            html.setDateCreate("03-04-2018");


            Course typeScript = new Course();
            typeScript.getTopics().add(savedTopicBackend);
            typeScript.setName("TypeScript course");
            typeScript.setCost(350L);
            typeScript.setRating(3.9);
            typeScript.setImage("typescript.png");
            typeScript.setAmountStudent(12);
            typeScript.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            typeScript.setDateCreate("03-04-2018");


            //Init category----------------------------------------------------------------------------------------------------

            Category cat1 = new Category();
            cat1.setName("Programming");
            cat1.getTopics().add(savedTopicWebsite);
            cat1.getTopics().add(savedTopicBackend);
            cat1.getTopics().add(savedTopicFrontend);

            vueJs.setCategory(cat1);
            cat1.getCourses().add(vueJs);

            cat1.getCourses().add(cScharp);
            cScharp.setCategory(cat1);

            cat1.getCourses().add(phpCourse);
            phpCourse.setCategory(cat1);

            cat1.getCourses().add(dockerCourse);
            dockerCourse.setCategory(cat1);

            cat1.getCourses().add(java);
            java.setCategory(cat1);

            cat1.getCourses().add(typeScript);
            typeScript.setCategory(cat1);

            cat1.getCourses().add(css);
            css.setCategory(cat1);

            cat1.getCourses().add(html);
            html.setCategory(cat1);

            cat1.getCourses().add(linux);
            linux.setCategory(cat1);

            cat1.setImage("programming-icon.png");
            cat1.setDescription("C#, Java, Javascript, PHP, ReactJS, VueJS, Node JS,...");

            Category cat2 = new Category();
            nodeJs.setCategory(cat2);
            reactJs.setCategory(cat2);
            cat2.getCourses().add(nodeJs);
            cat2.getCourses().add(reactJs);
            cat2.setName("Business");
            cat2.setImage("business-icon.png");
            cat2.setDescription("Sale, Manage, Statistic, Products,...");

            Category cat3 = new Category();
            cat3.setName("Marketing");
            cat3.setImage("marketing-icon.png");
            cat3.setDescription("SEO, Internet Marketing, Influencer Marketing, PPI, Online viral marketing,...");
            cat3.getTopics().add(savedSeo);
            cat3.getTopics().add(savedInfluncerMarketing);
            cat3.getTopics().add(savedonlineMakerting);
            cat3.getTopics().add(savedAd);

            Category cat4 = new Category();
            cat4.setImage("engineering-icon.png");
            cat4.setName("Engineering");
            cat4.setDescription("Chemical engineering, Civil engineering, Electical, Process engineering,...");


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

            Role role_instructor = new Role();
            role_instructor.setRole("ROLE_INSTRUCTOR");
            Role saved_role_instructor = roleRepository.save(role_instructor);

            //Save Category, Role, Lesson, Course, Section ----------------------------------------------------------------------------------------------------------

            Category savedcat1 = categoryRepository.save(cat1);
            Category savedcat2 = categoryRepository.save(cat2);
            Category savedcat3 = categoryRepository.save(cat3);
            Category savedcat4 = categoryRepository.save(cat4);

            Course savedVueJs = courseRepository.save(vueJs);
            Course savedNodeJs = courseRepository.save(nodeJs);
            Course savedReactJS = courseRepository.save(reactJs);
            Course savedcScharp = courseRepository.save(cScharp);
            Course savedphpCourse = courseRepository.save(phpCourse);
            Course saveddockerCourse = courseRepository.save(dockerCourse);
            Course savedelectronicCourse = courseRepository.save(electronicCourse);
            Course savedBusiness = courseRepository.save(business);
            Course savedmarketingCourse = courseRepository.save(marketingCourse);
            Course savedJava = courseRepository.save(java);
            Course savedtypeScript = courseRepository.save(typeScript);
            Course savedHtml = courseRepository.save(html);
            Course savedCss = courseRepository.save(css);
            Course savedLinux = courseRepository.save(linux);

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
            Admin admin1= new Admin();
            admin1.setUsername("admin");
            admin1.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            admin1.getRoles().add(saved_role_admin);
            admin1.setEmail("admin@gmail.com");
            admin1.setName("Admin Quang");
            adminRepository.save(admin1);

            Instructor alex = new Instructor();
            alex.setUsername("alex");
            alex.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            alex.getRoles().add(saved_role_instructor);
            alex.setName("Alex Jefferson");
            alex.setEmail("alex@gmail.com");
            alex.setCompany("FPT");
            alex.setQuote("Không có gì quý hơn độc lập tự do hạnh phúc");
            alex.getCourses().add(savedNodeJs);
            alex.getCourses().add(savedVueJs);
            alex.getCategories().add(savedcat1);
            alex.setImage("irene");
            Instructor savedA = instructorRepository.save(alex);

            Instructor quill = new Instructor();
            quill.setUsername("quill");
            quill.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            quill.getRoles().add(saved_role_instructor);
            quill.setName("Quilliam Johnson");
            quill.setCompany("TMA Solutions");
            quill.setEmail("quill@tma.com");
            quill.setQuote("Cảm giác dạy học thì giống như một người mẹ");
            quill.setImage("captain");
            quill.getCourses().add(savedNodeJs);
            quill.getCourses().add(savedReactJS);
            quill.getCategories().add(savedcat1);
            quill.getCategories().add(savedcat2);
            Instructor savedQ = instructorRepository.save(quill);

            Instructor tripleh = new Instructor();
            tripleh.setUsername("tripleh");
            tripleh.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            tripleh.getRoles().add(saved_role_instructor);
            tripleh.setName("Triple H");
            tripleh.setCompany("WWE Cop");
            tripleh.setEmail("hhh@tma.com");
            tripleh.setQuote("Tôi chỉ cảm thấy hạnh phúc khi thấy những người xung quanh mình hạnh phúc");
            tripleh.getCategories().add(savedcat3);
            tripleh.getCourses().add(saveddockerCourse);
            tripleh.getCourses().add(savedelectronicCourse);
            tripleh.setImage("tripleh");
            Instructor savedtripleh = instructorRepository.save(tripleh);

            Instructor rose = new Instructor();
            rose.setUsername("rose");
            rose.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            rose.getRoles().add(saved_role_instructor);
            rose.setName("Park Chaeyoung");
            rose.setCompany("YG Copany");
            rose.setEmail("rosanne@tma.com");
            rose.setQuote("너의 눈에 비친 나의 모습이 늘 처음 만난 그 날만 같길 소리 없이 타오르는 불꽃같이");
            rose.getCategories().add(savedcat4);
            rose.getCourses().add(savedBusiness);
            rose.getCourses().add(savedmarketingCourse);
            rose.setImage("jisoo");
            Instructor savedRose = instructorRepository.save(rose);

            Instructor mrDao = new Instructor();
            mrDao.setUsername("daonm");
            mrDao.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            mrDao.getRoles().add(saved_role_instructor);
            mrDao.setName("Nguyen Minh Dao");
            mrDao.setCompany("HCMUTE");
            mrDao.setEmail("daomn@tma.com");
            mrDao.setQuote("너의 눈에 비친 나의 모습이 늘 처음 만난 그 날만 같길 소리 없이 타오르는 불꽃같이");
            mrDao.getCategories().add(savedcat1);
            mrDao.setImage("mrdao");
            Instructor savedMrDao = instructorRepository.save(mrDao);

            Instructor rapMonster = new Instructor();
            rapMonster.setUsername("rmonster");
            rapMonster.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            rapMonster.getRoles().add(saved_role_instructor);
            rapMonster.setName("Rap Monster");
            rapMonster.setCompany("BigHit");
            rapMonster.setEmail("rm@tma.com");
            rapMonster.setQuote("너의 눈에 비친 나의 모습이 늘 처음 만난 그 날만 같길 소리 없이 타오르는 불꽃같이");
            rapMonster.getCategories().add(savedcat1);
            rapMonster.setImage("rm");
            Instructor savedRapMonster = instructorRepository.save(rapMonster);

            Instructor mrHuy = new Instructor();
            mrHuy.setUsername("huynguyen");
            mrHuy.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            mrHuy.getRoles().add(saved_role_instructor);
            mrHuy.setName("Nguyễn Quang Huy");
            mrHuy.setCompany("HCMUTE");
            mrHuy.setEmail("huynguyen@tma.com");
            mrHuy.setQuote("너의 눈에 비친 나의 모습이 늘 처음 만난 그 날만 같길 소리 없이 타오르는 불꽃같이");
            mrHuy.getCategories().add(savedcat1);
            mrHuy.setImage("mrhuy");
            Instructor savedMrHuy = instructorRepository.save(mrHuy);

            Instructor lisa = new Instructor();
            lisa.setUsername("lisa");
            lisa.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            lisa.getRoles().add(saved_role_instructor);
            lisa.setName("Lalisa Manoban");
            lisa.setCompany("YG Copany");
            lisa.setEmail("lisa@tma.com");
            lisa.setQuote("너의 눈에 비친 나의 모습이 늘 처음 만난 그 날만 같길 소리 없이 타오르는 불꽃같이");
            lisa.setImage("lisa");
            lisa.getCourses().add(savedcScharp);
            lisa.getCourses().add(savedphpCourse);
            lisa.getCategories().add(savedcat3);
            Instructor savedLisa = instructorRepository.save(lisa);
            //Init Account ----------------------------------------------------------------------------------------------------------

            Account user1 = new Account();
            user1.setUsername("quang");
            user1.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            user1.getRoles().add(saved_role_admin);
            user1.getRoles().add(saved_role_user);

            Account savedUser1 = accountRepository.save(user1);

            Account user2 = new Account();
            user2.setUsername("thang");
            user2.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            user2.getRoles().add(saved_role_learner);
            Account savedUser2 = accountRepository.save(user2);

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

            Optional<Instructor> instructorOptional = instructorRepository.findByName("Quilliam Johnson");
            if (instructorOptional.isPresent()) {
                Instructor quillfound = instructorOptional.get();
                Optional<Course> courseOptional = courseRepository.findByName("Node JS Basic");
                if (courseOptional.isPresent()) {
                    Course nodefound = courseOptional.get();
                    quillfound.getCourses().add(nodefound);
                    instructorRepository.save(quillfound);
                }
            }

            Category en = categoryRepository.findByName("Engineering").get();


            Optional<Category> optionalCategory = categoryRepository.findByNameOrId(en.getId(),en.getId());
            if(optionalCategory.isPresent()){
                System.out.println(optionalCategory.get().getName());
            }

        }


    }

}
