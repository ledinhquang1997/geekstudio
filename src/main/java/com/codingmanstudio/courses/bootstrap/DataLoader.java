package com.codingmanstudio.courses.bootstrap;

import com.codingmanstudio.courses.domain.*;
import com.codingmanstudio.courses.repository.*;
import com.codingmanstudio.courses.Utils.EncrytedPasswordUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
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
    private final StudentRepository studentRepository;

    public DataLoader(RoleRepository roleRepository, AccountRepository accountRepository, CategoryRepository categoryRepository, CourseRepository courseRepository, LessonRepository lessonRepository, SectionRepository sectionRepository, InstructorRepository instructorRepository, TopicRepository topicRepository, AdminRepository adminRepository, StudentRepository studentRepository) {
        this.roleRepository = roleRepository;
        this.accountRepository = accountRepository;
        this.categoryRepository = categoryRepository;
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
        this.sectionRepository = sectionRepository;
        this.instructorRepository = instructorRepository;
        this.topicRepository = topicRepository;
        this.adminRepository = adminRepository;
        this.studentRepository = studentRepository;
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
            nodeJs.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--QReFaFjw--/v1540525483/geek/nodejs1_miaox0.jpg","7009627637e80f12b9def3fe00f955ee4ecad8cc9728367f354517584d1b98ee752abce356a7e326edf26f4c1414318210ced93489ef0d8b7ac167855ee7b62a21dcc5db26f2efc38a64ac759b8558fdc39c081f92b7e55a38341ed67c769ff3585cd2016ab6734e98a2634c7a21e485aa47092bd4c32802167dcc290dd93a0a674efe5782904776338d9dd2850b195f"));
            nodeJs.getTopics().add(savedTopicWebsite);
            nodeJs.getTopics().add(savedTopicBackend);
            nodeJs.setDescription("Node.js là một hệ thống phần mềm được thiết kế để viết các ứng dụng internet có khả năng mở rộng, đặc biệt là máy chủ web. Chương trình được viết bằng JavaScript, sử dụng kỹ thuật điều khiển theo sự kiện, nhập/xuất không đồng bộ để tối tiểu tổng chi phí và tối đại khả năng mở rộng");
            nodeJs.setDateCreate("03-04-2018");

            Course reactJs = new Course();
            reactJs.setName("ReactJS is easy");
            reactJs.getTopics().add(savedTopicWebsite);
            reactJs.getTopics().add(savedTopicFrontend);
            reactJs.setImage(new Image("http://res.cloudinary.com/quanglibrary/image/upload/s--ZZVzPy97--/v1540525582/geek/reactjs_sm3evd.jpg","15c204e97f23f939d11b32fafa195ffb38c95d6041b95fa0b80cbcd10e4f82189b9c932b98ca79df3a40cc8a77ab18423390af66cd134632604ad9efcc833fbc384647b883d48eca48401aacc28152de114ed10caf60bfbfabad07a469a5f63ccbf56ee77853eb800d72650f8df8a39b219c256a22f63de692468df6bdeeb447595ba348ed41595fc17d30d150c76c58"));
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
            vueJs.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--VuolUoHw--/v1540525653/geek/vuejs_ow9zoq.png","6471e831804dad2236c0360b81ec8d11480b4ce863e1fab5877ded7855bb37d1bb218bcd0e4f6a3355a3ae78060f1f188a9880384f91f4890fa5816b6a054955b3159bd4896731243bdf70f8d47cfb52c5139deba5de2f1ec59f900fb6538f965cd5647b830b0831d1a17ec0242f44175be0b4b4a6dfa43095970105b743b16fb4742bf595c0c2c796ea99055642c6fe"));
            vueJs.setAmountStudent(233);
            vueJs.setDescription("Vue.js, gọi tắt là Vue, là một framework linh động dùng để xây dựng giao diện người dùng. Khác với các framework nguyên khối, Vue được thiết kế từ đầu theo hướng cho phép và khuyến khích việc phát triển ứng dụng theo các bước");
            vueJs.setDateCreate("03-04-2018");

            Course business = new Course();
            business.getTopics().add(savedBussiness);
            business.setName("Market Leader");
            business.setCost(350L);
            business.setRating(2.4);
            business.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--ziyaKDc8--/v1540525762/geek/business1_ag1vla.jpg","97d5524c8f574ef9baedac7a2e6fa61838767be52b0c72b3b013c9f9e7ccb7fae56ad253868ae008c165c7fb1eec728fb440b75a48bb68b456d18093cdc9869f2c2841df0e07f7b8f53d3702a636349be56f702dd27c24871f955ce2eac4c5778e90b7b8e9389c02f68c73e75acdb6799b119f0ee9d0397ebe24d929573a696728443b8e16420ee04dd1bd89a36ca1f8683535e906f4b4df95dddc30cf865e4b"));
            business.setAmountStudent(123);
            business.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            business.setDateCreate("03-04-2018");

            Course marketingCourse = new Course();
            marketingCourse.getTopics().add(savedBussiness);
            marketingCourse.setName("Marketing Leader");
            marketingCourse.setCost(350L);
            marketingCourse.setRating(3.6);
            marketingCourse.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--K5m-Xf9L--/v1540525844/geek/marketing_u6csqk.jpg","5122915ec3894414fd79a993f08c89d0e52344c8863ca99310bee2b0af760c72a3a6044984b0d6692485f6c99304619c08825ff7ddbd7e79f099f8acebf628c63abc3e83be87befec708b51278da3f702875b0d787d8ae15ffb13d33997aabb53b0a200f0b10f4a25c9cb848872b83fdee120a03f6157fffd3d32c8cc88750077087099238edb6452db3c09543a32e7150880efe9f0dbf82196050dad361e32c"));
            marketingCourse.setAmountStudent(923);
            marketingCourse.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            marketingCourse.setDateCreate("03-04-2018");

            Course electronicCourse = new Course();
            electronicCourse.getTopics().add(savedEngineering);
            electronicCourse.setName("Master Electrons");
            electronicCourse.setCost(350L);
            electronicCourse.setRating(4.5);
            electronicCourse.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--dgh_pQof--/v1540525886/geek/electonic_klhzef.jpg","7dc7285f302bd40c3555854d49ad564b0e9ddb67b37285a9005ce6bcc76c7a23e66fb627396a4a70350ec9636fca17d8b554291ff22f9937042c62a1979b315c3d21c774030b3a39514fbd0de6ff7cd1cc83c50ae5d7a1b75ade707966c6bedd2e5f3916c6c09cee6dd22efc463f1cc7bd6f4f94d7493fd93b37237aea3a8c0ecf0da8587c17e32d00ba9ec5dc6923c449df2c326741fab5a2aaba20bd38511b"));
            electronicCourse.setAmountStudent(923);
            electronicCourse.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            electronicCourse.setDateCreate("03-04-2018");

            Course dockerCourse = new Course();
            dockerCourse.getTopics().add(savedBussiness);
            dockerCourse.setName("Docker - magic tool");
            dockerCourse.setCost(350L);
            dockerCourse.setRating(2.5);
            dockerCourse.getContentSummary().add("Completely understand how the stock market works.");
            dockerCourse.getContentSummary().add("Know the history of the Stock Market and it's Evolution.");
            dockerCourse.getContentSummary().add("Know the process that a company goes through to become a Publicly Traded Company");
            dockerCourse.getContentSummary().add("Different Exchanges: NYSE, NASDAQ & AMEX");

            dockerCourse.getRequirements().add("Basic Stock Market or Trading Knowledge");
            dockerCourse.getRequirements().add("This is a follow up course to the course \"Foundation Stock Trading Course\"\n");

            dockerCourse.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--JMGQDe5Q--/v1540525955/geek/docker_wbfbls.png","ad1867137bcad0c43b41750e18ab84acccaa7534382220cfb39b109cc531e97aa9fc4e6138f4d43caaf613304e61b59ffe5147f430945fe95bd02f0d13ad9af0fbafb6a8a834b5d033b18c2f52dc4294df6f8708dad91449a7420e72a9850a5f1d083a86d3d2dbebcbc1ecb4846358477b859987e6051aa9aebd03956a35a20fa47b83fc068393e2ac7e047ea063696b"));
            dockerCourse.setAmountStudent(943);

            dockerCourse.setDescriptionDetail("<p>This is the advanced&nbsp;course that our<strong>&nbsp;Full-Time Traders&nbsp;</strong>at the Proprietary Trading Firm Montreal&nbsp;Trading Group have taken in order to start their trading career.&nbsp;</p>\n" +
                    "<p>This course&nbsp;includes comprehensive advanced&nbsp;material that is required to start&nbsp;trading confidently and effectively.&nbsp;You learn the complete theory behind trading and even better,&nbsp;<strong>how to put theory&nbsp;into actio</strong><strong>n</strong>. I&nbsp;will&nbsp;teach you how our full time traders are&nbsp;making&nbsp;independent market decisions&nbsp;to produce profitable consistent&nbsp;results. You will get&nbsp;an&nbsp;<strong>excellent understanding of the Tools and Techniques used by Professional Traders</strong>.</p>\n" +
                    "<p>You will be learning from Mohsen Hassan, who is the owner of Montreal Trading Group (A proprietary Trading Firm that has 14 Full Time Traders and several Million dollars in Buying Power).</p>\n" +
                    "<p>This course covers<strong>&nbsp;Intermediary&nbsp;and advanced level information</strong>&nbsp;to breakthrough your path to becoming a profitable trader&nbsp;in your own trading abilities.&nbsp;You're going to&nbsp;take away a&nbsp;<strong>different approach at analyzing the data</strong>, an approach that isn&rsquo;t just based on theory.&nbsp;We will also cover in depth&nbsp;<strong>2&nbsp;Strategies&nbsp;</strong>from the ground up&nbsp;that we currently run at our office.&nbsp;On top of all the material thought, I will be giving you our&nbsp;<strong>personal tricks</strong>,&nbsp;<strong>techniques</strong>&nbsp;and&nbsp;<strong>views&nbsp;</strong>on the stock market that have tremendously fast-tracked our success.</p>\n" +
                    "<p>Trading can be a very rewarding career if done correctly. So whether you want to generate some side income by trading stocks or if you want to make trading your only source of income (like our Traders), then this course is for you.&nbsp;</p>\n" +
                    "<p>This is a&nbsp;full course separated in 2 parts, this is the 2nd&nbsp;part of the&nbsp;series.</p>");
            dockerCourse.setDescription("Để giữ gìn sự trong sáng của tiếng Việt \n khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            dockerCourse.setDateCreate("03-04-2018");

            Course phpCourse = new Course();
            phpCourse.getTopics().add(savedTopicBackend);
            phpCourse.setName("Website with PHP");
            phpCourse.setCost(353L);
            phpCourse.setRating(3.1);
            phpCourse.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--6q3OK3c3--/v1540526007/geek/php_hadezi.jpg","f59d06d3aa795b8b6141a23aa5a94e9fd8b3be801cb49ee330964c6164f642cda72f86888b9a01762b6201df398c74f1b77aa0ccc673f967e7b47f2e29cdab8e48fb9c396fd346d9ab6d7981f000e9da711c88d7ae0532842894adcd4a3e941fa3025d8d6d0543ed5e9cfe31a9c07b88d3d85f771a59dc3f84e281fe1d76581c7e6bd7f9d98ca263e74c8a2ee91e5d5d"));
            phpCourse.setAmountStudent(716);
            phpCourse.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            phpCourse.setDateCreate("03-04-2018");

            Course cScharp = new Course();
            cScharp.getTopics().add(savedTopicBackend);
            cScharp.setName("C# Core");
            cScharp.setCost(350L);
            cScharp.setRating(4.2);
            cScharp.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--epyNMN8M--/v1540526040/geek/csharp1_vyqahz.png","13b2b3712566dee180a174df0a9c34dd1470e60fda4c4c82d35d1aecb94918c2eda2fd938f86b46d23a5a48b9aaf9509e8f6f5ac646aed5afcf910c3baf3ae3260572a415b69b877e1f44d373b2fa7d8b6c3d90302dbeb139721fc542910d6b9158dc08e9799e4178016f1be628e3079021919f9cc75f16d88565256a9872f386fe50eb08618a44b10e16aae71758e56"));
            cScharp.setAmountStudent(12);
            cScharp.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            cScharp.setDateCreate("03-04-2018");

            Course java = new Course();
            java.getTopics().add(savedTopicBackend);
            java.setName("Java Core");
            java.setCost(120L);
            java.setRating(4);
            java.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--NxpFvmiF--/v1540526072/geek/java_jvzksj.jpg","d160cd5ca09fd301cd28c359bf7c753cae428fdf3dc4227b10f53ae010d68df8e760729e871517f3c942d7b1968d9d0c5d0f3b7ab4a75f0e19b16539151f7749ab453afc49043a00f554906aca5a0f0f5666d99daa64b857c651311c01bd5b676822878d157f4f2d5bf5e0374445cfc4823697c06335800d4885c911c1a03a7994a3bcae4742761bc75a3284dac15a4e"));
            java.setAmountStudent(12);
            java.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            java.setDateCreate("03-04-2018");


            Course css = new Course();
            css.getTopics().add(savedTopicBackend);
            css.setName("CSS wonderful");
            css.setCost(350L);
            css.setRating(4.7);
            css.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--xP-M834P--/v1540526154/geek/css_pasizv.jpg","156c5df5bcb5eb0ad2654cc4c4af518ffa8c99c100aa43d22948b76520a3b8069198482cd9104b378fa262e705b1e1c89dfff2b463d7466b0256b7321068be953bb484078abedae1874c471845851ea95aab5930b82192cef923c8d9c2d5f084e4e2015e902633b45504d330e9dfab809a08e29f713a67643f964c59654fc9e9f2eca5fab7e67262a5082a50eedc59ad"));
            css.setAmountStudent(12);
            css.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            css.setDateCreate("03-04-2018");

            Course linux = new Course();
            linux.getTopics().add(savedTopicBackend);
            linux.setName("Linux");
            linux.setCost(350L);
            linux.setRating(4.7);
            linux.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--C-Absi9K--/v1540526194/geek/css-wonderful_bziyf7.png","d49c12dfd482ec6e851f5bd3ddde6ab58e7b972ce36e22f02f4973df23fa3c08423686eb88923d2fdebfd09a47db20b4d35c7b14d9d69c8dcad7c77a5d80a023c97799c181dda1c663b6062df7295812c912a75ea1f73769e4920b2c069a3b5205eefb3584ab97663af08d3ef72fd1e0bede77822c37f21c029d74137185aa2efa314bfcfa0dc486cb1b29eb39437abe5326bb5ee9231e611826198510c89df1"));
            linux.setAmountStudent(12);
            linux.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            linux.setDateCreate("03-04-2018");


            Course html = new Course();
            html.getTopics().add(savedTopicBackend);
            html.setName("HTML is not programming lang");
            html.setCost(350L);
            html.setRating(3.4);
            html.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--ZWVpCe4J--/v1540526239/geek/html_u373he.jpg","f1d2b409315ed9043d2975c94a8bce7625b276a897db9d2d93a7f93f524386c387caf9898a33b46477305e07bfda144cd4977665fabd987b028958272f94f08833bdf5c081cb0ff7092e742a7f874e73d41808921580783bf1987ce2a96dd77f75905e8ba0d796a7fba121b4d029ff4f989e6d6d5ce4e5245435b2fca4c3368311d828d483faa7c2d223fcac230cdf4e"));
            html.setAmountStudent(12);
            html.setDescription("Để giữ gìn sự trong sáng của tiếng Việt khi tham gia chat, blog, các diễn đàn, SMS… Mấy bợng đừn diếc xai trính tã nge");
            html.setDateCreate("03-04-2018");


            Course typeScript = new Course();
            typeScript.getTopics().add(savedTopicBackend);
            typeScript.setName("TypeScript course");
            typeScript.setCost(350L);
            typeScript.setRating(3.9);
            typeScript.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--cS_nnnRh--/v1540526285/geek/typescript_s0drdi.png","ff3d7227aa3743f6ba8489b1a23f29bccb707d3ca2d1e022f9301da06b022691e8a388c65f62a8528891063598ced5a349289c58fd0cd1a03dbc0adfb85c337fd63e7dd2a7b4cd0301eb76e8a596b5a886fe999ac02012cab27c8a02c2db5221d5927feee6b893da79da1da50488739a90b5cdadd4c1a0d2b57865d37439f58554f36ca9f0bb5a001f37abf32180298a22aeda95a6ecd2bcfecea3435147debd"));
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

            cat1.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--PZL1J9Sl--/v1540526365/geek/programming-icon_itdqma.png","b79529b0ec34dc05e46d167074861d1b2d31d0e19f35d2ef8e820e8eae1257115b3bf193a2b2b55a22ecc225474a1dce6bfb963b1e7fdef18286ddc26d5d766114f993b3a7355cce75f5d50437242f54504176a0def46cef433629752962a5b3210262993d998d31c3944a53528dcebe9642e69772ddbc4c88f895caef6f220b7d898dad74fe1b9d31f1162b2b9464fde47fc0b12c7a83ed412ba6c45cc69876"));
            cat1.setDescription("C#, Java, Javascript, PHP, ReactJS, VueJS, Node JS,...");

            Category cat2 = new Category();
            nodeJs.setCategory(cat2);
            reactJs.setCategory(cat2);
            business.setCategory(cat2);
            cat2.getCourses().add(nodeJs);
            cat2.getCourses().add(reactJs);
            cat2.setName("Business");
            cat2.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--eC15qLSk--/v1540526416/geek/business-icon_geubib.png","b261b957c059c045f8965dc750df2b4a9724fc58be7e19717b4a6adcf958765fb627f56e9da76e5c73f86b84ee1bf1ad6b30cd24d1460e38f046debda67f67052ea4526247eee089da21b5774af34c40a32c389111ce2c3c461d40fee9df878d16d054c89ea5b9e6ea51a76530e91bdf9b9b6407afd14ed9ae94097c5b7bd370ad52dbf4e650734f1b27fd3a695479762318f4b034c1f641bbae55c8759eb28f"));
            cat2.setDescription("Sale, Manage, Statistic, Products,...");

            Category cat3 = new Category();

            cat3.setName("Marketing");
            cat3.getCourses().add(marketingCourse);
            marketingCourse.setCategory(cat3);
            cat3.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--UR8CIUKs--/v1540526452/geek/marketing-icon_khhxvt.png","92ff1687c0d972a6bed1f8b9e2d197bc7834c4fb847c1c32a224d1b856b67f4b116759839bde100f36464f527b5a3df3669e9574b80be453c2bfc82ca95645218bcf489bc7bdcc3f2fe0c07f72021b9cad38adfc5e89164225e9b8cbeaab455b19fbeca73a82627409d531249b15cae024aa40f4a82874b0cf1119b4cded38823ba882fff98145281050d66771113aae8a4fa52e9def3b4f84c6105a9dc885ff"));
            cat3.setDescription("SEO, Internet Marketing, Influencer Marketing, PPI, Online viral marketing,...");
            cat3.getTopics().add(savedSeo);
            cat3.getTopics().add(savedInfluncerMarketing);
            cat3.getTopics().add(savedonlineMakerting);
            cat3.getTopics().add(savedAd);

            Category cat4 = new Category();
            cat4.getCourses().add(electronicCourse);
            electronicCourse.setCategory(cat4);
            cat4.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--HjKxyPE3--/v1540526490/geek/engineering-icon_glaqnc.png","0791945bfa5c98d45349e38891b991070feb23beda51d39fe0fd0971a434eede23ee2ec93f5ced28bf7cfe81ab6ff52b110d57480f7e1337707a265589dc1f63f1240452af2a5cf11d2761be57883c6dc02019a02a9e85b208bd66804fd0e02a5bd5ddba7b32663b188b30eac8ab8501f42b16f1a0a9c050bdbf48ae1ed9be8ca6d412cb18dbd5aba3cf8e7912184ae7f07e2f360ca79a409a4a203656423a27"));
            cat4.setName("Engineering");
            cat4.setDescription("Chemical engineering, Civil engineering, Electical, Process engineering,...");


            //Init Lesson ----------------------------------------------------------------------------------------------------------

            Lesson nodeJsLesson1 = new Lesson();
            nodeJsLesson1.setOrdinalNumber(1);
            nodeJsLesson1.setName("Deploy Node.js Express Application in App Engine");
            nodeJsLesson1.setDescription("YG Entertainment Inc. (thay mặt cho YG Entertainment); ASCAP, Abramus Digital, SODRAC, UMPG Publishing, UBEM và 13 Hội bảo vệ quyền âm nhạc");
            nodeJsLesson1.setCourse(nodeJs);
            nodeJs.getLessons().add(nodeJsLesson1);

            Lesson nodeJsLesson2 = new Lesson();
            nodeJsLesson2.setOrdinalNumber(2);
            nodeJsLesson2.setName("Updating the Node App");
            nodeJsLesson2.setDescription("Warning: Establishing SSL connection without server's identity verification is not recommended [duplicate]");
            nodeJsLesson2.setCourse(nodeJs);
            nodeJs.getLessons().add(nodeJsLesson2);

            Lesson nodeJsLesson3 = new Lesson();
            nodeJsLesson3.setOrdinalNumber(3);
            nodeJsLesson3.setName("Node js chap 3");
            nodeJsLesson3.setDescription("Establishing SSL connection without server's identity verification is not recommended." +
                    " According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set.");
            nodeJsLesson3.setCourse(nodeJs);
            nodeJs.getLessons().add(nodeJsLesson3);

            Lesson nodeJsLesson4 = new Lesson();
            nodeJsLesson4.setOrdinalNumber(4);
            nodeJsLesson4.setName("Node js chap 4");
            nodeJsLesson4.setDescription("Build a Node.js Web App using Google Cloud Platform");
            nodeJsLesson4.setCourse(nodeJs);
            nodeJs.getLessons().add(nodeJsLesson4);

//            Lesson nodeJsLesson5 = new Lesson();
//            nodeJsLesson5.setOrdinalNumber(5);
//            nodeJsLesson5.setName("Node js chap 5");
//            nodeJsLesson5.setDescription("Build a Slack Bot with Node.js on Kubernetes");
//            nodeJsLesson5.setCourse(nodeJs);
//            nodeJs.getLessons().add(nodeJsLesson5);
//
//            Lesson nodeJsLesson6 = new Lesson();
//            nodeJsLesson6.setOrdinalNumber(6);
//            nodeJsLesson6.setName("Node js chap 6");
//            nodeJsLesson6.setDescription("Running Node.js on a Virtual Machine");
//            nodeJsLesson6.setCourse(nodeJs);
//            nodeJs.getLessons().add(nodeJsLesson6);
//
//            Lesson nodeJsLesson7 = new Lesson();
//            nodeJsLesson7.setOrdinalNumber(7);
//            nodeJsLesson7.setName("Node js chap 7");
//            nodeJsLesson7.setDescription("Using Cloud Vision with Node.js");
//            nodeJsLesson7.setCourse(nodeJs);
//            nodeJs.getLessons().add(nodeJsLesson7);

            Lesson reactJsLesson1 = new Lesson();
            reactJsLesson1.setOrdinalNumber(1);
            reactJsLesson1.setName("React js chap 1");
            reactJsLesson1.setDescription("YG Entertainment Inc. (thay mặt cho YG Entertainment); ASCAP, Abramus Digital, SODRAC, UMPG Publishing, UBEM và 13 Hội bảo vệ quyền âm nhạc");
            reactJsLesson1.setCourse(reactJs);
            reactJs.getLessons().add(reactJsLesson1);

            Lesson reactJsLesson2 = new Lesson();
            reactJsLesson2.setOrdinalNumber(2);
            reactJsLesson2.setName("React js chap 2");
            reactJsLesson2.setDescription("Cascading the one-to-one persist operation\n" +
                    "The CascadeType.PERSIST comes along with the CascadeType.ALL configuration, so we only have to persist the Post entity, and the associated PostDetails entity is persisted as well");
            reactJsLesson2.setCourse(reactJs);
            reactJs.getLessons().add(reactJsLesson2);

            Lesson reactJsLesson3 = new Lesson();
            reactJsLesson3.setOrdinalNumber(3);
            reactJsLesson3.setName("React js chap 3");
            reactJsLesson3.setDescription("Cascading the one-to-one persist operation\n" +
                    "The CascadeType.PERSIST comes along with the CascadeType.ALL configuration, so we only have to persist the Post entity, and the associated PostDetails entity is persisted as well");
            reactJsLesson3.setCourse(reactJs);
            reactJs.getLessons().add(reactJsLesson3);

            Lesson reactJsLesson4 = new Lesson();
            reactJsLesson4.setOrdinalNumber(4);
            reactJsLesson4.setName("React js chap 4");
            reactJsLesson4.setDescription("Main Concepts");
            reactJsLesson4.setCourse(reactJs);
            reactJs.getLessons().add(reactJsLesson4);

//            Lesson reactJsLesson5 = new Lesson();
//            reactJsLesson5.setOrdinalNumber(5);
//            reactJsLesson5.setName("React js chap 5");
//            reactJsLesson5.setDescription("Advanced Guides");
//            reactJsLesson5.setCourse(reactJs);
//            reactJs.getLessons().add(reactJsLesson5);
//
//            Lesson reactJsLesson6 = new Lesson();
//            reactJsLesson6.setOrdinalNumber(6);
//            reactJsLesson6.setName("React js chap 6");
//            reactJsLesson6.setDescription("API References");
//            reactJsLesson6.setCourse(reactJs);
//            reactJs.getLessons().add(reactJsLesson6);
//
//            Lesson reactJsLesson7 = new Lesson();
//            reactJsLesson7.setOrdinalNumber(7);
//            reactJsLesson7.setName("React js chap 7");
//            reactJsLesson7.setDescription("Hooks");
//            reactJsLesson7.setCourse(reactJs);
//            reactJs.getLessons().add(reactJsLesson7);

            Lesson vueJsLesson1 = new Lesson();
            vueJsLesson1.setOrdinalNumber(1);
            vueJsLesson1.setName("Vue js chap 1");
            vueJsLesson1.setDescription("Cascading the one-to-one persist operation\n" +
                    "The CascadeType.PERSIST comes along with the CascadeType.ALL configuration, so we only have to persist the Post entity, and the associated PostDetails entity is persisted as well");
            vueJsLesson1.setCourse(vueJs);
            vueJs.getLessons().add(vueJsLesson1);

            Lesson vueJsLesson2 = new Lesson();
            vueJsLesson2.setOrdinalNumber(2);
            vueJsLesson2.setName("Vue js chap 2");
            vueJsLesson2.setDescription("Cascading the one-to-one persist operation\n" +
                    "The CascadeType.PERSIST comes along with the CascadeType.ALL configuration, so we only have to persist the Post entity, and the associated PostDetails entity is persisted as well");
            vueJsLesson2.setCourse(vueJs);
            vueJs.getLessons().add(vueJsLesson2);

//            Lesson vueJsLesson3 = new Lesson();
//            vueJsLesson3.setOrdinalNumber(3);
//            vueJsLesson3.setName("Vue js chap 3");
//            vueJsLesson3.setDescription("Cascading the one-to-one persist operation\n" +
//                    "The CascadeType.PERSIST comes along with the CascadeType.ALL configuration, so we only have to persist the Post entity, and the associated PostDetails entity is persisted as well");
//            vueJsLesson3.setCourse(vueJs);
//            vueJs.getLessons().add(vueJsLesson3);
//
//            Lesson vueJsLesson4 = new Lesson();
//            vueJsLesson4.setOrdinalNumber(4);
//            vueJsLesson4.setName("Vue js chap 4");
//            vueJsLesson4.setDescription("Essentials");
//            vueJsLesson4.setCourse(vueJs);
//            vueJs.getLessons().add(vueJsLesson4);
//
//            Lesson vueJsLesson5 = new Lesson();
//            vueJsLesson5.setOrdinalNumber(5);
//            vueJsLesson5.setName("Vue js chap 5");
//            vueJsLesson5.setDescription("Components In-Depth");
//            vueJsLesson5.setCourse(vueJs);
//            vueJs.getLessons().add(vueJsLesson5);
//
//            Lesson vueJsLesson6 = new Lesson();
//            vueJsLesson6.setOrdinalNumber(6);
//            vueJsLesson6.setName("Vue js chap 6");
//            vueJsLesson6.setDescription("Transitions & Animation");
//            vueJsLesson6.setCourse(vueJs);
//            vueJs.getLessons().add(vueJsLesson6);
//
//            Lesson vueJsLesson7 = new Lesson();
//            vueJsLesson7.setOrdinalNumber(7);
//            vueJsLesson7.setName("Vue js chap 7");
//            vueJsLesson7.setDescription("Reusability & Composition");
//            vueJsLesson7.setCourse(vueJs);
//            vueJs.getLessons().add(vueJsLesson7);

            //Init Section ----------------------------------------------------------------------------------------------------------

            Section sec1Node1 = new Section();
            sec1Node1.setVideo(new Video("http://res.cloudinary.com/quanglibrary/video/upload/s--3y5i8gCU--/v1544362858/test/269_Assignment_-_Configure_MySQL_sdy0ht.mp4","871ca78249f624d73c5bf6a7dc555e7be461e341d874bdb75fdeaefe94cb03d2a8b95b7b1edf8e8c217d51a180cce476bcdcb1ec0240c502a404ce1c86112981ec795d2cbc6381d6c9ec3b5fb0782e54943a2ab192d5ec97896a082764200909fcb9017822e684ca710d0e93938eadca4212f8b98cc0690497834224fa3d3fd360b54432889efa67925139e70c4537a9d03fc831b670c817a0374b543033f7dced362ec84ede3854c014e8759ae1db19"));
            sec1Node1.setOrdinalNumber(1);
            sec1Node1.setDescription("Overview");
            sec1Node1.setContent("<p>Google App Engine applications are easy to create, easy to maintain, and easy to scale as your traffic and data storage needs change. With App Engine, there are no servers to maintain. You simply upload your application and it's ready to go.</p>\n" +
                    "<p>App Engine applications automatically scale based on incoming traffic. load balancing, microservices, authorization, SQL and NoSQL databases, Memcache, traffic splitting, logging, search, versioning, roll out and roll backs, and security scanning are all supported natively and are highly customizable.</p>\n" +
                    "<p>App Engine's environments, the&nbsp;<a href=\"https://cloud.google.com/appengine/docs/about-the-standard-environment\" target=\"_blank\">Standard Environment</a>&nbsp;and the&nbsp;<a href=\"https://cloud.google.com/appengine/docs/flexible/\" target=\"_blank\">Flexible environment</a>, support a host of programming languages, including Java, Python, PHP, Node.js, Go, etc.. The two environments give users maximum flexibility in how their application behaves since each environment has certain strengths. Read&nbsp;<a href=\"https://cloud.google.com/appengine/docs/the-appengine-environments\" target=\"_blank\">The App Engine Environments</a>&nbsp;for more information.</p>\n" +
                    "<p>In this codelab, you will learn how to to connect to computing resources hosted on Google Cloud Platform via the web. You will learn how to use Cloud Shell and the Cloud SDK gcloud command.</p>\n" +
                    "<p>This tutorial uses the sample code from the&nbsp;<a href=\"https://github.com/GoogleCloudPlatform/nodejs-docs-samples\" target=\"_blank\">Google Cloud Node.js Getting Started guide</a>.</p>\n" +
                    "<h3 class=\"checklist\"><strong>What you'll learn</strong></h3>\n" +
                    "<ul class=\"checklist\">\n" +
                    "<li>How to create a Node.js Express application on Google App Engine.</li>\n" +
                    "<li>How to update the code without taking the server down.</li>\n" +
                    "</ul>\n" +
                    "<h3><strong>What you'll need</strong></h3>\n" +
                    "<ul>\n" +
                    "<li>A Google Cloud Platform Project</li>\n" +
                    "<li>A Browser, such&nbsp;<a href=\"https://www.google.com/chrome/browser/desktop/\" target=\"_blank\">Chrome</a>&nbsp;or&nbsp;<a href=\"https://www.mozilla.org/firefox/\" target=\"_blank\">Firefox</a></li>\n" +
                    "<li>Familiarity with standard Linux text editors such as Vim, EMACs or Nano</li>\n" +
                    "</ul>");
            sec1Node1.setLesson(nodeJsLesson1);
            nodeJsLesson1.getSections().add(sec1Node1);

            Section sec2Node1 = new Section();
            sec2Node1.setVideo(new Video("https://res.cloudinary.com/quanglibrary/video/upload/s--VwI6pm3y--/v1544358522/test/093_Section_Overview_ie76en.mp4","8f9c54a89679bd1e2125b8d7a4890b29e2d4c40ba86cbbbd5c281b5b39b5f28ca544b5ed2ee0926af9a0433b9377b8b7f02f55362a4396b2be92043d7a2e99d50b28b6574a347aaf1576bc7f4f01240b57f13e511c09c6dd254ca033cd4653caa2c607bef5707a6c2781843d0515d19b94a5410efb007b78620082d498246d5263e765c81fe0979d20155e249c4e34907e0c9906d6aa390876d6c4617be552cf"));
            sec2Node1.setOrdinalNumber(2);
            sec2Node1.setDescription("Setup and Requirements");
            sec2Node1.setContent("<h2><strong>Self-paced environment setup</strong></h2>\n" +
                    "<p>If you don't already have a Google Account (Gmail or Google Apps), you must&nbsp;<a href=\"https://accounts.google.com/SignUp\" target=\"_blank\">create one</a>. Sign-in to Google Cloud Platform console (<a href=\"http://console.cloud.google.com/\" target=\"_blank\">console.cloud.google.com</a>) and create a new project:</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-app-engine-node/img/3c50189ec031c0cf.png\" /></p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-app-engine-node/img/f8a3bda1aa66cf2f.png\" /></p>\n" +
                    "<p>Remember the project ID, a unique name across all Google Cloud projects (the name above has already been taken and will not work for you, sorry!). It will be referred to later in this codelab as&nbsp;<code>PROJECT_ID</code>.</p>\n" +
                    "<p>Next, you'll need to&nbsp;<a href=\"https://console.developers.google.com/billing\" target=\"_blank\">enable billing</a>&nbsp;in the Developers Console in order to use Google Cloud resources.</p>\n" +
                    "<p>Running through this codelab shouldn't cost you more than a few dollars, but it could be more if you decide to use more resources or if you leave them running (see \"cleanup\" section at the end of this document).</p>\n" +
                    "<p>New users of Google Cloud Platform are eligible for a&nbsp;<a href=\"https://console.developers.google.com/billing/freetrial?hl=en\" target=\"_blank\">$300 free trial</a>.</p>\n" +
                    "<h2><strong>Google Cloud Shell</strong></h2>\n" +
                    "<p>While Google Cloud can be operated remotely from your laptop, in this codelab we will be using&nbsp;<a href=\"https://cloud.google.com/cloud-shell/\" target=\"_blank\">Google Cloud Shell</a>, a command line environment running in the Cloud. This Debian-based virtual machine is loaded with all the development tools you'll need (<code>gcloud</code>,&nbsp;<code>node,</code>&nbsp;<code>npm</code>&nbsp;and more), it offers a persistent 5GB home directory, and runs on the Google Cloud, greatly enhancing network performance and authentication. This means that all you will need for this codelab is a browser (yes, it works on a Chromebook).</p>\n" +
                    "<p>To activate Google Cloud Shell, from the developer console simply click the button on the top right-hand side (it should only take a few moments to provision and connect to the environment):</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-app-engine-node/img/5f504766b9b3be17.png\" /></p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-app-engine-node/img/c0726a5e7bd6ec39.png\" /></p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-app-engine-node/img/9f0e51b578fecce5.png\" /></p>\n" +
                    "<p>Once connected to the cloud shell, you should see that you are already authenticated and that the project is already set to your&nbsp;<code>PROJECT_ID</code>&nbsp;:</p>\n" +
                    "<pre>$ gcloud auth list\n" +
                    "Credentialed accounts:\n" +
                    " - &lt;myaccount&gt;@&lt;mydomain&gt;.com (active)</pre>\n" +
                    "<aside class=\"special\">\n" +
                    "<p><strong>Note:&nbsp;</strong><code>gcloud</code>&nbsp;is the powerful and unified command-line tool for Google Cloud Platform. Full documentation is available from&nbsp;<a href=\"https://cloud.google.com/sdk/gcloud/\" target=\"_blank\">https://cloud.google.com/sdk/gcloud</a>. It comes pre-installed on CloudShell and you will surely enjoy its support for tab-completion.</p>\n" +
                    "</aside>\n" +
                    "<pre>$ gcloud config list project\n" +
                    "[core]\n" +
                    "project = &lt;PROJECT_ID&gt;</pre>\n" +
                    "<p>If for some reason the project is not set, simply issue the following command :</p>\n" +
                    "<pre>$ gcloud config set project &lt;PROJECT_ID&gt;</pre>\n" +
                    "<p>Looking for you&nbsp;<code>PROJECT_ID</code>? Check out what ID you used in the setup steps or look it up in the console dashboard :</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-app-engine-node/img/e40be8c610cd41c0.png\" /></p>\n" +
                    "<h2><strong>Start Cloud Shell</strong></h2>\n" +
                    "<p>Navigate to the the Google Cloud Console from another browser tab/window, to&nbsp;<a href=\"https://console.cloud.google.com/\" target=\"_blank\">https://console.cloud.google.com</a>. Use the login credential given to you by the lab proctor.</p>\n" +
                    "<p>You will do all of the work from the&nbsp;<a href=\"https://cloud.google.com/developer-shell/#how_do_i_get_started\" target=\"_blank\">Google Cloud Shell</a>,<a href=\"https://cloud.google.com/developer-shell/#how_do_i_get_started\" target=\"_blank\">&nbsp;a command line environment running in the Cloud</a>. This Debian-based virtual machine is loaded with all the development tools you'll need (<code>gcloud</code>,&nbsp;<code>git,</code>&nbsp;<code>node,</code>&nbsp;<code>npm</code>&nbsp;and others) and offers a persistent 5GB home directory. Open the Google Cloud Shell by clicking on the icon on the top right of the screen:</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-app-engine-node/img/5f504766b9b3be17.png\" /></p>");
            sec2Node1.setLesson(nodeJsLesson1);
            nodeJsLesson1.getSections().add(sec2Node1);

            Section sec3Node1 = new Section();
            sec3Node1.setVideo(new Video("https://res.cloudinary.com/quanglibrary/video/upload/s--G1-Ft7gW--/v1544358751/test/277_Introduction_to_Spring_Data_MongoDB_fiszjl.mp4","5aefb7feed32b3bffaf7b64214db2e5ae0a658369273632a2d1ebc8be291cb75f42df6911765b7550a3d3825c61ec378b64a1f9077ff9448f86176e213f8c3c32f8b84953b89d24a2bda357e9380c36466603e00219e8e466a909183bda5b9b4c3d08d7bca01da19674763d2aece325de85efc5740357846941c079d2f2319f224e7c7f2390beede303695a3fe958e49a2725b3bdd151396690d6b34b6f3bf7cb9a97fee4bb693c6ab4ada1e600e0714d908c36aa64722ef029ecf39880ddb38"));
            sec3Node1.setOrdinalNumber(3);
            sec3Node1.setDescription("Get the Getting Started Example source code");
            sec3Node1.setContent("<p>After Cloud Shell launches, you can use the command line to clone the example source code in the home directory:</p>\n" +
                    "<pre><code><span class=\"pln\">git clone https</span><span class=\"pun\">:</span><span class=\"com\">//github.com/GoogleCloudPlatform/nodejs-docs-samples.git &amp;&amp; \\</span><span class=\"pln\">\n" +
                    "cd nodejs</span><span class=\"pun\">-</span><span class=\"pln\">docs</span><span class=\"pun\">-</span><span class=\"pln\">samples</span><span class=\"pun\">/</span><span class=\"pln\">appengine</span><span class=\"pun\">/</span><span class=\"pln\">hello</span><span class=\"pun\">-</span><span class=\"pln\">world</span><span class=\"pun\">/</span><span class=\"pln\">standard</span><span class=\"pun\">/</span></code></pre>\n" +
                    "<p>Now, install the dependencies with&nbsp;<code>npm</code>:</p>\n" +
                    "<pre><code><span class=\"pln\">npm install</span></code></pre>");
            sec3Node1.setLesson(nodeJsLesson1);
            nodeJsLesson1.getSections().add(sec3Node1);

            Section sec4Node1 = new Section();
            sec4Node1.setOrdinalNumber(4);
            sec4Node1.setVideo(new Video("http://res.cloudinary.com/quanglibrary/video/upload/s--QOKd62ds--/v1544459584/test/Bai_2_Cai_dat_NodeJS_tren_Linux___Ubuntu_evuwa3.mp4","0c961bb02fad50240b13e699a90c727790b261509c0261a2468739cfa1908cae9881958ece77f1162f72bbf153f51de655654348faebbf538e7dbdcc4af6c7d801f9ef5b145e7f7a364824b052db39e85c6cca0a101956ab49660bba7c91bbdd7901f2dfb62e72ab11b7b53cb0c0c280b73847cd0fff90f921542808803310500391988c2bc02a9d36a4752a4954a4eaf14f637c6754fbd06249e1cb6190cefb73de49a8c0675df4e2b6f7dbf743cc057034b02673a188c8f1d1c76040d1c532"));
            sec4Node1.setDescription("Get the sample code");
            sec4Node1.setContent("<p>In Cloud Shell on the command-line, run the following command to clone the Github repository:</p>\n" +
                    "<pre>git clone https://github.com/googlecodelabs/cloud-nodejs.git</pre>\n" +
                    "<p>Change directory into&nbsp;<code>cloud-nodejs/start</code>.</p>\n" +
                    "<pre>cd cloud-nodejs/start</pre>");
            sec4Node1.setLesson(nodeJsLesson1);
            nodeJsLesson1.getSections().add(sec4Node1);

            Section sec5Node1 = new Section();
            sec5Node1.setOrdinalNumber(5);
            sec5Node1.setDescription("Try out the sample");
            sec5Node1.setContent("<p>The sample has the following layout:</p>\n" +
                    "<pre><code><span class=\"pln\">app</span><span class=\"pun\">.</span><span class=\"pln\">js        </span><span class=\"com\">/* Express.js web application */</span><span class=\"pln\">\n" +
                    "books</span><span class=\"pun\">.</span><span class=\"pln\">js      </span><span class=\"com\">/* Code for creating, deleting, and listing books */</span><span class=\"pln\">\n" +
                    "auth</span><span class=\"pun\">.</span><span class=\"pln\">js       </span><span class=\"com\">/* Code for user authentication */</span><span class=\"pln\">\n" +
                    "config</span><span class=\"pun\">.</span><span class=\"pln\">js     </span><span class=\"com\">/* Application configuration variables */</span>\n" +
                    "<span class=\"kwd\">package</span><span class=\"pun\">.</span><span class=\"pln\">json  </span><span class=\"com\">/* npm package file including dependencies */</span><span class=\"pln\">\n" +
                    "views</span><span class=\"pun\">/</span><span class=\"pln\">\n" +
                    "  index</span><span class=\"pun\">.</span><span class=\"pln\">jade  </span><span class=\"com\">/* HTML template */</span>\n" +
                    "<span class=\"kwd\">public</span><span class=\"pun\">/</span><span class=\"pln\">\n" +
                    "  style</span><span class=\"pun\">.</span><span class=\"pln\">css   </span><span class=\"com\">/* CSS stylesheet */</span></code></pre>\n" +
                    "<p>To run the sample application in Cloud Shell, let's perform the following steps:</p>\n" +
                    "<p>1. Install dependencies. Enter the following command:</p>\n" +
                    "<pre>npm install</pre>\n" +
                    "<p>2. Run app.js to start the node.js server:</p>\n" +
                    "<pre>node app.js</pre>\n" +
                    "<p>3. Click the \"Web preview\" icon that appears at the top left side of the cloud shell window and select \"Preview on port 8080\" to see the app in a web browser.&nbsp;<img src=\"https://codelabs.developers.google.com/codelabs/cloud-nodejs/img/a0c920da29c2c9e7.png\" /></p>\n" +
                    "<aside class=\"special\">\n" +
                    "<p>Note: Usually you would test with&nbsp;<a href=\"http://localhost:8080/\" target=\"_blank\">http://localhost:8080</a>&nbsp;but the Google Cloud Shell environment requires requests to be proxied)</p>\n" +
                    "</aside>\n" +
                    "<p>You will see a page that looks like this:</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-nodejs/img/e3a780eda310decb.png\" /></p>\n" +
                    "<p>The application currently displays a fake book.</p>\n" +
                    "<p>Let's fix that by querying for books from datastore!</p>\n" +
                    "<aside class=\"special\">\n" +
                    "<p>Note: To stop running the app, go to the Cloud Shell window and press&nbsp;<strong><code>CTRL + C</code></strong></p>\n" +
                    "</aside>\n" +
                    "<h2><strong>Summary</strong></h2>\n" +
                    "<p>In this step, you set up and ran the codelab sample application.</p>\n" +
                    "<h2><strong>Next up</strong></h2>\n" +
                    "<p>Next, you will setup Google Cloud Datastore and configure the application to begin querying it.</p>");
            sec5Node1.setLesson(nodeJsLesson1);
            nodeJsLesson1.getSections().add(sec5Node1);

            Section sec6Node1 = new Section();
            sec6Node1.setOrdinalNumber(6);
            sec6Node1.setDescription("Set up your project");
            sec6Node1.setContent("<p>In this step, you will set up Google Cloud Datastore and configure the application to query from it.</p>\n" +
                    "<h3><strong>Create Credentials</strong></h3>\n" +
                    "<p>For the node.js application to access this project's services, eg. Datastore and Cloud Storage, it needs to be authenticated. Create a Service Account for this project which will be used to authenticate the application.</p>\n" +
                    "<ol start=\"8\" type=\"1\">\n" +
                    "<li>In the Cloud Console, navigate to&nbsp;<strong>APIs &amp; Services &gt;&nbsp;</strong><a href=\"https://console.developers.google.com/project/_/apiui/credential\" target=\"_blank\"><strong>Credentials</strong></a></li>\n" +
                    "<li>Make sure your project is selected and click&nbsp;<strong>Continue</strong></li>\n" +
                    "<li>Next, click&nbsp;<strong>Create credentials</strong></li>\n" +
                    "<li>Select \"<strong>Service account key</strong>\" from the drop-down menu</li>\n" +
                    "<li>Under the&nbsp;<strong>Service Account</strong>&nbsp;dropdown, select&nbsp;<strong>\"Compute Engine default service account\"&nbsp;</strong>and ensure that&nbsp;<strong>Key type</strong>is set to<strong>&nbsp;JSON</strong>. Then click the \"<strong>Create\"&nbsp;</strong>button</li>\n" +
                    "<li>Once the JSON key file automatically downloads, locate it (it should have a name of the form)&nbsp;<code>&lt;project name&gt;-&lt;hash string&gt;.json</code>&nbsp;and open it in a text editor.</li>\n" +
                    "<li>Back in the Cloud Shell window, in the \"cloud-nodejs/start\" directory, copy and paste the entire contents of the key file into a new file called&nbsp;<code>key.json</code>.</li>\n" +
                    "</ol>\n" +
                    "<aside class=\"special\">\n" +
                    "<p>Note: You can use \"nano -m key.json\" to create the keyfile and store the json content in it.</p>\n" +
                    "</aside>\n" +
                    "<h3><strong>Enable Datastore API</strong></h3>\n" +
                    "<p>The credentials you created allow your application to communicate with Google APIs that you enable for this project. Enable the Datastore API so the application can access Datastore.</p>\n" +
                    "<ol start=\"1\" type=\"1\">\n" +
                    "<li>Under&nbsp;<strong>APIs &amp; Services</strong>, click&nbsp;<strong>Enable APIs and Services</strong>&nbsp;and search for \"<em>Cloud Datastore API</em>\"</li>\n" +
                    "<li>Click on&nbsp;<a href=\"https://console.developers.google.com/project/_/apiui/apiview/datastore/overview\" target=\"_blank\"><strong>Cloud Datastore API</strong></a></li>\n" +
                    "<li>Click&nbsp;<strong>Enable</strong>&nbsp;(at the top of the page).</li>\n" +
                    "</ol>\n" +
                    "<h3><strong>Update configuration variables</strong></h3>\n" +
                    "<p>To configure the node.js sample application to authenticate with your project, go back to your Cloud Shell instance and edit the&nbsp;<code>config.js</code>&nbsp;file in the \"cloud-nodejs/start\" directory and replace the placeholder value for&nbsp;<code>projectId</code>&nbsp;with the Project ID of your project:</p>\n" +
                    "<h3><a href=\"https://github.com/googlecodelabs/cloud-nodejs/blob/master/start/config.js\" target=\"_blank\">config.js</a></h3>\n" +
                    "<pre><code><span class=\"kwd\">module</span><span class=\"pun\">.</span><span class=\"pln\">exports </span><span class=\"pun\">=</span> <span class=\"pun\">{</span><span class=\"pln\">\n" +
                    "  projectId</span><span class=\"pun\">:</span> <span class=\"str\">'[your Google Developers Console project ID]'</span><span class=\"pun\">,</span><span class=\"pln\">\n" +
                    "  keyFilename</span><span class=\"pun\">:</span> <span class=\"str\">'./key.json'</span><span class=\"pun\">,</span>\n" +
                    "  <span class=\"com\">// ...</span>\n" +
                    "<span class=\"pun\">};</span></code></pre>\n" +
                    "<h2><strong>Summary</strong></h2>\n" +
                    "<p>In this step, you created a Google Developer Console project and configured the node.js application with the credentials needed to query Datastore.</p>\n" +
                    "<h2><strong>Next up</strong></h2>\n" +
                    "<p>Next, you will update the application to query books from your project's Datastore.</p>");
            sec6Node1.setLesson(nodeJsLesson1);
            nodeJsLesson1.getSections().add(sec6Node1);

            Section sec7Node1 = new Section();
            sec7Node1.setOrdinalNumber(7);
            sec7Node1.setDescription("List all books");
            sec7Node1.setContent("<p>The sample application's home page lists all books.</p>\n" +
                    "<p>Books are retrieved by calling&nbsp;<code>books.getAllBooks</code>&nbsp;from the&nbsp;<code>books</code>&nbsp;module.</p>\n" +
                    "<h3><a href=\"https://github.com/googlecodelabs/cloud-nodejs/blob/master/start/app.js\" target=\"_blank\">app.js</a></h3>\n" +
                    "<pre><code><span class=\"kwd\">var</span><span class=\"pln\"> config </span><span class=\"pun\">=</span> <span class=\"kwd\">require</span><span class=\"pun\">(</span><span class=\"str\">'./config'</span><span class=\"pun\">);</span>\n" +
                    "<span class=\"kwd\">var</span><span class=\"pln\"> books </span><span class=\"pun\">=</span> <span class=\"kwd\">require</span><span class=\"pun\">(</span><span class=\"str\">'./books'</span><span class=\"pun\">)(</span><span class=\"pln\">config</span><span class=\"pun\">);</span>\n" +
                    "<span class=\"com\">// ...</span>\n" +
                    "\n" +
                    "<span class=\"com\">/* Fetch all books and display them */</span><span class=\"pln\">\n" +
                    "app</span><span class=\"pun\">.</span><span class=\"kwd\">get</span><span class=\"pun\">(</span><span class=\"str\">'/'</span><span class=\"pun\">,</span> <span class=\"kwd\">function</span><span class=\"pun\">(</span><span class=\"pln\">req</span><span class=\"pun\">,</span><span class=\"pln\"> res</span><span class=\"pun\">,</span> <span class=\"kwd\">next</span><span class=\"pun\">)</span> <span class=\"pun\">{</span><span class=\"pln\">\n" +
                    "  books</span><span class=\"pun\">.</span><span class=\"pln\">getAllBooks</span><span class=\"pun\">(</span><span class=\"kwd\">function</span><span class=\"pun\">(</span><span class=\"pln\">err</span><span class=\"pun\">,</span><span class=\"pln\"> books</span><span class=\"pun\">,</span><span class=\"pln\"> key</span><span class=\"pun\">)</span> <span class=\"pun\">{</span>\n" +
                    "    <span class=\"kwd\">if</span> <span class=\"pun\">(</span><span class=\"pln\">err</span><span class=\"pun\">)</span> <span class=\"kwd\">return</span> <span class=\"kwd\">next</span><span class=\"pun\">(</span><span class=\"pln\">err</span><span class=\"pun\">);</span>\n" +
                    "    <span class=\"kwd\">var</span><span class=\"pln\"> keyBooks </span><span class=\"pun\">=</span><span class=\"pln\"> books</span><span class=\"pun\">.</span><span class=\"pln\">map</span><span class=\"pun\">((</span><span class=\"pln\">book</span><span class=\"pun\">)</span> <span class=\"pun\">=&gt;</span> <span class=\"typ\">Object</span><span class=\"pun\">.</span><span class=\"pln\">assign</span><span class=\"pun\">(</span><span class=\"pln\">book</span><span class=\"pun\">,</span> <span class=\"pun\">{</span><span class=\"pln\"> id</span><span class=\"pun\">:</span><span class=\"pln\"> book</span><span class=\"pun\">.</span><span class=\"pln\">id </span><span class=\"pun\">||</span><span class=\"pln\"> book</span><span class=\"pun\">[</span><span class=\"pln\">key</span><span class=\"pun\">].</span><span class=\"pln\">id </span><span class=\"pun\">}));</span><span class=\"pln\">\n" +
                    "    res</span><span class=\"pun\">.</span><span class=\"pln\">render</span><span class=\"pun\">(</span><span class=\"str\">'index'</span><span class=\"pun\">,</span> <span class=\"pun\">{</span><span class=\"pln\"> books</span><span class=\"pun\">:</span><span class=\"pln\"> keyBooks</span><span class=\"pun\">,</span><span class=\"pln\"> user</span><span class=\"pun\">:</span><span class=\"pln\"> req</span><span class=\"pun\">.</span><span class=\"pln\">session</span><span class=\"pun\">.</span><span class=\"pln\">user </span><span class=\"pun\">});</span>\n" +
                    "  <span class=\"pun\">});</span>                                                                              \n" +
                    "<span class=\"pun\">});</span></code></pre>\n" +
                    "<p>The current implementation of&nbsp;<code>getAllBooks</code>&nbsp;found in&nbsp;<code>books.js</code>&nbsp;simply returns a fake book.</p>\n" +
                    "<h3><a href=\"https://github.com/googlecodelabs/cloud-nodejs/blob/master/start/books.js\" target=\"_blank\">books.js</a></h3>\n" +
                    "<pre><code><span class=\"kwd\">function</span><span class=\"pln\"> getAllBooks</span><span class=\"pun\">(</span><span class=\"pln\">callback</span><span class=\"pun\">)</span> <span class=\"pun\">{</span>                                                \n" +
                    "  <span class=\"kwd\">var</span><span class=\"pln\"> error </span><span class=\"pun\">=</span> <span class=\"kwd\">null</span><span class=\"pun\">;</span>\n" +
                    "  <span class=\"kwd\">var</span><span class=\"pln\"> books </span><span class=\"pun\">=</span> <span class=\"pun\">[</span>\n" +
                    "    <span class=\"pun\">{</span><span class=\"pln\"> id</span><span class=\"pun\">:</span> <span class=\"lit\">12345</span><span class=\"pun\">,</span><span class=\"pln\"> title</span><span class=\"pun\">:</span> <span class=\"str\">'Fake Book'</span><span class=\"pun\">,</span><span class=\"pln\"> author</span><span class=\"pun\">:</span> <span class=\"str\">'Fake Author'</span> <span class=\"pun\">}</span>\n" +
                    "  <span class=\"pun\">];</span><span class=\"pln\">\n" +
                    "  callback</span><span class=\"pun\">(</span><span class=\"pln\">error</span><span class=\"pun\">,</span><span class=\"pln\"> books</span><span class=\"pun\">);</span>\n" +
                    "<span class=\"pun\">}</span></code></pre>\n" +
                    "<p>In this step, you will write the code for&nbsp;<code>getAllBooks</code>&nbsp;to query for Book entities from Datastore.</p>\n" +
                    "<h3>Configure Datastore</h3>\n" +
                    "<p>To begin, install the&nbsp;<a href=\"https://github.com/GoogleCloudPlatform/google-cloud-node\" target=\"_blank\"><code>google-cloud</code></a>&nbsp;npm package, which you will use to interact with Cloud Datastore.</p>\n" +
                    "<pre>npm install google-cloud@^0.57.0 --save</pre>\n" +
                    "<aside class=\"special\">\n" +
                    "<p>The&nbsp;<a href=\"https://github.com/GoogleCloudPlatform/google-cloud-node\" target=\"_blank\"><code>google-cloud</code></a>&nbsp;node package is an idiomatic node.js client library for&nbsp;<a href=\"https://cloud.google.com/\" target=\"_blank\">Google Cloud Platform</a>&nbsp;services.</p>\n" +
                    "</aside>\n" +
                    "<p>While still in the project directory&nbsp;<code>cloud-nodejs/start</code>&nbsp;edit the&nbsp;<code>books.js</code>&nbsp;file.</p>\n" +
                    "<p>Copy the following code block:</p>\n" +
                    "<pre><code>  <span class=\"kwd\">var</span><span class=\"pln\"> gcloud </span><span class=\"pun\">=</span> <span class=\"kwd\">require</span><span class=\"pun\">(</span><span class=\"str\">'google-cloud'</span><span class=\"pun\">);</span>\n" +
                    "\n" +
                    "  <span class=\"kwd\">var</span><span class=\"pln\"> datastore </span><span class=\"pun\">=</span><span class=\"pln\"> gcloud</span><span class=\"pun\">.</span><span class=\"pln\">datastore</span><span class=\"pun\">({</span><span class=\"pln\">\n" +
                    "    projectId</span><span class=\"pun\">:</span><span class=\"pln\"> config</span><span class=\"pun\">.</span><span class=\"pln\">projectId</span><span class=\"pun\">,</span><span class=\"pln\">\n" +
                    "    keyFilename</span><span class=\"pun\">:</span><span class=\"pln\"> config</span><span class=\"pun\">.</span><span class=\"pln\">keyFilename\n" +
                    "  </span><span class=\"pun\">});</span></code></pre>\n" +
                    "<p>Then paste the code block to the&nbsp;<code>books.js</code>&nbsp;file:</p>\n" +
                    "<h3><a href=\"https://github.com/googlecodelabs/cloud-nodejs/blob/master/start/books.js\" target=\"_blank\">books.js</a></h3>\n" +
                    "<pre><code><span class=\"kwd\">module</span><span class=\"pun\">.</span><span class=\"pln\">exports </span><span class=\"pun\">=</span> <span class=\"kwd\">function</span><span class=\"pun\">(</span><span class=\"pln\">config</span><span class=\"pun\">)</span> <span class=\"pun\">{</span>\n" +
                    "\n" +
                    "   <span class=\"com\">// Add the copied code block here</span>\n" +
                    "\n" +
                    "  <span class=\"kwd\">function</span><span class=\"pln\"> getAllBooks</span><span class=\"pun\">(</span><span class=\"pln\">callback</span><span class=\"pun\">)</span> <span class=\"pun\">{</span>\n" +
                    "    <span class=\"com\">// ...</span></code></pre>\n" +
                    "<p>The&nbsp;<code>gcloud.datastore</code>&nbsp;object allows you to interact with Google Cloud Datastore</p>\n" +
                    "<p>The&nbsp;<code>projectId</code>&nbsp;and&nbsp;<code>keyFilename</code>&nbsp;are read from the&nbsp;<code>config.js</code>&nbsp;file that you edited earlier.</p>\n" +
                    "<h3>Query for entities</h3>\n" +
                    "<p>Now replace the current&nbsp;<code>getAllBooks</code>&nbsp;function with the following:</p>\n" +
                    "<h3><a href=\"https://github.com/googlecodelabs/cloud-nodejs/blob/master/step-1-retrieve-books/books.js\" target=\"_blank\">books.js</a></h3>\n" +
                    "<pre><code><span class=\"kwd\">function</span><span class=\"pln\"> getAllBooks</span><span class=\"pun\">(</span><span class=\"pln\">callback</span><span class=\"pun\">)</span> <span class=\"pun\">{</span>\n" +
                    "  <span class=\"kwd\">var</span><span class=\"pln\"> query </span><span class=\"pun\">=</span><span class=\"pln\"> datastore</span><span class=\"pun\">.</span><span class=\"pln\">createQuery</span><span class=\"pun\">([</span><span class=\"str\">'Book'</span><span class=\"pun\">]);</span><span class=\"pln\">\n" +
                    "  datastore</span><span class=\"pun\">.</span><span class=\"pln\">runQuery</span><span class=\"pun\">(</span><span class=\"pln\">query</span><span class=\"pun\">,</span> <span class=\"pun\">(</span><span class=\"pln\">err</span><span class=\"pun\">,</span><span class=\"pln\"> books</span><span class=\"pun\">)</span> <span class=\"pun\">=&gt;</span><span class=\"pln\"> callback</span><span class=\"pun\">(</span><span class=\"pln\">err</span><span class=\"pun\">,</span><span class=\"pln\"> books</span><span class=\"pun\">,</span><span class=\"pln\"> datastore</span><span class=\"pun\">.</span><span class=\"pln\">KEY</span><span class=\"pun\">));</span>                                                   \n" +
                    "<span class=\"pun\">}</span></code></pre>\n" +
                    "<p>Datastore queries are built with&nbsp;<a href=\"http://googlecloudplatform.github.io/gcloud-node/#/docs/v0.34.0/datastore?method=createQuery\" target=\"_blank\"><code>datastore.createQuery</code></a>&nbsp;and run via&nbsp;<a href=\"http://googlecloudplatform.github.io/gcloud-node/#/docs/v0.34.0/datastore?method=runQuery\" target=\"_blank\"><code>datastore.runQuery</code></a>.&nbsp;<code>datastore.KEY</code>is a special value that names a property pointing to the entity's&nbsp;<code>key</code>.</p>\n" +
                    "<p><code>createQuery</code>&nbsp;accepts an array containing the kinds of entities to query and returns a&nbsp;<a href=\"http://googlecloudplatform.github.io/gcloud-node/#/docs/v0.14.0/datastore/query\" target=\"_blank\"><code>Query</code></a>&nbsp;object.</p>\n" +
                    "<p>In our case, we want to query for all&nbsp;<code>'Book'</code>&nbsp;entities.</p>\n" +
                    "<p><code>runQuery</code>&nbsp;runs a query and returns its results as a list of entities in the following format:</p>\n" +
                    "<pre><code><span class=\"pun\">{</span><span class=\"pln\">\n" +
                    "\n" +
                    "  title</span><span class=\"pun\">:</span> <span class=\"str\">'A Tale of Two Cities'</span><span class=\"pun\">,</span><span class=\"pln\">\n" +
                    "  author</span><span class=\"pun\">:</span> <span class=\"str\">'Charles Dickens'</span><span class=\"pun\">,</span><span class=\"pln\">\n" +
                    "  imageUrl</span><span class=\"pun\">:</span> <span class=\"str\">'http://books.google.com/books...'</span>\n" +
                    "<span class=\"pun\">}</span></code></pre>\n" +
                    "<h3><strong>Create Entity using the Developers Console</strong></h3>\n" +
                    "<p>To test the Datastore query and see data displayed, add a&nbsp;<code>Book</code>&nbsp;entity from the&nbsp;<a href=\"http://console.cloud.google.com/\" target=\"_blank\">Google Cloud Console</a>.</p>\n" +
                    "<ol start=\"1\" type=\"1\">\n" +
                    "<li>Open a new web browser tab and visit&nbsp;<a href=\"https://console.cloud.google.com/\" target=\"_blank\">Google Cloud Console</a></li>\n" +
                    "<li>Select to your Google Cloud Platform project using the dropdown at the top.</li>\n" +
                    "<li>From the left navigation menu under \"Storage\", click&nbsp;<strong>Datastore&nbsp;</strong><img src=\"https://codelabs.developers.google.com/codelabs/cloud-nodejs/img/9540218c28b2e814.png\" /></li>\n" +
                    "<li>Click&nbsp;<strong>Create Entity</strong></li>\n" +
                    "</ol>\n" +
                    "<p>Fill out the&nbsp;<strong>Create an entity</strong>&nbsp;form with the following:</p>\n" +
                    "<ol start=\"1\" type=\"1\">\n" +
                    "<li><strong>Namespace:&nbsp;</strong>Leave this set as [default]</li>\n" +
                    "<li><strong>Kind:&nbsp;</strong>Select&nbsp;<code>Book</code>&nbsp;from the dropdown. If&nbsp;<code>Book</code>&nbsp;is not present, type it in manually and add the following properties to the entity. (All of these properties should be&nbsp;<code>String</code>s.)</li>\n" +
                    "</ol>\n" +
                    "<ul>\n" +
                    "<li><code>author</code></li>\n" +
                    "<li><code>createdBy</code></li>\n" +
                    "<li><code>description</code></li>\n" +
                    "<li><code>imageUrl</code></li>\n" +
                    "<li><code>publishedDate</code></li>\n" +
                    "<li><code>title</code></li>\n" +
                    "</ul>\n" +
                    "<ol start=\"3\" type=\"1\">\n" +
                    "<li><strong>Key Identifier Type:&nbsp;</strong><em>leave the default value of \"Numeric ID (auto-generated)\"</em></li>\n" +
                    "<li>Under the property list, change the value of the&nbsp;<code>title</code>&nbsp;property to&nbsp;<code>A Tale of Two Cities</code></li>\n" +
                    "<li>Then, change the value of the&nbsp;<code>author</code>&nbsp;property to&nbsp;<code>Charles Dickens</code></li>\n" +
                    "<li>Click&nbsp;<strong>Save</strong></li>\n" +
                    "</ol>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-nodejs/img/582e1a9a519443ec.png\" /></p>\n" +
                    "<p>From Cloud Shell, make sure your running node.js web server is stopped. You should have done it in a previous step, but if have not, stop it now by pressing&nbsp;<code>CTRL + C</code>. Now run it again.</p>\n" +
                    "<pre>node app.js</pre>\n" +
                    "<p>To view your changes, click the \"Web preview\" icon that appears at the top left side of the cloud shell window and select \"Preview on port 8080\" to see the app in a web browser.</p>\n" +
                    "<p>Now you should see the book listed!</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-nodejs/img/cb5d3b895a7bd5a6.png\" /></p>\n" +
                    "<h2><strong>Summary</strong></h2>\n" +
                    "<p>In this step, you queried for all Book entities from Google Cloud Datastore.</p>\n" +
                    "<h2><strong>Next up</strong></h2>\n" +
                    "<p>Next, you will write the code to create and delete books.</p>");
            sec7Node1.setLesson(nodeJsLesson1);
            nodeJsLesson1.getSections().add(sec7Node1);

            Section sec1Node2 = new Section();
            sec1Node2.setOrdinalNumber(1);
            sec1Node2.setDescription("Run the Application Locally");
            sec1Node2.setContent("<p>You can start the Node.js application normally with&nbsp;<code>npm</code>:</p>\n" +
                    "<pre><code><span class=\"pln\">npm start</span></code></pre>\n" +
                    "<p>Once the application started, click on the Web Preview icon<img src=\"https://codelabs.developers.google.com/codelabs/cloud-app-engine-node/img/2db57663e4b2d819.png\" />in the Cloud Shell toolbar and choose&nbsp;<strong>preview on port 8080</strong>.</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-app-engine-node/img/1ccb86d5704356bc.png\" /></p>\n" +
                    "<p>A tab in your browser opens and connects to the server you just started.</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-app-engine-node/img/13fec253414127d.png\" /></p>");
            sec1Node2.setLesson(nodeJsLesson2);
            nodeJsLesson2.getSections().add(sec1Node2);

            Section sec2Node2 = new Section();
            sec2Node2.setOrdinalNumber(2);
            sec2Node2.setDescription("Deploying the Application into App Engine");
            sec2Node2.setContent("App Engine uses a file called app.yaml to describe an application's deployment configuration. If this file is not present, App Engine will try to guess the deployment configuration. However, it is a good idea to provide this file.\n" +
                    "\n" +
                    "Open app.yaml to see what it contains. You can use vim, nano,or emacs to edit the file or use the code editor:\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "app.yaml\n" +
                    "runtime: nodejs8\n" +
                    "This is the basic configuration needed to deploy a Node.js application. You can learn more about configuring App Engine here.\n" + "\n" +
                    "To deploy your application into App Engine environment, run gcloud app deploy:\n" +
                    "\n" +
                    "gcloud app deploy\n" +
                    "Because this is the first time you are deploying App Engine, the tool will prompt you to select a location to deploy the app. For this lab choose us-central, which is choice 9.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "First time deployment up to 2 minutes.\n" +
                    "\n" +
                    "After the application is deployed, you can visit it by opening the URL http://<project-id>.appspot.com in your web browser.\n" +
                    "\n" +
                    "If you don't remember your project-id, please refer to the \"Setup and Requirements\" section or check the deployment logs for something similar to this:\n" +
                    "\n" +
                    "Deployed service [default] to [https://<project-id>.appspot.com]\n" +
                    "\n" +
                    "Optionally, you can instead purchase and use a top-level domain name for your app, or use one that you have already registered.\n" +
                    "\n" +
                    "Summary\n" +
                    "In this step, you set up a simple Node.js application and ran and deployed your application on App Engine.");
            sec2Node2.setLesson(nodeJsLesson2);
            nodeJsLesson2.getSections().add(sec2Node2);

            Section sec3Node2 = new Section();
            sec3Node2.setOrdinalNumber(3);
            sec3Node2.setDescription("Updating the Application");
            sec3Node2.setContent("Update the application to generate a UUID every time someone visits the page.\n" +
                    "\n" +
                    "Install the uuid package with npm:\n" +
                    "\n" +
                    "npm install uuid --save\n" +
                    "Now modify app.js to require uuid and then call the function in the response. You can use vim, nano,or emacs to edit the file or use the code editor:\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "app.js\n" +
                    "// [START app]\n" +
                    "'use strict';\n" +
                    "\n" +
                    "const express = require('express');\n" +
                    "const uuid = require('uuid');\n" +
                    "const app = express();\n" +
                    "\n" +
                    "app.get('/', (req, res) => {\n" +
                    "  res.status(200).send(`Hello, ${uuid()}!`);\n" +
                    "});\n" +
                    "\n" +
                    "// Start the server\n" +
                    "const PORT = process.env.PORT || 8080;\n" +
                    "app.listen(PORT, () => {\n" +
                    "  console.log(`App listening on port ${PORT}`);\n" +
                    "  console.log('Press Ctrl+C to quit.');\n" +
                    "});\n" +
                    "// [END app]\n" +
                    "Now, you can test the application locally.\n" +
                    "\n" +
                    "Start the Node.js application with npm:\n" +
                    "\n" +
                    "npm start\n" +
                    "Once the application started, click on the Web Preview iconin the Cloud Shell toolbar and choose preview on port 8080.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "A tab in your browser opens and connects to the server you just started. You should see the new app that displays a UUID!\n" +
                    "\n" +
                    "\n" +
                    "To deploy your updated application, run gcloud app deploy:\n" +
                    "\n" +
                    "gcloud app deploy\n" +
                    "In a few minutes, the new version will be deployed and you can visit it by opening the URL http://<project-id>.appspot.com in your web browser.\n" +
                    "\n" +
                    "Summary\n" +
                    "In this step, you updated your Node.js application without any downtime.");
            sec3Node2.setLesson(nodeJsLesson2);
            nodeJsLesson2.getSections().add(sec3Node2);

            Section sec4Node2 = new Section();
            sec4Node2.setOrdinalNumber(4);
            sec4Node2.setDescription("Create a Slack bot user");
            sec4Node2.setContent("<p>A&nbsp;<a href=\"https://api.slack.com/bot-users\" target=\"_blank\">bot user</a>&nbsp;can listen to messages on Slack, post messages, and upload files. In this codelab, you will create a bot post a simple greeting message.</p>\n" +
                    "<h2><strong>Create a new Slack app</strong></h2>\n" +
                    "<ul>\n" +
                    "<li>Go to the&nbsp;<a href=\"https://api.slack.com/apps\" target=\"_blank\">Slack apps management page</a>.</li>\n" +
                    "<li>Click the&nbsp;<strong>Create new app</strong>&nbsp;button in the upper-right corner.</li>\n" +
                    "<li>Give the app a name, such as \"Kittenbot\".</li>\n" +
                    "<li>Choose the Slack team where you want it installed.</li>\n" +
                    "</ul>\n" +
                    "<h2><strong>Add a new bot user to the app.</strong></h2>\n" +
                    "<ul>\n" +
                    "<li>Select&nbsp;<strong>Bot users</strong>&nbsp;under the features heading on the left-hand side navigation of the app configuration page.</li>\n" +
                    "<li>Click the&nbsp;<strong>Add a bot user</strong>&nbsp;button.</li>\n" +
                    "<li>Give it a nice username, like&nbsp;<code>@kittenbot</code>.</li>\n" +
                    "<li>This tutorial uses the Realtime Messaging (RTM) API, so keep the&nbsp;<strong>Always show the bot as online</strong>&nbsp;option selected as&nbsp;<strong>Off</strong>. The bot user will show as online only when there is a connection from the bot.</li>\n" +
                    "<li>Click the&nbsp;<strong>Add bot user</strong>&nbsp;button.</li>\n" +
                    "</ul>\n" +
                    "<h2><strong>Get the bot user OAuth access token</strong></h2>\n" +
                    "<ul>\n" +
                    "<li>Select&nbsp;<strong>OAuth &amp; Permissions</strong>&nbsp;under the features heading on the left-hand side navigation of the app configuration page.</li>\n" +
                    "<li>Click the&nbsp;<strong>Reinstall app</strong>&nbsp;button. This will reinstall the app to your team and add the bot user you just created.</li>\n" +
                    "<li>Click the&nbsp;<strong>Copy</strong>&nbsp;button to copy the&nbsp;<strong>Bot user OAuth access token</strong>&nbsp;text into your clipboard.</li>\n" +
                    "<li>You'll use the token in the next step. Don't worry. You can come back this configuration page from the&nbsp;<a href=\"https://api.slack.com/apps\" target=\"_blank\">apps management page</a>&nbsp;if you need to get this token again.</li>\n" +
                    "</ul>\n" +
                    "<aside class=\"warning\">\n" +
                    "<p><a href=\"https://api.slack.com/docs/oauth-safety\" target=\"_blank\">Be careful</a>&nbsp;with your bot user OAuth access token. Treat it like you would any other secret token. Do not store tokens in version control or share them publicly.</p>\n" +
                    "</aside>");
            sec4Node2.setLesson(nodeJsLesson2);
            nodeJsLesson2.getSections().add(sec4Node2);

            Section sec5Node2 = new Section();
            sec5Node2.setOrdinalNumber(5);
            sec5Node2.setDescription("Run the sample app");
            sec5Node2.setContent("<p>Edit the&nbsp;<code>kittenbot.js</code>&nbsp;file and enter your Slack bot token. If it is no longer in your clipboard, you can get it from the&nbsp;<a href=\"https://my.slack.com/apps/manage/custom-integrations\" target=\"_blank\">bot custom integration configuration page</a>. You can use any editor of your choice, such as&nbsp;<code>emacs</code>&nbsp;or&nbsp;<code>vim</code>. This tutorial uses the&nbsp;<a href=\"https://cloud.google.com/shell/docs/features#code_editor\" target=\"_blank\">code editor feature of Cloud Shell</a>&nbsp;for simplicity.</p>\n" +
                    "<ul>\n" +
                    "<li>Open the code editor.<br /><img src=\"https://codelabs.developers.google.com/codelabs/cloud-slack-bot/img/3cc88b2369c9963d.png\" /></li>\n" +
                    "<li>Select the&nbsp;<code>cloud-slack-bot/start/kittenbot.js</code>&nbsp;file.<br /><img src=\"https://codelabs.developers.google.com/codelabs/cloud-slack-bot/img/d530308ee7655f15.png\" /></li>\n" +
                    "<li>Paste your Slack token to replace&nbsp;<code>your-slack-token</code>&nbsp;in the file and save the file with&nbsp;<strong>Ctrl-S&nbsp;</strong>or the&nbsp;<strong>File -&gt; Save</strong>menu item.</li>\n" +
                    "</ul>\n" +
                    "<h3><a href=\"https://github.com/googlecodelabs/cloud-slack-bot/blob/master/start/kittenbot.js\" target=\"_blank\">kittenbot.js</a></h3>\n" +
                    "<pre><code><span class=\"kwd\">var</span> <span class=\"typ\">Botkit</span> <span class=\"pun\">=</span> <span class=\"kwd\">require</span><span class=\"pun\">(</span><span class=\"str\">'botkit'</span><span class=\"pun\">)</span>\n" +
                    "\n" +
                    "<span class=\"kwd\">var</span><span class=\"pln\"> controller </span><span class=\"pun\">=</span> <span class=\"typ\">Botkit</span><span class=\"pun\">.</span><span class=\"pln\">slackbot</span><span class=\"pun\">({</span><span class=\"pln\">debug</span><span class=\"pun\">:</span> <span class=\"kwd\">false</span><span class=\"pun\">})</span><span class=\"pln\">\n" +
                    "controller\n" +
                    "  </span><span class=\"pun\">.</span><span class=\"pln\">spawn</span><span class=\"pun\">({</span><span class=\"pln\">\n" +
                    "    token</span><span class=\"pun\">:</span> <span class=\"str\">'your-slack-token'</span> <span class=\"com\">// Edit this line!</span>\n" +
                    "  <span class=\"pun\">})</span>\n" +
                    "  <span class=\"pun\">.</span><span class=\"pln\">startRTM</span><span class=\"pun\">(</span><span class=\"kwd\">function</span> <span class=\"pun\">(</span><span class=\"pln\">err</span><span class=\"pun\">)</span> <span class=\"pun\">{</span>\n" +
                    "    <span class=\"kwd\">if</span> <span class=\"pun\">(</span><span class=\"pln\">err</span><span class=\"pun\">)</span> <span class=\"pun\">{</span>\n" +
                    "      <span class=\"kwd\">throw</span> <span class=\"kwd\">new</span> <span class=\"typ\">Error</span><span class=\"pun\">(</span><span class=\"pln\">err</span><span class=\"pun\">)</span>\n" +
                    "    <span class=\"pun\">}</span>\n" +
                    "  <span class=\"pun\">})</span><span class=\"pln\">\n" +
                    "\n" +
                    "controller</span><span class=\"pun\">.</span><span class=\"pln\">hears</span><span class=\"pun\">(</span>\n" +
                    "  <span class=\"pun\">[</span><span class=\"str\">'hello'</span><span class=\"pun\">,</span> <span class=\"str\">'hi'</span><span class=\"pun\">],</span> <span class=\"pun\">[</span><span class=\"str\">'direct_message'</span><span class=\"pun\">,</span> <span class=\"str\">'direct_mention'</span><span class=\"pun\">,</span> <span class=\"str\">'mention'</span><span class=\"pun\">],</span>\n" +
                    "  <span class=\"kwd\">function</span> <span class=\"pun\">(</span><span class=\"pln\">bot</span><span class=\"pun\">,</span><span class=\"pln\"> message</span><span class=\"pun\">)</span> <span class=\"pun\">{</span><span class=\"pln\"> bot</span><span class=\"pun\">.</span><span class=\"pln\">reply</span><span class=\"pun\">(</span><span class=\"pln\">message</span><span class=\"pun\">,</span> <span class=\"str\">'Meow. :smile_cat:'</span><span class=\"pun\">)</span> <span class=\"pun\">})</span></code></pre>\n" +
                    "<ul>\n" +
                    "<li>Switch back to Cloud Shell and run your bot.</li>\n" +
                    "</ul>\n" +
                    "<pre>node kittenbot.js</pre>\n" +
                    "<p>In your Slack team, you should now see that @kittenbot is online.</p>\n" +
                    "<ul>\n" +
                    "<li>If you do not see kittenbot in your direct messages list, you may need to open a direct message to the bot.<br /><img src=\"https://codelabs.developers.google.com/codelabs/cloud-slack-bot/img/cd6a1d257419f41a.png\" /><br /><img src=\"https://codelabs.developers.google.com/codelabs/cloud-slack-bot/img/22fad5ce5edf666e.png\" /></li>\n" +
                    "<li>Say hello to @kittenbot in a direct message (or if you added @kittenbot to a channel, the bot will respond to mentions there, too). It should meow back at you.</li>\n" +
                    "</ul>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-slack-bot/img/f9bd9c77c9415b74.png\" /></p>\n" +
                    "<ul>\n" +
                    "<li>Go back to the Cloud Shell and press Control-C to stop the bot server.</li>\n" +
                    "</ul>");
            sec5Node2.setLesson(nodeJsLesson2);
            nodeJsLesson2.getSections().add(sec5Node2);

            Section sec6Node2 = new Section();
            sec6Node2.setOrdinalNumber(6);
            sec6Node2.setDescription("Create a Docker container image");
            sec6Node2.setContent("<p>Docker provides a way to containerize your bot. A Docker image bundles all of your dependencies (even the compiled ones) so that it can run in a lightweight sandbox.</p>\n" +
                    "<h2>Building a Docker image</h2>\n" +
                    "<ul>\n" +
                    "<li>Create a file called&nbsp;<code>Dockerfile</code>.</li>\n" +
                    "<li>Enter the following definition, which describes how to build your Docker image.</li>\n" +
                    "</ul>\n" +
                    "<h3><a href=\"https://github.com/googlecodelabs/cloud-slack-bot/blob/master/step-2-docker/Dockerfile\" target=\"_blank\">Dockerfile</a></h3>\n" +
                    "<pre><code><span class=\"pln\">FROM node</span><span class=\"pun\">:</span><span class=\"lit\">5.4</span><span class=\"pln\">\n" +
                    "COPY </span><span class=\"kwd\">package</span><span class=\"pun\">.</span><span class=\"pln\">json </span><span class=\"pun\">/</span><span class=\"pln\">src</span><span class=\"pun\">/</span><span class=\"kwd\">package</span><span class=\"pun\">.</span><span class=\"pln\">json\n" +
                    "WORKDIR </span><span class=\"pun\">/</span><span class=\"pln\">src\n" +
                    "RUN npm install\n" +
                    "COPY kittenbot</span><span class=\"pun\">.</span><span class=\"pln\">js </span><span class=\"pun\">/</span><span class=\"pln\">src\n" +
                    "CMD </span><span class=\"pun\">[</span><span class=\"str\">\"node\"</span><span class=\"pun\">,</span> <span class=\"str\">\"/src/kittenbot.js\"</span><span class=\"pun\">]</span></code></pre>\n" +
                    "<ul>\n" +
                    "<li>Save this file.</li>\n" +
                    "</ul>\n" +
                    "<p>A&nbsp;<code>Dockerfile</code>&nbsp;is a recipe for a Docker image. This one layers on top of the&nbsp;<a href=\"https://hub.docker.com/_/node/\" target=\"_blank\">Node.js base image</a>&nbsp;found on the Docker hub, copies&nbsp;<code>package.json</code>&nbsp;to the image and installs the dependencies listed in it, copies the&nbsp;<code>kittenbot.js</code>&nbsp;file to the image, and tells Docker to that it should run the Node.js server when the image starts.</p>\n" +
                    "<ul>\n" +
                    "<li>Go back to the Cloud Shell.</li>\n" +
                    "<li>Run this command to save your project ID to the environment variable&nbsp;<code>PROJECT_ID</code>. Commands in this tutorial will use this variable as&nbsp;<code>$PROJECT_ID</code>.</li>\n" +
                    "</ul>\n" +
                    "<pre>export PROJECT_ID=$(gcloud config list --format 'value(core.project)')</pre>\n" +
                    "<ul>\n" +
                    "<li>Build the image by running the&nbsp;<code>docker build</code>&nbsp;command. (This command takes about 4 minutes to complete. It has to download the base image and Node.js dependencies.)</li>\n" +
                    "</ul>\n" +
                    "<pre>docker build -t gcr.io/${PROJECT_ID}/slack-codelab:v1 .</pre>\n" +
                    "<h2><strong>Extra Credit: Create a incoming webhook to Slack</strong></h2>\n" +
                    "<p>While the Docker image is building, you can try out some of the other Slack APIs. For example, an&nbsp;<a href=\"https://api.slack.com/incoming-webhooks\" target=\"_blank\">incoming webhook</a>&nbsp;is an easy way to send Slack notifications from another service or app without having to worry about a persistent connection for two-way communication like we do with a bot user.</p>\n" +
                    "<ul>\n" +
                    "<li>Go to the&nbsp;<a href=\"https://my.slack.com/apps/manage/custom-integrations\" target=\"_blank\">Slack Custom Integrations management console</a>.</li>\n" +
                    "<li>Click&nbsp;<strong>Incoming WebHooks</strong>, then the&nbsp;<strong>Add configuration</strong>&nbsp;button.</li>\n" +
                    "<li>Select a Slack channel for messages to post to (or have them go privately to your Slack user).</li>\n" +
                    "<li>Click the&nbsp;<strong>Add incoming webhooks integration</strong>&nbsp;button.</li>\n" +
                    "</ul>\n" +
                    "<p>By now your Docker build should be complete. We will come back to this integration in a later step.</p>\n" +
                    "<h2>Testing a Docker image locally</h2>\n" +
                    "<ul>\n" +
                    "<li>Go back to Cloud Shell.</li>\n" +
                    "<li>Test the image locally with the following command which will run a Docker container as a daemon from our newly-created container image:</li>\n" +
                    "</ul>\n" +
                    "<pre>docker run -d \\\n" +
                    "    -v $(pwd)/:/config \\\n" +
                    "    -e slack_token_path=/config/slack-token \\\n" +
                    "    gcr.io/${PROJECT_ID}/slack-codelab:v1</pre>\n" +
                    "<p>This command also mounts the current directory as a volume inside the container to give it access to the&nbsp;<code>slack-token</code>&nbsp;file. You should see that @kittenbot is online again.</p>\n" +
                    "<aside class=\"special\">\n" +
                    "<p>Here's the full documentation for the&nbsp;<code>docker run</code>&nbsp;command:&nbsp;<a href=\"https://docs.docker.com/engine/reference/run/\" target=\"_blank\">https://docs.docker.com/engine/reference/run/</a></p>\n" +
                    "</aside>\n" +
                    "<p>Let's now stop the running container.</p>\n" +
                    "<ul>\n" +
                    "<li>Get the ID of the running container with the&nbsp;<code>docker ps</code>&nbsp;command:</li>\n" +
                    "</ul>\n" +
                    "<pre>docker ps</pre>\n" +
                    "<h3>Command output</h3>\n" +
                    "<pre>CONTAINER ID   IMAGE                               COMMAND\n" +
                    "fab8b7a0d6ee   gcr.io/your-proj/slack-codelab:v1   \"node /src/kittenbot.\"</pre>\n" +
                    "<ul>\n" +
                    "<li>Stop the container. Replace the docker container ID (<code>fab8b7a0d6ee</code>&nbsp;in the example) with the ID of your container:</li>\n" +
                    "</ul>\n" +
                    "<pre>docker stop fab8b7a0d6ee</pre>\n" +
                    "<h3 class=\"faq\"><strong>Frequently Asked Questions</strong></h3>\n" +
                    "<ul class=\"faq\">\n" +
                    "<li><a href=\"http://stackoverflow.com/q/35599414\" target=\"_blank\">How do I get the project ID from the gcloud command-line tool?</a></li>\n" +
                    "</ul>");
            sec6Node2.setLesson(nodeJsLesson2);
            nodeJsLesson2.getSections().add(sec6Node2);

            Section sec7Node2 = new Section();
            sec7Node2.setOrdinalNumber(7);
            sec7Node2.setDescription("Pushing a Docker image to Google Container Registry");
            sec7Node2.setContent("<ul class=\"faq\">\n" +
                    "<li>\n" +
                    "<p>Now that the image works as intended we can push it to the&nbsp;<a href=\"https://cloud.google.com/container-registry/\" target=\"_blank\">Google Container Registry</a>, a private repository for your Docker images accessible from every Google Cloud project (but also from outside Google Cloud Platform).</p>\n" +
                    "<ul>\n" +
                    "<li>Push the Docker image to Google Container Registry from Cloud Shell. (This command takes about 5 minutes to complete.)</li>\n" +
                    "</ul>\n" +
                    "<pre>gcloud docker -- push gcr.io/${PROJECT_ID}/slack-codelab:v1</pre>\n" +
                    "<h2><strong>Extra Credit: Testing an incoming webhook</strong></h2>\n" +
                    "<p>While waiting for the image to upload, use the incoming webhook to send a notification to Slack.</p>\n" +
                    "<ul>\n" +
                    "<li>In Cloud Shell, click the&nbsp;<strong>+</strong>&nbsp;button to add a new Cloud Shell session.<br /><img src=\"https://codelabs.developers.google.com/codelabs/cloud-slack-bot/img/e876cbd7bd3a1f32.png\" /></li>\n" +
                    "<li>Go back to the incoming webhook you created. If you closed that browser tab, you can get back to there from the&nbsp;<a href=\"https://my.slack.com/apps/manage/custom-integrations\" target=\"_blank\">Slack Custom Integrations management console</a>.</li>\n" +
                    "<li>Copy the webhook URL from the configuration page.</li>\n" +
                    "<li>In the new Cloud Shell session, run&nbsp;<code>curl</code>&nbsp;to send an HTTP request with your message to Slack. (Replace the URL with your webhook URL.)</li>\n" +
                    "</ul>\n" +
                    "<pre>curl -X POST --data-urlencode \\\n" +
                    "    'payload={\"text\": \"Hello from Cloud Shell.\"}' \\\n" +
                    "    https://hooks.slack.com/services/YOUR/WEBHOOK/URL</pre>\n" +
                    "<p>This demonstrates that anywhere that you can send an HTTP request, you can send a message to Slack. This is a really easy way to integrate your own apps and services with Slack notifications.</p>\n" +
                    "<p>For more complicated messages, test out the JSON request first in the&nbsp;<a href=\"https://api.slack.com/docs/messages/builder\" target=\"_blank\">Slack message builder</a>.</p>\n" +
                    "<h2><strong>Viewing images in Google Container Registry</strong></h2>\n" +
                    "<p>When the image upload completes, you can see the container image listed in the Google Cloud Console:&nbsp;<a href=\"https://console.cloud.google.com/kubernetes/images/list\" target=\"_blank\"><em>Container Engine &gt; Container Registry</em></a>. We now have a project-wide Docker image available which Kubernetes can access and orchestrate as we'll see in a few minutes.</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-slack-bot/img/313206ea857ccb7a.png\" /></p>\n" +
                    "<aside class=\"special\">\n" +
                    "<p>Note that while here we used a generic domain for the registry (<code>gcr.io</code>), you can also be more specific about which zone and bucket to use. Details are documented here:&nbsp;<a href=\"https://cloud.google.com/container-registry/#pushing_to_the_registry\" target=\"_blank\">https://cloud.google.com/container-registry/#pushing_to_the_registry</a></p>\n" +
                    "</aside>\n" +
                    "<p>If you're curious, you can navigate through the container images as they are stored in Google Cloud Storage by following this link:&nbsp;<a href=\"https://console.cloud.google.com/storage/browser/\" target=\"_blank\">https://console.cloud.google.com/storage/browser/</a>.</p>\n" +
                    "<h3 class=\"faq\"><strong>Frequently Asked Questions</strong></h3>\n" +
                    "<ul class=\"faq\">\n" +
                    "<li><a href=\"https://cloud.google.com/container-registry/docs/troubleshooting\" target=\"_blank\">Troubleshooting Google Container Registry (Unable to ping registry endpoint).</a></li>\n" +
                    "<li><a href=\"http://stackoverflow.com/a/37036348/101923\" target=\"_blank\">\"Repository does not exist\" error when doing gcloud docker push command.</a></li>\n" +
                    "</ul>\n" +
                    "</li>\n" +
                    "</ul>");
            sec7Node2.setLesson(nodeJsLesson2);
            nodeJsLesson2.getSections().add(sec7Node2);


            Section sec1Node3 = new Section();
            sec1Node3.setOrdinalNumber(1);
            sec1Node3.setDescription("Sự phù hợp với đặc tả của JPA");
            sec1Node3.setContent("Hibernate là cài đặt ORM Java thành công nhất. Không ngạc nhiên khi mà các đặc tả cho Java persistence API (JPA) bị ảnh hưởng nhiều bởi Hibernate API. Cũng không ngạc nhiên khi Hibernate là ORM Framework phổ biến nhất.");
            sec1Node3.setLesson(nodeJsLesson3);
            nodeJsLesson3.getSections().add(sec1Node3);

            Section sec2Node3 = new Section();
            sec2Node3.setOrdinalNumber(2);
            sec2Node3.setDescription(" Sự khác nhau giữa các hành động thực thi");
            sec2Node3.setContent("Các method persist, save, update, merge, saveOrUpdate không lập tức đưa ra kết quả tương ứng SQL UPDATE hoặc INSERT. Thực tế thì việc cập nhật dữ liệu vào database xảy ra khi transaction được commit hoặc flushing session. Cũng không ngạc nhiên khi Hibernate là ORM Framework phổ biến nhất.");
            sec2Node3.setLesson(nodeJsLesson3);
            nodeJsLesson3.getSections().add(sec2Node3);

            Section sec3Node3 = new Section();
            sec3Node3.setOrdinalNumber(3);
            sec3Node3.setDescription("Persist");
            sec3Node3.setContent("Điều gì xảy ra sau khi method persist được gọi? Đối tượng person bị đổi trạng thái từ transient sang persistent. Đối tượng vào trong persistence context nhưng vẫn chưa được lưu vào database.");
            sec3Node3.setLesson(nodeJsLesson3);
            nodeJsLesson3.getSections().add(sec3Node3);

            Section sec4Node3 = new Section();
            sec4Node3.setOrdinalNumber(4);
            sec4Node3.setDescription("Custom machine types");
            sec4Node3.setContent("<ul class=\"faq\">\n" +
                    "<li>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<p>In the previous section, you learned that there are a number of&nbsp;<a href=\"https://cloud.google.com/compute/docs/machine-types#predefined_machine_types\" target=\"_blank\">predefined machine types</a>&nbsp;that you can choose for your virtual machine. However, if predefined machine types do not meet your needs, you can create an instance with custom virtualized hardware settings. Specifically, you can create an instance with a custom number of vCPUs and amount of memory, effectively using a custom machine type.</p>\n" +
                    "<p>Create another virtual machine instance using the Google Cloud Console, and choose a custom machine type by clicking&nbsp;<strong>Customize</strong>:</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/a0813a6f2ab5765d.png\" /></p>\n" +
                    "<p>Then, you use the sliders to pick the exact number of cores and memory to use:</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/cab8aa7833d57791.png\" /></p>\n" +
                    "<p>Create a virtual machine instance with 2 vCPU and 5 GB of RAM.</p>\n" +
                    "</li>\n" +
                    "<li>&nbsp;</li>\n" +
                    "</ul>");
            sec4Node3.setLesson(nodeJsLesson3);
            nodeJsLesson3.getSections().add(sec4Node3);

            Section sec5Node3 = new Section();
            sec5Node3.setOrdinalNumber(5);
            sec5Node3.setDescription("Create a new instance, with gcloud");
            sec5Node3.setContent("<ul class=\"faq\">\n" +
                    "<li>\n" +
                    "<p>Rather than using the Google Cloud Console to create a virtual machine instance, you can also use the command line tool called&nbsp;<code>gcloud</code>.</p>\n" +
                    "<p>We'll use&nbsp;<a href=\"https://cloud.google.com/developer-shell/#how_do_i_get_started\" target=\"_blank\">Google Cloud Shell</a>,<a href=\"https://cloud.google.com/developer-shell/#how_do_i_get_started\" target=\"_blank\">&nbsp;a command line environment running in the Cloud</a>. This Debian-based virtual machine is loaded with all the development tools you'll need (<code>gcloud</code>,&nbsp;<code>git</code>&nbsp;and others) and offers a persistent 5GB home directory.</p>\n" +
                    "<aside class=\"special\">\n" +
                    "<p>You don't need to manually install&nbsp;<code>gcloud</code>&nbsp;for this lab since it's preinstalled in Cloud Shell. But if you want to try this on your own machine in the future, read the&nbsp;<a href=\"https://cloud.google.com/sdk/gcloud/\" target=\"_blank\">gcloud command line tool guide</a>.</p>\n" +
                    "</aside>\n" +
                    "<p>Open the Google Cloud Shell by clicking on the&nbsp;<img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/3b409efdcc18f697.png\" />icon on the top right of the screen:</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/446be36b8e6592.png\" /></p>\n" +
                    "<p>Once opened, you can create a new virtual machine instance from the command line by using&nbsp;<code>gcloud</code>&nbsp;(feel free to use another zone closer to you) :</p>\n" +
                    "<pre>$ gcloud compute instances create gcelab2 --zone us-central1-c\n" +
                    "Created [...gcelab2].\n" +
                    "NAME     ZONE           MACHINE_TYPE  PREEMPTIBLE INTERNAL_IP EXTERNAL_IP    STATUS\n" +
                    "gcelab2  us-central1-c  n1-standard-1             10.240.X.X  X.X.X.X        RUNNING</pre>\n" +
                    "<p>The instance was created with some default values:</p>\n" +
                    "<ul>\n" +
                    "<li>The latest&nbsp;<a href=\"https://cloud.google.com/compute/docs/operating-systems/linux-os#debian\" target=\"_blank\">Debian 8 (Jessie)</a>&nbsp;image.</li>\n" +
                    "<li>The&nbsp;<code>n1-standard-1</code>&nbsp;<a href=\"https://cloud.google.com/compute/docs/machine-types\" target=\"_blank\">machine type</a>. You can select another machine type such as&nbsp;<code>n1-highmem-4</code>&nbsp;or&nbsp;<code>n1-highcpu-6</code>. If none of the&nbsp;<a href=\"https://cloud.google.com/compute/docs/machine-types#predefined_machine_types\" target=\"_blank\">predefined machine types</a>&nbsp;match your needs, use a&nbsp;<a href=\"https://cloud.google.com/compute/docs/instances/creating-instance-with-custom-machine-type\" target=\"_blank\">custom machine type</a>.</li>\n" +
                    "<li>A root persistent disk with the same name as the instance; the disk is automatically attached to the instance.</li>\n" +
                    "</ul>\n" +
                    "<p>Run&nbsp;<code>gcloud compute instances create --help</code>&nbsp;to see all the defaults.</p>\n" +
                    "<aside class=\"special\">\n" +
                    "<p><strong>Note:&nbsp;</strong>You can set the default region and zones that&nbsp;<code>gcloud</code>&nbsp;uses if you are always working within one region/zone and you don't want to append the&nbsp;<code>--zone</code>&nbsp;flag every time. You can do so by running these commands :</p>\n" +
                    "<p><code>$ gcloud config set compute/zone ...</code></p>\n" +
                    "<p><code>$ gcloud config set compute/region ...</code></p>\n" +
                    "</aside>\n" +
                    "<p>Finally, you can SSH into your instance using&nbsp;<code>gcloud</code>&nbsp;as well (make sure you adjust your zone if you've used something else when creating the instance, or omit the&nbsp;<code>--zone</code>&nbsp;flag if you've set the option globally):</p>\n" +
                    "<pre>$ gcloud compute ssh gcelab2 --zone us-central1-c\n" +
                    "Warning: Permanently added 'compute.745019997240233037' (ECDSA) to the list of known hosts.\n" +
                    "...\n" +
                    "username@gcelab2:~$</pre>\n" +
                    "<p>Disconnect from SSH by existing from the remote shell:</p>\n" +
                    "<pre>username@gcelab2:~$ exit</pre>\n" +
                    "</li>");
            sec5Node3.setLesson(nodeJsLesson3);
            nodeJsLesson3.getSections().add(sec5Node3);

            Section sec6Node3 = new Section();
            sec6Node3.setOrdinalNumber(6);
            sec6Node3.setDescription("Try out the sample code");
            sec6Node3.setContent("<ul class=\"faq\">\n" +
                    "<li>\n" +
                    "<p>The sample has the following layout:</p>\n" +
                    "<pre><code><span class=\"pln\">app</span><span class=\"pun\">.</span><span class=\"pln\">js                  </span><span class=\"com\">/* Express.js web application */</span><span class=\"pln\">\n" +
                    "config</span><span class=\"pun\">.</span><span class=\"pln\">js               </span><span class=\"com\">/* Application configuration variables */</span><span class=\"pln\">\n" +
                    "lib</span><span class=\"pun\">/</span><span class=\"pln\">\n" +
                    "  cloudVisionClient</span><span class=\"pun\">.</span><span class=\"pln\">js  </span><span class=\"com\">/* Cloud Vision client to consume the API */</span><span class=\"pln\">\n" +
                    "  oauth2</span><span class=\"pun\">.</span><span class=\"pln\">js             </span><span class=\"com\">/* OAuth2 client for login */</span><span class=\"pln\">\n" +
                    "  routes</span><span class=\"pun\">.</span><span class=\"pln\">js             </span><span class=\"com\">/* Application endpoints */</span><span class=\"pln\">\n" +
                    "  storageClient</span><span class=\"pun\">.</span><span class=\"pln\">js      </span><span class=\"com\">/* Cloud Storage client to consume the API */</span>\n" +
                    "<span class=\"kwd\">package</span><span class=\"pun\">.</span><span class=\"pln\">json            </span><span class=\"com\">/* npm package file including dependencies */</span><span class=\"pln\">\n" +
                    "views</span><span class=\"pun\">/</span>\n" +
                    "  <span class=\"kwd\">base</span><span class=\"pun\">.</span><span class=\"pln\">dust             </span><span class=\"com\">/* HTML template */</span>\n" +
                    "<span class=\"kwd\">public</span><span class=\"pun\">/</span><span class=\"pln\">\n" +
                    "  style</span><span class=\"pun\">.</span><span class=\"pln\">css             </span><span class=\"com\">/* CSS stylesheet */</span></code></pre>\n" +
                    "<p>To run the sample application in Cloud Shell let's perform the following steps:</p>\n" +
                    "<p>1. Install dependencies. Enter the following command:</p>\n" +
                    "<pre><code><span class=\"pln\">$ npm install\n" +
                    "</span><span class=\"pun\">...</span></code></pre>\n" +
                    "<p>2. Run app.js to start the node.js server:</p>\n" +
                    "<pre><code><span class=\"pln\">$ node app</span><span class=\"pun\">.</span><span class=\"pln\">js\n" +
                    "</span><span class=\"typ\">App</span><span class=\"pln\"> listening at http</span><span class=\"pun\">:</span><span class=\"com\">//:::8080</span></code></pre>\n" +
                    "<p>3. Click the \"Web preview\"<img src=\"https://codelabs.developers.google.com/codelabs/cloud-vision-nodejs/img/a0c920da29c2c9e7.png\" />icon that appears at the top left side of the cloud shell window and select \"Preview on port 8080\" to see the app in a web browser.</p>\n" +
                    "<aside class=\"special\">\n" +
                    "<p>Note: Usually you would test with&nbsp;<a href=\"http://localhost:8080/\" target=\"_blank\">http://localhost:8080</a>&nbsp;but the Google Cloud Shell environment requires requests to be proxied.</p>\n" +
                    "</aside>\n" +
                    "<aside class=\"special\">\n" +
                    "<p>Note: To kill the running server at anytime press Control+C.</p>\n" +
                    "</aside>\n" +
                    "<p>You will see a page that looks like this:</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-vision-nodejs/img/cdeda69fcb376c50.png\" /></p>\n" +
                    "<p>The application currently displays a not-yet-implemented user login. Let's fix that by setting up user authentication.</p>\n" +
                    "<h2><strong>Summary</strong></h2>\n" +
                    "<p>In this step, you set up and ran the codelab sample application.</p>\n" +
                    "<h2><strong>Next up</strong></h2>\n" +
                    "<p>Next, you will use OAuth 2.0 to add user login to the application and Google+ API to fetch user profile.</p>\n" +
                    "</li>\n" +
                    "</ul>");
            sec6Node3.setLesson(nodeJsLesson3);
            nodeJsLesson3.getSections().add(sec6Node3);

            Section sec7Node3 = new Section();
            sec7Node3.setOrdinalNumber(7);
            sec7Node3.setDescription("Upload images to storage");
            sec7Node3.setContent("<ul class=\"faq\">\n" +
                    "<li>\n" +
                    "<p>In this step, you will write the code to save image in Google Cloud Storage.</p>\n" +
                    "<h3><strong>Set up Google Cloud Storage</strong></h3>\n" +
                    "<p>The default bucket uses the same project ID for name:</p>\n" +
                    "<ol start=\"1\" type=\"1\">\n" +
                    "<li>From the left navigation, click&nbsp;<strong>App Engine &gt; Settings.</strong></li>\n" +
                    "<li>Under&nbsp;<strong>Default Cloud Storage Bucket</strong>, click&nbsp;<strong>Create.</strong></li>\n" +
                    "<li>Set public-read as the default object ACLs to existing and new objects in the bucket:</li>\n" +
                    "</ol>\n" +
                    "<pre><code><span class=\"pln\">$ gsutil defacl </span><span class=\"kwd\">set</span> <span class=\"kwd\">public</span><span class=\"pun\">-</span><span class=\"pln\">read gs</span><span class=\"pun\">:</span><span class=\"com\">//&lt;your-project-id&gt;.appspot.com</span>\n" +
                    "<span class=\"typ\">Setting</span> <span class=\"kwd\">default</span> <span class=\"kwd\">object</span><span class=\"pln\"> ACL on gs</span><span class=\"pun\">:</span><span class=\"com\">//&lt;your-project-id&gt;.appspot.com/...</span></code></pre>\n" +
                    "<aside class=\"special\">\n" +
                    "<p>Note: You can also create buckets using the command:&nbsp;<code>gsutil mb gs://&lt;your-bucket-name&gt;.appspot.com</code></p>\n" +
                    "</aside>\n" +
                    "<p>Next, you'll need to install the&nbsp;<a href=\"https://github.com/GoogleCloudPlatform/gcloud-node\" target=\"_blank\">gcloud</a>&nbsp;npm package, which you will use to interact with Cloud Storage, and the node.js middleware&nbsp;<a href=\"https://github.com/expressjs/multer\" target=\"_blank\">Multer</a>&nbsp;for handling&nbsp;<code>multipart/form-data</code>&nbsp;forms for uploading files.</p>\n" +
                    "<pre><code><span class=\"pln\">$ npm install gcloud multer </span><span class=\"pun\">--</span><span class=\"pln\">save</span></code></pre>\n" +
                    "<p>In the project directory, edit the&nbsp;<code>config.js</code>&nbsp;file.</p>\n" +
                    "<p>1. Open the file in an editor. For example this command will open&nbsp;<code>config.js</code>&nbsp;using Nano:</p>\n" +
                    "<pre><code><span class=\"pln\">$ nano </span><span class=\"pun\">-</span><span class=\"pln\">m config</span><span class=\"pun\">.</span><span class=\"pln\">js</span></code></pre>\n" +
                    "<p>2. Replace the placeholder value for&nbsp;<code>projectId</code>&nbsp;with the ID of the project that you created and also replace the placeholder value for&nbsp;<code>bucketName</code>&nbsp;with the name of the bucket you created:</p>\n" +
                    "<h3>config.js</h3>\n" +
                    "<pre><code><span class=\"kwd\">var</span><span class=\"pln\"> projectId </span><span class=\"pun\">=</span> <span class=\"str\">'your-project-id'</span><span class=\"pun\">;</span>\n" +
                    "<span class=\"kwd\">var</span><span class=\"pln\"> bucketName </span><span class=\"pun\">=</span> <span class=\"str\">'your-bucket-name'</span><span class=\"pun\">;</span></code></pre>\n" +
                    "<p>Now, let's register the cloud storage client.</p>\n" +
                    "<p>In the project directory, edit the&nbsp;<code>app.js</code>&nbsp;file.</p>\n" +
                    "<p>1. Open the file in an editor. For example this command will open&nbsp;<code>app.js</code>&nbsp;using Nano:</p>\n" +
                    "<pre><code><span class=\"pln\">nano </span><span class=\"pun\">-</span><span class=\"pln\">m app</span><span class=\"pun\">.</span><span class=\"pln\">js</span></code></pre>\n" +
                    "<p>2. Add the following code so the storage client creates a&nbsp;<a href=\"http://googlecloudplatform.github.io/gcloud-node/#/docs/v0.14.0/storage/bucket\" target=\"_blank\"><code>bucket</code></a>&nbsp;object that provides the API you will use to interact with your Google Cloud Storage bucket:</p>\n" +
                    "<h3>app.js</h3>\n" +
                    "<pre><code><span class=\"kwd\">var</span><span class=\"pln\"> storageClient </span><span class=\"pun\">=</span> <span class=\"kwd\">require</span><span class=\"pun\">(</span><span class=\"str\">'./lib/storageClient'</span><span class=\"pun\">)(</span><span class=\"pln\">\n" +
                    "  config</span><span class=\"pun\">.</span><span class=\"pln\">gcloud</span><span class=\"pun\">,</span><span class=\"pln\"> \n" +
                    "  config</span><span class=\"pun\">.</span><span class=\"pln\">gcloudStorageBucket\n" +
                    "</span><span class=\"pun\">);</span>\n" +
                    "\n" +
                    "<span class=\"com\">// Configure routes</span><span class=\"pln\">\n" +
                    "app</span><span class=\"pun\">.</span><span class=\"kwd\">use</span><span class=\"pun\">(</span><span class=\"str\">'/'</span><span class=\"pun\">,</span> <span class=\"kwd\">require</span><span class=\"pun\">(</span><span class=\"str\">'./lib/routes'</span><span class=\"pun\">)(</span><span class=\"pln\">\n" +
                    "  storageClient\n" +
                    "</span><span class=\"pun\">));</span></code></pre>\n" +
                    "<p>To upload the image to Cloud Storage and return a publicly accessible URL for displaying the image and the object URI to be later used for the Cloud Vision API, add a 'post' function to&nbsp;<code>lib/routes.js</code>:</p>\n" +
                    "<p>1. Open the file in an editor. For example this command will open&nbsp;<code>routes.js</code>&nbsp;using Nano:</p>\n" +
                    "<pre><code><span class=\"pln\">nano </span><span class=\"pun\">-</span><span class=\"pln\">m lib</span><span class=\"pun\">/</span><span class=\"pln\">routes</span><span class=\"pun\">.</span><span class=\"pln\">js</span></code></pre>\n" +
                    "<p>2. Add the following 'post' function to&nbsp;<code>lib/routes.js</code>:</p>\n" +
                    "<h3>routes.js</h3>\n" +
                    "<pre><code><span class=\"kwd\">var</span><span class=\"pln\"> routes </span><span class=\"pun\">=</span> <span class=\"kwd\">function</span><span class=\"pun\">(</span><span class=\"pln\">storageClient</span><span class=\"pun\">)</span> <span class=\"pun\">{</span>\n" +
                    "  <span class=\"com\">//...</span><span class=\"pln\">\n" +
                    "\n" +
                    "  router</span><span class=\"pun\">.</span><span class=\"pln\">post</span><span class=\"pun\">(</span><span class=\"str\">'/'</span><span class=\"pun\">,</span><span class=\"pln\"> \n" +
                    "    storageClient</span><span class=\"pun\">.</span><span class=\"pln\">multer</span><span class=\"pun\">.</span><span class=\"pln\">single</span><span class=\"pun\">(</span><span class=\"str\">'image'</span><span class=\"pun\">),</span><span class=\"pln\">\n" +
                    "    storageClient</span><span class=\"pun\">.</span><span class=\"pln\">uploadToStorage</span><span class=\"pun\">,</span>\n" +
                    "    <span class=\"kwd\">function</span><span class=\"pun\">(</span><span class=\"pln\">req</span><span class=\"pun\">,</span><span class=\"pln\"> res</span><span class=\"pun\">)</span> <span class=\"pun\">{</span>\n" +
                    "      <span class=\"kwd\">if</span> <span class=\"pun\">(</span><span class=\"pln\">req</span><span class=\"pun\">.</span><span class=\"pln\">file </span><span class=\"pun\">&amp;&amp;</span><span class=\"pln\"> req</span><span class=\"pun\">.</span><span class=\"pln\">file</span><span class=\"pun\">.</span><span class=\"pln\">cloudStoragePublicUrl</span><span class=\"pun\">)</span> <span class=\"pun\">{</span><span class=\"pln\">\n" +
                    "        res</span><span class=\"pun\">.</span><span class=\"pln\">render</span><span class=\"pun\">(</span><span class=\"str\">'base'</span><span class=\"pun\">,</span> <span class=\"pun\">{</span><span class=\"pln\">\n" +
                    "          imageUrl</span><span class=\"pun\">:</span><span class=\"pln\"> req</span><span class=\"pun\">.</span><span class=\"pln\">file</span><span class=\"pun\">.</span><span class=\"pln\">cloudStoragePublicUrl\n" +
                    "        </span><span class=\"pun\">});</span>\n" +
                    "      <span class=\"pun\">}</span>\n" +
                    "  <span class=\"pun\">});</span>\n" +
                    "\n" +
                    "  <span class=\"kwd\">return</span><span class=\"pln\"> router</span><span class=\"pun\">;</span>\n" +
                    "<span class=\"pun\">};</span></code></pre>\n" +
                    "<p>The publicly accesible URL for the image file will be&nbsp;<a href=\"https://storage.googleapis.com/\" target=\"_blank\"><code>https://storage.googleapis.com/</code></a><code>&lt;bucket-name&gt;/&lt;filename&gt;</code>&nbsp;and the Google Cloud Storage image URI will be&nbsp;<code>gs://bucket-name/object-name</code>.</p>\n" +
                    "<p>Finally, we need to change the&nbsp;<code>views/base.dust</code>&nbsp;file to display the form to upload images and to render the image using the Cloud Storage URL.</p>\n" +
                    "<p>1. Open the file in an editor. For example this command will open&nbsp;<code>base.dust</code>&nbsp;using Nano:</p>\n" +
                    "<pre><code><span class=\"pln\">nano </span><span class=\"pun\">-</span><span class=\"pln\">m views</span><span class=\"pun\">/</span><span class=\"kwd\">base</span><span class=\"pun\">.</span><span class=\"pln\">dust</span></code></pre>\n" +
                    "<p>2. Replace the current&nbsp;<code>{?profile}</code>&nbsp;block with the following lines:</p>\n" +
                    "<h3><a href=\"https://github.com/Zarmada/cloudvision-nodejs/blob/develop/step-2-upload-to-storage/views/base.dust\" target=\"_blank\">base.dust</a></h3>\n" +
                    "<pre><code><span class=\"com\">//...</span>\n" +
                    "<span class=\"str\">&lt;h3&gt;</span><span class=\"typ\">Google</span> <span class=\"typ\">Cloud</span> <span class=\"typ\">Vision</span><span class=\"pun\">&lt;/</span><span class=\"pln\">h3</span><span class=\"pun\">&gt;</span>\n" +
                    "\n" +
                    "<span class=\"pun\">{?</span><span class=\"pln\">profile</span><span class=\"pun\">}</span>\n" +
                    "  <span class=\"pun\">&lt;</span><span class=\"pln\">form action</span><span class=\"pun\">=</span><span class=\"str\">\"/\"</span><span class=\"pln\"> method</span><span class=\"pun\">=</span><span class=\"str\">\"post\"</span><span class=\"pln\"> enctype</span><span class=\"pun\">=</span><span class=\"str\">\"multipart/form-data\"</span><span class=\"pun\">&gt;</span>\n" +
                    "    <span class=\"pun\">&lt;</span><span class=\"pln\">div </span><span class=\"kwd\">class</span><span class=\"pun\">=</span><span class=\"str\">\"form-group\"</span><span class=\"pun\">&gt;</span>\n" +
                    "      <span class=\"pun\">&lt;</span><span class=\"pln\">label </span><span class=\"kwd\">for</span><span class=\"pun\">=</span><span class=\"str\">\"image\"</span><span class=\"pun\">&gt;</span><span class=\"typ\">Image</span><span class=\"pun\">&lt;/</span><span class=\"pln\">label</span><span class=\"pun\">&gt;</span>\n" +
                    "      <span class=\"pun\">&lt;</span><span class=\"pln\">input type</span><span class=\"pun\">=</span><span class=\"str\">\"file\"</span><span class=\"pln\"> name</span><span class=\"pun\">=</span><span class=\"str\">\"image\"</span><span class=\"pln\"> id</span><span class=\"pun\">=</span><span class=\"str\">\"image\"</span> <span class=\"kwd\">class</span><span class=\"pun\">=</span><span class=\"str\">\"form-control\"</span><span class=\"pun\">&gt;</span>\n" +
                    "    <span class=\"pun\">&lt;/</span><span class=\"pln\">div</span><span class=\"pun\">&gt;</span>\n" +
                    "\n" +
                    "    <span class=\"pun\">&lt;</span><span class=\"pln\">div </span><span class=\"kwd\">class</span><span class=\"pun\">=</span><span class=\"str\">\"form-group\"</span><span class=\"pun\">&gt;</span>\n" +
                    "      <span class=\"pun\">&lt;</span><span class=\"pln\">button type</span><span class=\"pun\">=</span><span class=\"str\">\"submit\"</span> <span class=\"kwd\">class</span><span class=\"pun\">=</span><span class=\"str\">\"btn btn-success\"</span><span class=\"pun\">&gt;</span><span class=\"typ\">Submit</span><span class=\"pun\">&lt;/</span><span class=\"pln\">button</span><span class=\"pun\">&gt;</span>\n" +
                    "    <span class=\"pun\">&lt;/</span><span class=\"pln\">div</span><span class=\"pun\">&gt;</span>  \n" +
                    "  <span class=\"pun\">&lt;/</span><span class=\"pln\">form</span><span class=\"pun\">&gt;</span>\n" +
                    "\n" +
                    "  <span class=\"pun\">{?</span><span class=\"pln\">imageUrl</span><span class=\"pun\">}</span>\n" +
                    "    <span class=\"pun\">&lt;</span><span class=\"pln\">div </span><span class=\"kwd\">class</span><span class=\"pun\">=</span><span class=\"str\">\"panel panel-default\"</span><span class=\"pun\">&gt;</span>\n" +
                    "      <span class=\"pun\">&lt;</span><span class=\"pln\">div </span><span class=\"kwd\">class</span><span class=\"pun\">=</span><span class=\"str\">\"panel-heading\"</span><span class=\"pun\">&gt;</span>\n" +
                    "        <span class=\"pun\">&lt;</span><span class=\"pln\">h3 </span><span class=\"kwd\">class</span><span class=\"pun\">=</span><span class=\"str\">\"panel-title\"</span><span class=\"pun\">&gt;</span><span class=\"typ\">Output</span><span class=\"pun\">&lt;/</span><span class=\"pln\">h3</span><span class=\"pun\">&gt;</span>\n" +
                    "      <span class=\"pun\">&lt;/</span><span class=\"pln\">div</span><span class=\"pun\">&gt;</span>\n" +
                    "      <span class=\"pun\">&lt;</span><span class=\"pln\">div id</span><span class=\"pun\">=</span><span class=\"str\">\"panel-body\"</span> <span class=\"kwd\">class</span><span class=\"pun\">=</span><span class=\"str\">\"panel-body\"</span><span class=\"pun\">&gt;</span>\n" +
                    "        <span class=\"pun\">&lt;</span><span class=\"pln\">img src</span><span class=\"pun\">=</span><span class=\"str\">\"{.imageUrl}\"</span><span class=\"pln\"> height</span><span class=\"pun\">=</span><span class=\"str\">\"600\"</span><span class=\"pln\"> width</span><span class=\"pun\">=</span><span class=\"str\">\"600\"</span><span class=\"pun\">&gt;</span>\n" +
                    "      <span class=\"pun\">&lt;/</span><span class=\"pln\">div</span><span class=\"pun\">&gt;</span>\n" +
                    "    <span class=\"pun\">&lt;/</span><span class=\"pln\">div</span><span class=\"pun\">&gt;</span>\n" +
                    "  <span class=\"pun\">{/</span><span class=\"pln\">imageUrl</span><span class=\"pun\">}</span>\n" +
                    "<span class=\"pun\">{:</span><span class=\"kwd\">else</span><span class=\"pun\">}</span>\n" +
                    "<span class=\"com\">//... </span></code></pre>\n" +
                    "<p>Restart the node application and try uploading an image.</p>\n" +
                    "<p>It should work!</p>\n" +
                    "<h2><strong>Summary</strong></h2>\n" +
                    "<p>In this step, you created a Google Cloud Storage bucket, uploaded images into it and rendered them using the public URL.</p>\n" +
                    "<h2><strong>Next up</strong></h2>\n" +
                    "<p>Next, you will set up the Google Cloud Vision API for your project.</p>\n" +
                    "</li>\n" +
                    "</ul>");
            sec7Node3.setLesson(nodeJsLesson3);
            nodeJsLesson3.getSections().add(sec7Node3);

            Section sec1Node4 = new Section();
            sec1Node4.setOrdinalNumber(1);
            sec1Node4.setDescription("Understanding Regions and Zones");
            sec1Node4.setContent("<ul class=\"faq\">\n" +
                    "<li>\n" +
                    "<p>Certain Compute Engine resources live in regions or zones. A region is a specific geographical location where you can run your resources. Each region has one or more zones. For example, the&nbsp;<code>us-central1</code>&nbsp;region denotes a region in the Central United States that has zones&nbsp;<code>us-central1-a</code>,&nbsp;<code>us-central1-b</code>,&nbsp;<code>us-central1-c</code>, and&nbsp;<code>us-central1-f</code>.</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/d5e7e31d2902346c.png\" /></p>\n" +
                    "<p>Virtual machine Instances and persistent disks live in a zone, and these are referred to as zonal resources. For example, to attach a persistent disk to a virtual machine instance, both resources must be in the same zone.</p>\n" +
                    "<aside class=\"special\">\n" +
                    "<p>Learn more about regions and zones and see a complete list in&nbsp;<a href=\"https://cloud.google.com/compute/docs/zones\" target=\"_blank\">Regions &amp; Zones documentation</a>.</p>\n" +
                    "</aside>\n" +
                    "</li>\n" +
                    "</ul>");
            sec1Node4.setLesson(nodeJsLesson4);
            nodeJsLesson4.getSections().add(sec1Node4);

            Section sec2Node4 = new Section();
            sec2Node4.setOrdinalNumber(2);
            sec2Node4.setDescription("Create a new instance");
            sec2Node4.setContent("<ul class=\"faq\">\n" +
                    "<li>\n" +
                    "<p>In this section, you'll learn how to create a new Google Compute Engine virtual machine instance from the Cloud Console.</p>\n" +
                    "<h2><strong>Login into Google Cloud Console</strong></h2>\n" +
                    "<p>Navigate to the the Google Cloud Console from another browser tab/window, to&nbsp;<a href=\"https://console.cloud.google.com/\" target=\"_blank\">https://console.cloud.google.com</a>. Use the login credential given to you by the lab proctor.</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/a416fda967d07163.png\" /></p>\n" +
                    "<h2><strong>Compute Engine</strong></h2>\n" +
                    "<p>In the Google Developer Console, click the&nbsp;<strong>Menu</strong>&nbsp;icon on the top left of the screen:</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/caf8a9546fcdb4d8.png\" /></p>\n" +
                    "<p>Then navigate to&nbsp;<strong>Compute Engine</strong>&nbsp;&gt;&nbsp;<strong>VM Instances</strong></p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/f03404a0ea354321.png\" /></p>\n" +
                    "<p>This may take a minute to initialize for the first time. Once initialized, you should see the following if the project has no virtual machine instances:</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/575f182a8247c86b.png\" /></p>\n" +
                    "<h2><strong>Create a new instance</strong></h2>\n" +
                    "<p>To create a new instance, click&nbsp;<strong>Create instance</strong></p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/d26361328d6e6f93.png\" /></p>\n" +
                    "<p>There are many parameters you can configure when creating a new instance. Let's use the following:</p>\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td colspan=\"1\" rowspan=\"1\">\n" +
                    "<p><strong>Name</strong></p>\n" +
                    "</td>\n" +
                    "<td colspan=\"1\" rowspan=\"1\">\n" +
                    "<p><code>gcelab</code></p>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td colspan=\"1\" rowspan=\"1\">\n" +
                    "<p><strong>Zone</strong></p>\n" +
                    "</td>\n" +
                    "<td colspan=\"1\" rowspan=\"1\">\n" +
                    "<p><code>us-central1-c</code></p>\n" +
                    "<p>Learn more about zones in&nbsp;<a href=\"https://cloud.google.com/compute/docs/zones\" target=\"_blank\">Regions &amp; Zones documentation</a>.</p>\n" +
                    "<p><strong>Note</strong>: remember the zone that you selected, you'll need it later.</p>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td colspan=\"1\" rowspan=\"1\">\n" +
                    "<p><strong>Machine Type</strong></p>\n" +
                    "</td>\n" +
                    "<td colspan=\"1\" rowspan=\"1\">\n" +
                    "<p><code>1 vCPU (n1-standard-1)</code></p>\n" +
                    "<p>This is a 1-CPU, 3.75GB RAM instance.</p>\n" +
                    "<p>There are a number of machine types, ranging from micro instance types to 32-core/208GB RAM instance types. Learn more about this and custom machine types in the&nbsp;<a href=\"https://cloud.google.com/compute/docs/machine-types\" target=\"_blank\">Machine Types documentation</a>.</p>\n" +
                    "<p><strong>Note</strong>: A new project has a default&nbsp;<a href=\"https://cloud.google.com/compute/docs/resource-quotas\" target=\"_blank\">resource quota</a>, which may limit the number of CPU cores. You can request more for your projects.</p>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td colspan=\"1\" rowspan=\"1\">\n" +
                    "<p><strong>Boot Disk</strong></p>\n" +
                    "</td>\n" +
                    "<td colspan=\"1\" rowspan=\"1\">\n" +
                    "<p><code>New 10 GB standard persistent disk</code></p>\n" +
                    "<p><code>Image: Debian GNU/Linux 8 (jessie)</code></p>\n" +
                    "<p>There are a number of images to choose from, including: Debian, Ubuntu, CoreOS as well as premium images such as Red Hat Enterprise Linux and Windows Server. See Operating System documentation for more detail.</p>\n" +
                    "<p><strong>Note:</strong>&nbsp;You may optionally choose&nbsp;<code>SSD Persistent Disk</code>&nbsp;as well.</p>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td colspan=\"1\" rowspan=\"1\">\n" +
                    "<p><strong>Firewall</strong></p>\n" +
                    "</td>\n" +
                    "<td colspan=\"1\" rowspan=\"1\">\n" +
                    "<p>Check&nbsp;<code>Allow HTTP traffic</code></p>\n" +
                    "<p>Check this option so that we can access a webserver that we will install later.</p>\n" +
                    "<p><strong>Note:&nbsp;</strong>This will automatically create firewall rule to allow HTTP traffic on port 80.</p>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<p>Your screen should look like this:</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/46c5bcec70eabe40.png\" /></p>\n" +
                    "<p>Click on&nbsp;<strong>Create</strong>&nbsp;to create the new virtual machine instance!</p>\n" +
                    "<aside class=\"special\">\n" +
                    "<p><strong>Note:&nbsp;</strong>The instance creation process is asynchronous. You can check on the status of the task using the top right hand-side&nbsp;<strong>Notifications</strong>&nbsp;icon. Wait for it to finish - it shouldn't take more than a minute.</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/ea1a7f9899153d16.png\" /></p>\n" +
                    "</aside>\n" +
                    "<aside class=\"warning\">\n" +
                    "<p><strong>Hint:&nbsp;</strong>If you receive an error when creating a VM, click into&nbsp;<strong>Details</strong>. Most likely, you may need to try with a different zone.</p>\n" +
                    "</aside>\n" +
                    "<p>Once finished, you should see the new virtual machine in the&nbsp;<strong>VM Instances</strong>&nbsp;page. Note down the&nbsp;<code>External IP</code>&nbsp;of the machine on the VM instances page - you will need this later</p>\n" +
                    "<p>To SSH into the virtual machine, click on&nbsp;<strong>SSH</strong>&nbsp;on the right hand side.</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/d64685c5118c91c7.png\" /></p>\n" +
                    "<aside class=\"special\">\n" +
                    "<p><strong>Note:&nbsp;</strong>This launches a secure SSH client directly from your browser. To learn about other ways to ssh into the VM, see the&nbsp;<a href=\"https://cloud.google.com/compute/docs/instances/connecting-to-instance\" target=\"_blank\">documentation</a>.</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/8cb62517d9164047.png\" /></p>\n" +
                    "</aside>\n" +
                    "</li>\n" +
                    "</ul>");
            sec2Node4.setLesson(nodeJsLesson4);
            nodeJsLesson4.getSections().add(sec2Node4);

            Section sec3Node4 = new Section();
            sec3Node4.setOrdinalNumber(3);
            sec3Node4.setDescription("Install Node.js");
            sec3Node4.setContent("<ul class=\"faq\">\n" +
                    "<li>\n" +
                    "<p>Once ssh'ed, install Node.js and Git</p>\n" +
                    "<pre>curl -sL https://deb.nodesource.com/setup_6.x | sudo -E bash -</pre>\n" +
                    "<pre>sudo apt-get install -y nodejs git</pre>\n" +
                    "<p>Now let's run an sample application. First, clone the source code:</p>\n" +
                    "<pre><code><span class=\"pln\">git clone https</span><span class=\"pun\">:</span><span class=\"com\">//github.com/GoogleCloudPlatform/nodejs-docs-samples.git</span></code></pre>\n" +
                    "<pre><code><span class=\"pln\">cd nodejs</span><span class=\"pun\">-</span><span class=\"pln\">docs</span><span class=\"pun\">-</span><span class=\"pln\">samples</span><span class=\"pun\">/</span><span class=\"pln\">appengine</span><span class=\"pun\">/</span><span class=\"pln\">hello</span><span class=\"pun\">-</span><span class=\"pln\">world</span><span class=\"pun\">/</span></code></pre>\n" +
                    "<p>Now, install the dependencies with&nbsp;<code>npm</code>:</p>\n" +
                    "<pre><code><span class=\"pln\">npm install</span></code></pre>\n" +
                    "<p>Finally, start the Node application listening on port 80</p>\n" +
                    "<pre><code><span class=\"pln\">sudo PORT</span><span class=\"pun\">=</span><span class=\"lit\">80</span><span class=\"pln\"> npm start</span></code></pre>\n" +
                    "<p>Awesome! Let's see the web page!</p>\n" +
                    "<p>Use the&nbsp;<code>External IP</code>&nbsp;of the virtual machine instance that you noted down before, and in a new browser window/tab, browse to&nbsp;<a href=\"http://external_ip/\" target=\"_blank\"><code>http://EXTERNAL_IP/</code></a>, you should see the default page.</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/7be03829524fbef2.png\" /></p>\n" +
                    "</li>\n" +
                    "</ul>");
            sec3Node4.setLesson(nodeJsLesson4);
            nodeJsLesson4.getSections().add(sec3Node4);

            Section sec4Node4 = new Section();
            sec4Node4.setOrdinalNumber(4);
            sec4Node4.setDescription("Create a new instance, with gcloud");
            sec4Node4.setContent("<ul class=\"faq\">\n" +
                    "<li>\n" +
                    "<p>Rather than using the Google Cloud Console to create a virtual machine instance, you can also use the command line tool called&nbsp;<code>gcloud</code>.</p>\n" +
                    "<p>We'll use&nbsp;<a href=\"https://cloud.google.com/developer-shell/#how_do_i_get_started\" target=\"_blank\">Google Cloud Shell</a>,<a href=\"https://cloud.google.com/developer-shell/#how_do_i_get_started\" target=\"_blank\">&nbsp;a command line environment running in the Cloud</a>. This Debian-based virtual machine is loaded with all the development tools you'll need (<code>gcloud</code>,&nbsp;<code>git</code>&nbsp;and others) and offers a persistent 5GB home directory.</p>\n" +
                    "<aside class=\"special\">\n" +
                    "<p>You don't need to manually install&nbsp;<code>gcloud</code>&nbsp;for this lab since it's preinstalled in Cloud Shell. But if you want to try this on your own machine in the future, read the&nbsp;<a href=\"https://cloud.google.com/sdk/gcloud/\" target=\"_blank\">gcloud command line tool guide</a>.</p>\n" +
                    "</aside>\n" +
                    "<p>Open the Google Cloud Shell by clicking on the&nbsp;<img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/3b409efdcc18f697.png\" />icon on the top right of the screen:</p>\n" +
                    "<p><img src=\"https://codelabs.developers.google.com/codelabs/cloud-create-a-nodejs-vm/img/446be36b8e6592.png\" /></p>\n" +
                    "<p>Once opened, you can create a new virtual machine instance from the command line by using&nbsp;<code>gcloud</code>&nbsp;(feel free to use another zone closer to you) :</p>\n" +
                    "<pre>$ gcloud compute instances create gcelab2 --zone us-central1-c\n" +
                    "Created [...gcelab2].\n" +
                    "NAME     ZONE           MACHINE_TYPE  PREEMPTIBLE INTERNAL_IP EXTERNAL_IP    STATUS\n" +
                    "gcelab2  us-central1-c  n1-standard-1             10.240.X.X  X.X.X.X        RUNNING</pre>\n" +
                    "<p>The instance was created with some default values:</p>\n" +
                    "<ul>\n" +
                    "<li>The latest&nbsp;<a href=\"https://cloud.google.com/compute/docs/operating-systems/linux-os#debian\" target=\"_blank\">Debian 8 (Jessie)</a>&nbsp;image.</li>\n" +
                    "<li>The&nbsp;<code>n1-standard-1</code>&nbsp;<a href=\"https://cloud.google.com/compute/docs/machine-types\" target=\"_blank\">machine type</a>. You can select another machine type such as&nbsp;<code>n1-highmem-4</code>&nbsp;or&nbsp;<code>n1-highcpu-6</code>. If none of the&nbsp;<a href=\"https://cloud.google.com/compute/docs/machine-types#predefined_machine_types\" target=\"_blank\">predefined machine types</a>&nbsp;match your needs, use a&nbsp;<a href=\"https://cloud.google.com/compute/docs/instances/creating-instance-with-custom-machine-type\" target=\"_blank\">custom machine type</a>.</li>\n" +
                    "<li>A root persistent disk with the same name as the instance; the disk is automatically attached to the instance.</li>\n" +
                    "</ul>\n" +
                    "<p>Run&nbsp;<code>gcloud compute instances create --help</code>&nbsp;to see all the defaults.</p>\n" +
                    "<aside class=\"special\">\n" +
                    "<p><strong>Note:&nbsp;</strong>You can set the default region and zones that&nbsp;<code>gcloud</code>&nbsp;uses if you are always working within one region/zone and you don't want to append the&nbsp;<code>--zone</code>&nbsp;flag every time. You can do so by running these commands :</p>\n" +
                    "<p><code>$ gcloud config set compute/zone ...</code></p>\n" +
                    "<p><code>$ gcloud config set compute/region ...</code></p>\n" +
                    "</aside>\n" +
                    "<p>Finally, you can SSH into your instance using&nbsp;<code>gcloud</code>&nbsp;as well (make sure you adjust your zone if you've used something else when creating the instance, or omit the&nbsp;<code>--zone</code>&nbsp;flag if you've set the option globally):</p>\n" +
                    "<pre>$ gcloud compute ssh gcelab2 --zone us-central1-c\n" +
                    "Warning: Permanently added 'compute.745019997240233037' (ECDSA) to the list of known hosts.\n" +
                    "...\n" +
                    "username@gcelab2:~$</pre>\n" +
                    "<p>Disconnect from SSH by existing from the remote shell:</p>\n" +
                    "<pre>username@gcelab2:~$ exit</pre>\n" +
                    "</li>\n" +
                    "</ul>");
            sec4Node4.setLesson(nodeJsLesson4);
            nodeJsLesson4.getSections().add(sec4Node4);

                        Section sec1React1 = new Section();
            sec1React1.setOrdinalNumber(1);
            sec1React1.setDescription("Introducing JSX");
            sec1React1.setContent("<p>Consider this variable declaration:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, world!</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>This funny tag syntax is neither a string nor HTML.</p>\n" +
                    "<p>It is called JSX, and it is a syntax extension to JavaScript. We recommend using it with React to describe what the UI should look like. JSX may remind you of a template language, but it comes with the full power of JavaScript.</p>\n" +
                    "<p>JSX produces React &ldquo;elements&rdquo;. We will explore rendering them to the DOM in the&nbsp;<a href=\"https://reactjs.org/docs/rendering-elements.html\">next section</a>. Below, you can find the basics of JSX necessary to get you started.</p>\n" +
                    "<h3 id=\"why-jsx\">Why JSX?</h3>\n" +
                    "<p>React embraces the fact that rendering logic is inherently coupled with other UI logic: how events are handled, how the state changes over time, and how the data is prepared for display.</p>\n" +
                    "<p>Instead of artificially separating&nbsp;<em>technologies</em>&nbsp;by putting markup and logic in separate files, React&nbsp;<a href=\"https://en.wikipedia.org/wiki/Separation_of_concerns\">separates&nbsp;<em>concerns</em></a>&nbsp;with loosely coupled units called &ldquo;components&rdquo; that contain both. We will come back to components in a&nbsp;<a href=\"https://reactjs.org/docs/components-and-props.html\">further section</a>, but if you&rsquo;re not yet comfortable putting markup in JS,&nbsp;<a href=\"https://www.youtube.com/watch?v=x7cQ3mrcKaY\">this talk</a>&nbsp;might convince you otherwise.</p>\n" +
                    "<p>React&nbsp;<a href=\"https://reactjs.org/docs/react-without-jsx.html\">doesn&rsquo;t require</a>&nbsp;using JSX, but most people find it helpful as a visual aid when working with UI inside the JavaScript code. It also allows React to show more useful error and warning messages.</p>\n" +
                    "<p>With that out of the way, let&rsquo;s get started!</p>\n" +
                    "<h3 id=\"embedding-expressions-in-jsx\">Embedding Expressions in JSX</h3>\n" +
                    "<p>In the example below, we declare a variable called&nbsp;<code class=\"gatsby-code-text\">name</code>&nbsp;and then use it inside JSX by wrapping it in curly braces:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"gatsby-highlight-code-line\"><span class=\"token keyword\">const</span> name <span class=\"token operator\">=</span> <span class=\"token string\">'Josh Perez'</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\"><span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, </span><span class=\"token punctuation\">{</span>name<span class=\"token punctuation\">}</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "</span>\n" +
                    "ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">render</span><span class=\"token punctuation\">(</span>\n" +
                    "  element<span class=\"token punctuation\">,</span>\n" +
                    "  document<span class=\"token punctuation\">.</span><span class=\"token function\">getElementById</span><span class=\"token punctuation\">(</span><span class=\"token string\">'root'</span><span class=\"token punctuation\">)</span>\n" +
                    "<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>You can put any valid&nbsp;<a href=\"https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Expressions_and_Operators#Expressions\">JavaScript expression</a>&nbsp;inside the curly braces in JSX. For example,&nbsp;<code class=\"gatsby-code-text\">2 + 2</code>,&nbsp;<code class=\"gatsby-code-text\">user.firstName</code>, or&nbsp;<code class=\"gatsby-code-text\">formatName(user)</code>&nbsp;are all valid JavaScript expressions.</p>\n" +
                    "<p>In the example below, we embed the result of calling a JavaScript function,&nbsp;<code class=\"gatsby-code-text\">formatName(user)</code>, into an&nbsp;<code class=\"gatsby-code-text\">&lt;h1&gt;</code>&nbsp;element.</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">formatName</span><span class=\"token punctuation\">(</span>user<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> user<span class=\"token punctuation\">.</span>firstName <span class=\"token operator\">+</span> <span class=\"token string\">' '</span> <span class=\"token operator\">+</span> user<span class=\"token punctuation\">.</span>lastName<span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"token keyword\">const</span> user <span class=\"token operator\">=</span> <span class=\"token punctuation\">{</span>\n" +
                    "  firstName<span class=\"token punctuation\">:</span> <span class=\"token string\">'Harper'</span><span class=\"token punctuation\">,</span>\n" +
                    "  lastName<span class=\"token punctuation\">:</span> <span class=\"token string\">'Perez'</span>\n" +
                    "<span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "\n" +
                    "<span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token punctuation\">(</span>\n" +
                    "  <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"gatsby-highlight-code-line\"><span class=\"token plain-text\">    Hello, </span><span class=\"token punctuation\">{</span><span class=\"token function\">formatName</span><span class=\"token punctuation\">(</span>user<span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token plain-text\">!</span>\n" +
                    "</span>  <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "\n" +
                    "ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">render</span><span class=\"token punctuation\">(</span>\n" +
                    "  element<span class=\"token punctuation\">,</span>\n" +
                    "  document<span class=\"token punctuation\">.</span><span class=\"token function\">getElementById</span><span class=\"token punctuation\">(</span><span class=\"token string\">'root'</span><span class=\"token punctuation\">)</span>\n" +
                    "<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p><a href=\"https://reactjs.org/redirect-to-codepen/introducing-jsx\" target=\"_blank\" rel=\"noreferrer\"><strong>Try it on CodePen</strong></a></p>\n" +
                    "<p>We split JSX over multiple lines for readability. While it isn&rsquo;t required, when doing this, we also recommend wrapping it in parentheses to avoid the pitfalls of&nbsp;<a href=\"http://stackoverflow.com/q/2846283\">automatic semicolon insertion</a>.</p>\n" +
                    "<h3 id=\"jsx-is-an-expression-too\">JSX is an Expression Too</h3>\n" +
                    "<p>After compilation, JSX expressions become regular JavaScript function calls and evaluate to JavaScript objects.</p>\n" +
                    "<p>This means that you can use JSX inside of&nbsp;<code class=\"gatsby-code-text\">if</code>&nbsp;statements and&nbsp;<code class=\"gatsby-code-text\">for</code>&nbsp;loops, assign it to variables, accept it as arguments, and return it from functions:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">getGreeting</span><span class=\"token punctuation\">(</span>user<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">if</span> <span class=\"token punctuation\">(</span>user<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, </span><span class=\"token punctuation\">{</span><span class=\"token function\">formatName</span><span class=\"token punctuation\">(</span>user<span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token plain-text\">!</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "</span>  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, Stranger.</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<h3 id=\"specifying-attributes-with-jsx\">Specifying Attributes with JSX</h3>\n" +
                    "<p>You may use quotes to specify string literals as attributes:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">tabIndex</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>0<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>You may also use curly braces to embed a JavaScript expression in an attribute:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>img <span class=\"token attr-name\">src</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>user<span class=\"token punctuation\">.</span>avatarUrl<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>img<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Don&rsquo;t put quotes around curly braces when embedding a JavaScript expression in an attribute. You should either use quotes (for string values) or curly braces (for expressions), but not both in the same attribute.</p>\n" +
                    "<blockquote>\n" +
                    "<p><strong>Warning:</strong></p>\n" +
                    "<p>Since JSX is closer to JavaScript than to HTML, React DOM uses&nbsp;<code class=\"gatsby-code-text\">camelCase</code>&nbsp;property naming convention instead of HTML attribute names.</p>\n" +
                    "<p>For example,&nbsp;<code class=\"gatsby-code-text\">class</code>&nbsp;becomes&nbsp;<a href=\"https://developer.mozilla.org/en-US/docs/Web/API/Element/className\"><code class=\"gatsby-code-text\">className</code></a>&nbsp;in JSX, and&nbsp;<code class=\"gatsby-code-text\">tabindex</code>&nbsp;becomes&nbsp;<a href=\"https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/tabIndex\"><code class=\"gatsby-code-text\">tabIndex</code></a>.</p>\n" +
                    "</blockquote>\n" +
                    "<h3 id=\"specifying-children-with-jsx\">Specifying Children with JSX</h3>\n" +
                    "<p>If a tag is empty, you may close it immediately with&nbsp;<code class=\"gatsby-code-text\">/&gt;</code>, like XML:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>img <span class=\"token attr-name\">src</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>user<span class=\"token punctuation\">.</span>avatarUrl<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>JSX tags may contain children:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token punctuation\">(</span>\n" +
                    "  <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello!</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h2<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Good to see you here.</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h2<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<h3 id=\"jsx-prevents-injection-attacks\">JSX Prevents Injection Attacks</h3>\n" +
                    "<p>It is safe to embed user input in JSX:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">const</span> title <span class=\"token operator\">=</span> response<span class=\"token punctuation\">.</span>potentiallyMaliciousInput<span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token comment\">// This is safe:</span>\n" +
                    "<span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">{</span>title<span class=\"token punctuation\">}</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>By default, React DOM&nbsp;<a href=\"http://stackoverflow.com/questions/7381974/which-characters-need-to-be-escaped-on-html\">escapes</a>&nbsp;any values embedded in JSX before rendering them. Thus it ensures that you can never inject anything that&rsquo;s not explicitly written in your application. Everything is converted to a string before being rendered. This helps prevent&nbsp;<a href=\"https://en.wikipedia.org/wiki/Cross-site_scripting\">XSS (cross-site-scripting)</a>&nbsp;attacks.</p>\n" +
                    "<h3 id=\"jsx-represents-objects\">JSX Represents Objects</h3>\n" +
                    "<p>Babel compiles JSX down to&nbsp;<code class=\"gatsby-code-text\">React.createElement()</code>&nbsp;calls.</p>\n" +
                    "<p>These two examples are identical:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token punctuation\">(</span>\n" +
                    "  <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1 <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>greeting<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">\n" +
                    "    Hello, world!\n" +
                    "  </span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> React<span class=\"token punctuation\">.</span><span class=\"token function\">createElement</span><span class=\"token punctuation\">(</span>\n" +
                    "  <span class=\"token string\">'h1'</span><span class=\"token punctuation\">,</span>\n" +
                    "  <span class=\"token punctuation\">{</span>className<span class=\"token punctuation\">:</span> <span class=\"token string\">'greeting'</span><span class=\"token punctuation\">}</span><span class=\"token punctuation\">,</span>\n" +
                    "  <span class=\"token string\">'Hello, world!'</span>\n" +
                    "<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p><code class=\"gatsby-code-text\">React.createElement()</code>&nbsp;performs a few checks to help you write bug-free code but essentially it creates an object like this:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token comment\">// Note: this structure is simplified</span>\n" +
                    "<span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token punctuation\">{</span>\n" +
                    "  type<span class=\"token punctuation\">:</span> <span class=\"token string\">'h1'</span><span class=\"token punctuation\">,</span>\n" +
                    "  props<span class=\"token punctuation\">:</span> <span class=\"token punctuation\">{</span>\n" +
                    "    className<span class=\"token punctuation\">:</span> <span class=\"token string\">'greeting'</span><span class=\"token punctuation\">,</span>\n" +
                    "    children<span class=\"token punctuation\">:</span> <span class=\"token string\">'Hello, world!'</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>These objects are called &ldquo;React elements&rdquo;. You can think of them as descriptions of what you want to see on the screen. React reads these objects and uses them to construct the DOM and keep it up to date.</p>\n" +
                    "<p>We will explore rendering React elements to the DOM in the next section.</p>\n" +
                    "<blockquote>\n" +
                    "<p><strong>Tip:</strong></p>\n" +
                    "<p>We recommend using the&nbsp;<a href=\"http://babeljs.io/docs/editors\">&ldquo;Babel&rdquo; language definition</a>&nbsp;for your editor of choice so that both ES6 and JSX code is properly highlighted. This website uses the&nbsp;<a href=\"https://labs.voronianski.com/oceanic-next-color-scheme/\">Oceanic Next</a>&nbsp;color scheme which is compatible with it.</p>\n" +
                    "</blockquote>");
            sec1React1.setLesson(reactJsLesson1);
            reactJsLesson1.getSections().add(sec1React1);

            Section sec2React1 = new Section();
            sec2React1.setOrdinalNumber(2);
            sec2React1.setDescription("Rendering Elements");
            sec2React1.setContent("<div class=\"css-7u1i3w\">\n" +
                    "<p>Elements are the smallest building blocks of React apps.</p>\n" +
                    "<p>An element describes what you want to see on the screen:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, world</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Unlike browser DOM elements, React elements are plain objects, and are cheap to create. React DOM takes care of updating the DOM to match the React elements.</p>\n" +
                    "<blockquote>\n" +
                    "<p><strong>Note:</strong></p>\n" +
                    "<p>One might confuse elements with a more widely known concept of &ldquo;components&rdquo;. We will introduce components in the&nbsp;<a href=\"https://reactjs.org/docs/components-and-props.html\">next section</a>. Elements are what components are &ldquo;made of&rdquo;, and we encourage you to read this section before jumping ahead.</p>\n" +
                    "</blockquote>\n" +
                    "<h2 id=\"rendering-an-element-into-the-dom\">Rendering an Element into the DOM</h2>\n" +
                    "<p>Let&rsquo;s say there is a&nbsp;<code class=\"gatsby-code-text\">&lt;div&gt;</code>&nbsp;somewhere in your HTML file:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"html\">\n" +
                    "<pre class=\"gatsby-code-html\"><code class=\"gatsby-code-html\"><span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">id</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>root<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span></code></pre>\n" +
                    "</div>\n" +
                    "<p>We call this a &ldquo;root&rdquo; DOM node because everything inside it will be managed by React DOM.</p>\n" +
                    "<p>Applications built with just React usually have a single root DOM node. If you are integrating React into an existing app, you may have as many isolated root DOM nodes as you like.</p>\n" +
                    "<p>To render a React element into a root DOM node, pass both to&nbsp;<code class=\"gatsby-code-text\">ReactDOM.render()</code>:</p>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<div class=\"gatsby-highlight\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code><span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, world</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">render</span><span class=\"token punctuation\">(</span>element<span class=\"token punctuation\">,</span> document<span class=\"token punctuation\">.</span><span class=\"token function\">getElementById</span><span class=\"token punctuation\">(</span><span class=\"token string\">'root'</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<p><a href=\"https://reactjs.org/redirect-to-codepen/rendering-elements/render-an-element\" target=\"_blank\" rel=\"noreferrer\"><strong>Try it on CodePen</strong></a></p>\n" +
                    "<p>It displays &ldquo;Hello, world&rdquo; on the page.</p>\n" +
                    "<h2 id=\"updating-the-rendered-element\">Updating the Rendered Element</h2>\n" +
                    "<p>React elements are&nbsp;<a href=\"https://en.wikipedia.org/wiki/Immutable_object\">immutable</a>. Once you create an element, you can&rsquo;t change its children or attributes. An element is like a single frame in a movie: it represents the UI at a certain point in time.</p>\n" +
                    "<p>With our knowledge so far, the only way to update the UI is to create a new element, and pass it to&nbsp;<code class=\"gatsby-code-text\">ReactDOM.render()</code>.</p>\n" +
                    "<p>Consider this ticking clock example:</p>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<div class=\"gatsby-highlight\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code><span class=\"token keyword\">function</span> <span class=\"token function\">tick</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, world!</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h2<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">It is </span><span class=\"token punctuation\">{</span><span class=\"token keyword\">new</span> <span class=\"token class-name\">Date</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">.</span><span class=\"token function\">toLocaleTimeString</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token plain-text\">.</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h2<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">render</span><span class=\"token punctuation\">(</span>element<span class=\"token punctuation\">,</span> document<span class=\"token punctuation\">.</span><span class=\"token function\">getElementById</span><span class=\"token punctuation\">(</span><span class=\"token string\">'root'</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"token function\">setInterval</span><span class=\"token punctuation\">(</span>tick<span class=\"token punctuation\">,</span> <span class=\"token number\">1000</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<p><a href=\"https://reactjs.org/redirect-to-codepen/rendering-elements/update-rendered-element\" target=\"_blank\" rel=\"noreferrer\"><strong>Try it on CodePen</strong></a></p>\n" +
                    "<p>It calls&nbsp;<code class=\"gatsby-code-text\">ReactDOM.render()</code>&nbsp;every second from a&nbsp;<a href=\"https://developer.mozilla.org/en-US/docs/Web/API/WindowTimers/setInterval\"><code class=\"gatsby-code-text\">setInterval()</code></a>&nbsp;callback.</p>\n" +
                    "<blockquote>\n" +
                    "<p><strong>Note:</strong></p>\n" +
                    "<p>In practice, most React apps only call&nbsp;<code class=\"gatsby-code-text\">ReactDOM.render()</code>&nbsp;once. In the next sections we will learn how such code gets encapsulated into&nbsp;<a href=\"https://reactjs.org/docs/state-and-lifecycle.html\">stateful components</a>.</p>\n" +
                    "<p>We recommend that you don&rsquo;t skip topics because they build on each other.</p>\n" +
                    "</blockquote>\n" +
                    "<h2 id=\"react-only-updates-whats-necessary\">React Only Updates What&rsquo;s Necessary</h2>\n" +
                    "<p>React DOM compares the element and its children to the previous one, and only applies the DOM updates necessary to bring the DOM to the desired state.</p>\n" +
                    "<p>You can verify by inspecting the&nbsp;<a href=\"https://reactjs.org/redirect-to-codepen/rendering-elements/update-rendered-element\" target=\"_blank\" rel=\"noreferrer\">last example</a>&nbsp;with the browser tools:</p>\n" +
                    "<p><img src=\"https://reactjs.org/granular-dom-updates-c158617ed7cc0eac8f58330e49e48224.gif\" alt=\"DOM inspector showing granular updates\" /></p>\n" +
                    "<p>Even though we create an element describing the whole UI tree on every tick, only the text node whose contents has changed gets updated by React DOM.</p>\n" +
                    "<p>In our experience, thinking about how the UI should look at any given moment rather than how to change it over time eliminates a whole class of bugs.</p>\n" +
                    "</div>");
            sec2React1.setLesson(reactJsLesson1);
            reactJsLesson1.getSections().add(sec2React1);

            Section sec3React1 = new Section();
            sec3React1.setOrdinalNumber(3);
            sec3React1.setDescription("Components and Props");
            sec3React1.setContent("<div class=\"css-7u1i3w\">\n" +
                    "<p>Components let you split the UI into independent, reusable pieces, and think about each piece in isolation. This page provides an introduction to the idea of components. You can find a&nbsp;<a href=\"https://reactjs.org/docs/react-component.html\">detailed component API reference here</a>.</p>\n" +
                    "<p>Conceptually, components are like JavaScript functions. They accept arbitrary inputs (called &ldquo;props&rdquo;) and return React elements describing what should appear on the screen.</p>\n" +
                    "<h2 id=\"function-and-class-components\">Function and Class Components</h2>\n" +
                    "<p>The simplest way to define a component is to write a JavaScript function:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">Welcome</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, </span><span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>name<span class=\"token punctuation\">}</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>This function is a valid React component because it accepts a single &ldquo;props&rdquo; (which stands for properties) object argument with data and returns a React element. We call such components &ldquo;function components&rdquo; because they are literally JavaScript functions.</p>\n" +
                    "<p>You can also use an&nbsp;<a href=\"https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Classes\">ES6 class</a>&nbsp;to define a component:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">class</span> <span class=\"token class-name\">Welcome</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, </span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>props<span class=\"token punctuation\">.</span>name<span class=\"token punctuation\">}</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>The above two components are equivalent from React&rsquo;s point of view.</p>\n" +
                    "<p>Classes have some additional features that we will discuss in the&nbsp;<a href=\"https://reactjs.org/docs/state-and-lifecycle.html\">next sections</a>. Until then, we will use function components for their conciseness.</p>\n" +
                    "<h2 id=\"rendering-a-component\">Rendering a Component</h2>\n" +
                    "<p>Previously, we only encountered React elements that represent DOM tags:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>However, elements can also represent user-defined components:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Welcome <span class=\"token attr-name\">name</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Sara<span class=\"token punctuation\">\"</span></span> <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>When React sees an element representing a user-defined component, it passes JSX attributes to this component as a single object. We call this object &ldquo;props&rdquo;.</p>\n" +
                    "<p>For example, this code renders &ldquo;Hello, Sara&rdquo; on the page:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"gatsby-highlight-code-line\"><span class=\"token keyword\">function</span> <span class=\"token function\">Welcome</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span>  <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, </span><span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>name<span class=\"token punctuation\">}</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"gatsby-highlight-code-line\"><span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Welcome <span class=\"token attr-name\">name</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Sara<span class=\"token punctuation\">\"</span></span> <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "</span>ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">render</span><span class=\"token punctuation\">(</span>\n" +
                    "  element<span class=\"token punctuation\">,</span>\n" +
                    "  document<span class=\"token punctuation\">.</span><span class=\"token function\">getElementById</span><span class=\"token punctuation\">(</span><span class=\"token string\">'root'</span><span class=\"token punctuation\">)</span>\n" +
                    "<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p><a href=\"https://reactjs.org/redirect-to-codepen/components-and-props/rendering-a-component\" target=\"_blank\" rel=\"noreferrer\"><strong>Try it on CodePen</strong></a></p>\n" +
                    "<p>Let&rsquo;s recap what happens in this example:</p>\n" +
                    "<ol>\n" +
                    "<li>We call&nbsp;<code class=\"gatsby-code-text\">ReactDOM.render()</code>&nbsp;with the&nbsp;<code class=\"gatsby-code-text\">&lt;Welcome name=\"Sara\" /&gt;</code>&nbsp;element.</li>\n" +
                    "<li>React calls the&nbsp;<code class=\"gatsby-code-text\">Welcome</code>&nbsp;component with&nbsp;<code class=\"gatsby-code-text\">{name: 'Sara'}</code>&nbsp;as the props.</li>\n" +
                    "<li>Our&nbsp;<code class=\"gatsby-code-text\">Welcome</code>&nbsp;component returns a&nbsp;<code class=\"gatsby-code-text\">&lt;h1&gt;Hello, Sara&lt;/h1&gt;</code>&nbsp;element as the result.</li>\n" +
                    "<li>React DOM efficiently updates the DOM to match&nbsp;<code class=\"gatsby-code-text\">&lt;h1&gt;Hello, Sara&lt;/h1&gt;</code>.</li>\n" +
                    "</ol>\n" +
                    "<blockquote>\n" +
                    "<p><strong>Note:</strong>&nbsp;Always start component names with a capital letter.</p>\n" +
                    "<p>React treats components starting with lowercase letters as DOM tags. For example,&nbsp;<code class=\"gatsby-code-text\">&lt;div /&gt;</code>represents an HTML div tag, but&nbsp;<code class=\"gatsby-code-text\">&lt;Welcome /&gt;</code>&nbsp;represents a component and requires&nbsp;<code class=\"gatsby-code-text\">Welcome</code>to be in scope.</p>\n" +
                    "<p>You can read more about the reasoning behind this convention&nbsp;<a href=\"https://reactjs.org/docs/jsx-in-depth.html#user-defined-components-must-be-capitalized\">here.</a></p>\n" +
                    "</blockquote>\n" +
                    "<h2 id=\"composing-components\">Composing Components</h2>\n" +
                    "<p>Components can refer to other components in their output. This lets us use the same component abstraction for any level of detail. A button, a form, a dialog, a screen: in React apps, all those are commonly expressed as components.</p>\n" +
                    "<p>For example, we can create an&nbsp;<code class=\"gatsby-code-text\">App</code>&nbsp;component that renders&nbsp;<code class=\"gatsby-code-text\">Welcome</code>&nbsp;many times:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">Welcome</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, </span><span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>name<span class=\"token punctuation\">}</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"token keyword\">function</span> <span class=\"token function\">App</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Welcome <span class=\"token attr-name\">name</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Sara<span class=\"token punctuation\">\"</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Welcome <span class=\"token attr-name\">name</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Cahal<span class=\"token punctuation\">\"</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Welcome <span class=\"token attr-name\">name</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Edite<span class=\"token punctuation\">\"</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "</span>    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">render</span><span class=\"token punctuation\">(</span>\n" +
                    "  <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>App <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">,</span>\n" +
                    "  document<span class=\"token punctuation\">.</span><span class=\"token function\">getElementById</span><span class=\"token punctuation\">(</span><span class=\"token string\">'root'</span><span class=\"token punctuation\">)</span>\n" +
                    "<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p><a href=\"https://reactjs.org/redirect-to-codepen/components-and-props/composing-components\" target=\"_blank\" rel=\"noreferrer\"><strong>Try it on CodePen</strong></a></p>\n" +
                    "<p>Typically, new React apps have a single&nbsp;<code class=\"gatsby-code-text\">App</code>&nbsp;component at the very top. However, if you integrate React into an existing app, you might start bottom-up with a small component like&nbsp;<code class=\"gatsby-code-text\">Button</code>&nbsp;and gradually work your way to the top of the view hierarchy.</p>\n" +
                    "<h2 id=\"extracting-components\">Extracting Components</h2>\n" +
                    "<p>Don&rsquo;t be afraid to split components into smaller components.</p>\n" +
                    "<p>For example, consider this&nbsp;<code class=\"gatsby-code-text\">Comment</code>&nbsp;component:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">Comment</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Comment<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>UserInfo<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>img <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Avatar<span class=\"token punctuation\">\"</span></span>\n" +
                    "          <span class=\"token attr-name\">src</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>author<span class=\"token punctuation\">.</span>avatarUrl<span class=\"token punctuation\">}</span></span>\n" +
                    "          <span class=\"token attr-name\">alt</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>author<span class=\"token punctuation\">.</span>name<span class=\"token punctuation\">}</span></span>\n" +
                    "        <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>UserInfo-name<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "          <span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>author<span class=\"token punctuation\">.</span>name<span class=\"token punctuation\">}</span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Comment-text<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>text<span class=\"token punctuation\">}</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Comment-date<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token punctuation\">{</span><span class=\"token function\">formatDate</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">.</span>date<span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p><a href=\"https://reactjs.org/redirect-to-codepen/components-and-props/extracting-components\" target=\"_blank\" rel=\"noreferrer\"><strong>Try it on CodePen</strong></a></p>\n" +
                    "<p>It accepts&nbsp;<code class=\"gatsby-code-text\">author</code>&nbsp;(an object),&nbsp;<code class=\"gatsby-code-text\">text</code>&nbsp;(a string), and&nbsp;<code class=\"gatsby-code-text\">date</code>&nbsp;(a date) as props, and describes a comment on a social media website.</p>\n" +
                    "<p>This component can be tricky to change because of all the nesting, and it is also hard to reuse individual parts of it. Let&rsquo;s extract a few components from it.</p>\n" +
                    "<p>First, we will extract&nbsp;<code class=\"gatsby-code-text\">Avatar</code>:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">Avatar</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>img <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Avatar<span class=\"token punctuation\">\"</span></span>\n" +
                    "</span>      <span class=\"token attr-name\">src</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>user<span class=\"token punctuation\">.</span>avatarUrl<span class=\"token punctuation\">}</span></span>\n" +
                    "      <span class=\"token attr-name\">alt</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>user<span class=\"token punctuation\">.</span>name<span class=\"token punctuation\">}</span></span>\n" +
                    "    <span class=\"token punctuation\">/&gt;</span>\n" +
                    "</span>  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>The&nbsp;<code class=\"gatsby-code-text\">Avatar</code>&nbsp;doesn&rsquo;t need to know that it is being rendered inside a&nbsp;<code class=\"gatsby-code-text\">Comment</code>. This is why we have given its prop a more generic name:&nbsp;<code class=\"gatsby-code-text\">user</code>&nbsp;rather than&nbsp;<code class=\"gatsby-code-text\">author</code>.</p>\n" +
                    "<p>We recommend naming props from the component&rsquo;s own point of view rather than the context in which it is being used.</p>\n" +
                    "<p>We can now simplify&nbsp;<code class=\"gatsby-code-text\">Comment</code>&nbsp;a tiny bit:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">Comment</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Comment<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>UserInfo<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Avatar <span class=\"token attr-name\">user</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>author<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "</span>        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>UserInfo-name<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "          <span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>author<span class=\"token punctuation\">.</span>name<span class=\"token punctuation\">}</span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Comment-text<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>text<span class=\"token punctuation\">}</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Comment-date<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token punctuation\">{</span><span class=\"token function\">formatDate</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">.</span>date<span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Next, we will extract a&nbsp;<code class=\"gatsby-code-text\">UserInfo</code>&nbsp;component that renders an&nbsp;<code class=\"gatsby-code-text\">Avatar</code>&nbsp;next to the user&rsquo;s name:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">UserInfo</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>UserInfo<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Avatar <span class=\"token attr-name\">user</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>user<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>UserInfo-name<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">        <span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>user<span class=\"token punctuation\">.</span>name<span class=\"token punctuation\">}</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span>  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>This lets us simplify&nbsp;<code class=\"gatsby-code-text\">Comment</code>&nbsp;even further:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">Comment</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Comment<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>UserInfo <span class=\"token attr-name\">user</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>author<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "</span>      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Comment-text<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>text<span class=\"token punctuation\">}</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Comment-date<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token punctuation\">{</span><span class=\"token function\">formatDate</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">.</span>date<span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p><a href=\"https://reactjs.org/redirect-to-codepen/components-and-props/extracting-components-continued\" target=\"_blank\" rel=\"noreferrer\"><strong>Try it on CodePen</strong></a></p>\n" +
                    "<p>Extracting components might seem like grunt work at first, but having a palette of reusable components pays off in larger apps. A good rule of thumb is that if a part of your UI is used several times (<code class=\"gatsby-code-text\">Button</code>,&nbsp;<code class=\"gatsby-code-text\">Panel</code>,&nbsp;<code class=\"gatsby-code-text\">Avatar</code>), or is complex enough on its own (<code class=\"gatsby-code-text\">App</code>,&nbsp;<code class=\"gatsby-code-text\">FeedStory</code>,&nbsp;<code class=\"gatsby-code-text\">Comment</code>), it is a good candidate to be a reusable component.</p>\n" +
                    "<h2 id=\"props-are-read-only\">Props are Read-Only</h2>\n" +
                    "<p>Whether you declare a component&nbsp;<a href=\"https://reactjs.org/docs/components-and-props.html#function-and-class-components\">as a function or a class</a>, it must never modify its own props. Consider this&nbsp;<code class=\"gatsby-code-text\">sum</code>&nbsp;function:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">sum</span><span class=\"token punctuation\">(</span>a<span class=\"token punctuation\">,</span> b<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> a <span class=\"token operator\">+</span> b<span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Such functions are called&nbsp;<a href=\"https://en.wikipedia.org/wiki/Pure_function\">&ldquo;pure&rdquo;</a>&nbsp;because they do not attempt to change their inputs, and always return the same result for the same inputs.</p>\n" +
                    "<p>In contrast, this function is impure because it changes its own input:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">withdraw</span><span class=\"token punctuation\">(</span>account<span class=\"token punctuation\">,</span> amount<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  account<span class=\"token punctuation\">.</span>total <span class=\"token operator\">-=</span> amount<span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>React is pretty flexible but it has a single strict rule:</p>\n" +
                    "<p><strong>All React components must act like pure functions with respect to their props.</strong></p>\n" +
                    "<p>Of course, application UIs are dynamic and change over time. In the&nbsp;<a href=\"https://reactjs.org/docs/state-and-lifecycle.html\">next section</a>, we will introduce a new concept of &ldquo;state&rdquo;. State allows React components to change their output over time in response to user actions, network responses, and anything else, without violating this rule.</p>\n" +
                    "</div>");
            sec3React1.setLesson(reactJsLesson1);
            reactJsLesson1.getSections().add(sec3React1);

            Section sec4React1 = new Section();
            sec4React1.setOrdinalNumber(4);
            sec4React1.setDescription("State and Lifecycle");
            sec4React1.setContent("<div class=\"css-7u1i3w\">\n" +
                    "<p>This page introduces the concept of state and lifecycle in a React component. You can find a&nbsp;<a href=\"https://reactjs.org/docs/react-component.html\">detailed component API reference here</a>.</p>\n" +
                    "<p>Consider the ticking clock example from&nbsp;<a href=\"https://reactjs.org/docs/rendering-elements.html#updating-the-rendered-element\">one of the previous sections</a>. In&nbsp;<a href=\"https://reactjs.org/docs/rendering-elements.html#rendering-an-element-into-the-dom\">Rendering Elements</a>, we have only learned one way to update the UI. We call&nbsp;<code class=\"gatsby-code-text\">ReactDOM.render()</code>&nbsp;to change the rendered output:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">tick</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">const</span> element <span class=\"token operator\">=</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, world!</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h2<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">It is </span><span class=\"token punctuation\">{</span><span class=\"token keyword\">new</span> <span class=\"token class-name\">Date</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">.</span><span class=\"token function\">toLocaleTimeString</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token plain-text\">.</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h2<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">render</span><span class=\"token punctuation\">(</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    element<span class=\"token punctuation\">,</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    document<span class=\"token punctuation\">.</span><span class=\"token function\">getElementById</span><span class=\"token punctuation\">(</span><span class=\"token string\">'root'</span><span class=\"token punctuation\">)</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"token function\">setInterval</span><span class=\"token punctuation\">(</span>tick<span class=\"token punctuation\">,</span> <span class=\"token number\">1000</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p><a href=\"http://codepen.io/gaearon/pen/gwoJZk?editors=0010\"><strong>Try it on CodePen</strong></a></p>\n" +
                    "<p>In this section, we will learn how to make the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;component truly reusable and encapsulated. It will set up its own timer and update itself every second.</p>\n" +
                    "<p>We can start by encapsulating how the clock looks:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">Clock</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, world!</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h2<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">It is </span><span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>date<span class=\"token punctuation\">.</span><span class=\"token function\">toLocaleTimeString</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token plain-text\">.</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h2<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span>  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"token keyword\">function</span> <span class=\"token function\">tick</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">render</span><span class=\"token punctuation\">(</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Clock <span class=\"token attr-name\">date</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token keyword\">new</span> <span class=\"token class-name\">Date</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">,</span>\n" +
                    "</span>    document<span class=\"token punctuation\">.</span><span class=\"token function\">getElementById</span><span class=\"token punctuation\">(</span><span class=\"token string\">'root'</span><span class=\"token punctuation\">)</span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"token function\">setInterval</span><span class=\"token punctuation\">(</span>tick<span class=\"token punctuation\">,</span> <span class=\"token number\">1000</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p><a href=\"http://codepen.io/gaearon/pen/dpdoYR?editors=0010\"><strong>Try it on CodePen</strong></a></p>\n" +
                    "<p>However, it misses a crucial requirement: the fact that the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;sets up a timer and updates the UI every second should be an implementation detail of the&nbsp;<code class=\"gatsby-code-text\">Clock</code>.</p>\n" +
                    "<p>Ideally we want to write this once and have the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;update itself:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">render</span><span class=\"token punctuation\">(</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Clock <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">,</span>\n" +
                    "</span>  document<span class=\"token punctuation\">.</span><span class=\"token function\">getElementById</span><span class=\"token punctuation\">(</span><span class=\"token string\">'root'</span><span class=\"token punctuation\">)</span>\n" +
                    "<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>To implement this, we need to add &ldquo;state&rdquo; to the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;component.</p>\n" +
                    "<p>State is similar to props, but it is private and fully controlled by the component.</p>\n" +
                    "<p>We&nbsp;<a href=\"https://reactjs.org/docs/components-and-props.html#functional-and-class-components\">mentioned before</a>&nbsp;that components defined as classes have some additional features. Local state is exactly that: a feature available only to classes.</p>\n" +
                    "<h2 id=\"converting-a-function-to-a-class\">Converting a Function to a Class</h2>\n" +
                    "<p>You can convert a function component like&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;to a class in five steps:</p>\n" +
                    "<ol>\n" +
                    "<li>\n" +
                    "<p>Create an&nbsp;<a href=\"https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Classes\">ES6 class</a>, with the same name, that extends&nbsp;<code class=\"gatsby-code-text\">React.Component</code>.</p>\n" +
                    "</li>\n" +
                    "<li>\n" +
                    "<p>Add a single empty method to it called&nbsp;<code class=\"gatsby-code-text\">render()</code>.</p>\n" +
                    "</li>\n" +
                    "<li>\n" +
                    "<p>Move the body of the function into the&nbsp;<code class=\"gatsby-code-text\">render()</code>&nbsp;method.</p>\n" +
                    "</li>\n" +
                    "<li>\n" +
                    "<p>Replace&nbsp;<code class=\"gatsby-code-text\">props</code>&nbsp;with&nbsp;<code class=\"gatsby-code-text\">this.props</code>&nbsp;in the&nbsp;<code class=\"gatsby-code-text\">render()</code>&nbsp;body.</p>\n" +
                    "</li>\n" +
                    "<li>\n" +
                    "<p>Delete the remaining empty function declaration.</p>\n" +
                    "</li>\n" +
                    "</ol>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">class</span> <span class=\"token class-name\">Clock</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, world!</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h2<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">It is </span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>props<span class=\"token punctuation\">.</span>date<span class=\"token punctuation\">.</span><span class=\"token function\">toLocaleTimeString</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token plain-text\">.</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h2<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p><a href=\"http://codepen.io/gaearon/pen/zKRGpo?editors=0010\"><strong>Try it on CodePen</strong></a></p>\n" +
                    "<p><code class=\"gatsby-code-text\">Clock</code>&nbsp;is now defined as a class rather than a function.</p>\n" +
                    "<p>The&nbsp;<code class=\"gatsby-code-text\">render</code>&nbsp;method will be called each time an update happens, but as long as we render&nbsp;<code class=\"gatsby-code-text\">&lt;Clock /&gt;</code>&nbsp;into the same DOM node, only a single instance of the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;class will be used. This lets us use additional features such as local state and lifecycle methods.</p>\n" +
                    "<h2 id=\"adding-local-state-to-a-class\">Adding Local State to a Class</h2>\n" +
                    "<p>We will move the&nbsp;<code class=\"gatsby-code-text\">date</code>&nbsp;from props to state in three steps:</p>\n" +
                    "<ol>\n" +
                    "<li>Replace&nbsp;<code class=\"gatsby-code-text\">this.props.date</code>&nbsp;with&nbsp;<code class=\"gatsby-code-text\">this.state.date</code>&nbsp;in the&nbsp;<code class=\"gatsby-code-text\">render()</code>&nbsp;method:</li>\n" +
                    "</ol>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">class</span> <span class=\"token class-name\">Clock</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, world!</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h2<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">It is </span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state<span class=\"token punctuation\">.</span>date<span class=\"token punctuation\">.</span><span class=\"token function\">toLocaleTimeString</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token plain-text\">.</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h2<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span>      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<ol start=\"2\">\n" +
                    "<li>Add a&nbsp;<a href=\"https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Classes#Constructor\">class constructor</a>&nbsp;that assigns the initial&nbsp;<code class=\"gatsby-code-text\">this.state</code>:</li>\n" +
                    "</ol>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">class</span> <span class=\"token class-name\">Clock</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">constructor</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">super</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state <span class=\"token operator\">=</span> <span class=\"token punctuation\">{</span>date<span class=\"token punctuation\">:</span> <span class=\"token keyword\">new</span> <span class=\"token class-name\">Date</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "</span>  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, world!</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h2<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">It is </span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state<span class=\"token punctuation\">.</span>date<span class=\"token punctuation\">.</span><span class=\"token function\">toLocaleTimeString</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token plain-text\">.</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h2<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Note how we pass&nbsp;<code class=\"gatsby-code-text\">props</code>&nbsp;to the base constructor:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">  <span class=\"token function\">constructor</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">super</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span>    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state <span class=\"token operator\">=</span> <span class=\"token punctuation\">{</span>date<span class=\"token punctuation\">:</span> <span class=\"token keyword\">new</span> <span class=\"token class-name\">Date</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Class components should always call the base constructor with&nbsp;<code class=\"gatsby-code-text\">props</code>.</p>\n" +
                    "<ol start=\"3\">\n" +
                    "<li>Remove the&nbsp;<code class=\"gatsby-code-text\">date</code>&nbsp;prop from the&nbsp;<code class=\"gatsby-code-text\">&lt;Clock /&gt;</code>&nbsp;element:</li>\n" +
                    "</ol>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">render</span><span class=\"token punctuation\">(</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Clock <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">,</span>\n" +
                    "</span>  document<span class=\"token punctuation\">.</span><span class=\"token function\">getElementById</span><span class=\"token punctuation\">(</span><span class=\"token string\">'root'</span><span class=\"token punctuation\">)</span>\n" +
                    "<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>We will later add the timer code back to the component itself.</p>\n" +
                    "<p>The result looks like this:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">class</span> <span class=\"token class-name\">Clock</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token function\">constructor</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">super</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state <span class=\"token operator\">=</span> <span class=\"token punctuation\">{</span>date<span class=\"token punctuation\">:</span> <span class=\"token keyword\">new</span> <span class=\"token class-name\">Date</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token punctuation\">}</span>\n" +
                    "</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, world!</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h2<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">It is </span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state<span class=\"token punctuation\">.</span>date<span class=\"token punctuation\">.</span><span class=\"token function\">toLocaleTimeString</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token plain-text\">.</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h2<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span>      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">render</span><span class=\"token punctuation\">(</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Clock <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">,</span>\n" +
                    "</span>  document<span class=\"token punctuation\">.</span><span class=\"token function\">getElementById</span><span class=\"token punctuation\">(</span><span class=\"token string\">'root'</span><span class=\"token punctuation\">)</span>\n" +
                    "<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p><a href=\"http://codepen.io/gaearon/pen/KgQpJd?editors=0010\"><strong>Try it on CodePen</strong></a></p>\n" +
                    "<p>Next, we&rsquo;ll make the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;set up its own timer and update itself every second.</p>\n" +
                    "<h2 id=\"adding-lifecycle-methods-to-a-class\">Adding Lifecycle Methods to a Class</h2>\n" +
                    "<p>In applications with many components, it&rsquo;s very important to free up resources taken by the components when they are destroyed.</p>\n" +
                    "<p>We want to&nbsp;<a href=\"https://developer.mozilla.org/en-US/docs/Web/API/WindowTimers/setInterval\">set up a timer</a>&nbsp;whenever the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;is rendered to the DOM for the first time. This is called &ldquo;mounting&rdquo; in React.</p>\n" +
                    "<p>We also want to&nbsp;<a href=\"https://developer.mozilla.org/en-US/docs/Web/API/WindowTimers/clearInterval\">clear that timer</a>&nbsp;whenever the DOM produced by the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;is removed. This is called &ldquo;unmounting&rdquo; in React.</p>\n" +
                    "<p>We can declare special methods on the component class to run some code when a component mounts and unmounts:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">class</span> <span class=\"token class-name\">Clock</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">constructor</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">super</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state <span class=\"token operator\">=</span> <span class=\"token punctuation\">{</span>date<span class=\"token punctuation\">:</span> <span class=\"token keyword\">new</span> <span class=\"token class-name\">Date</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token function\">componentDidMount</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token punctuation\">}</span>\n" +
                    "</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token function\">componentWillUnmount</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token punctuation\">}</span>\n" +
                    "</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, world!</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h2<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">It is </span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state<span class=\"token punctuation\">.</span>date<span class=\"token punctuation\">.</span><span class=\"token function\">toLocaleTimeString</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token plain-text\">.</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h2<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>These methods are called &ldquo;lifecycle methods&rdquo;.</p>\n" +
                    "<p>The&nbsp;<code class=\"gatsby-code-text\">componentDidMount()</code>&nbsp;method runs after the component output has been rendered to the DOM. This is a good place to set up a timer:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">  <span class=\"token function\">componentDidMount</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>timerID <span class=\"token operator\">=</span> <span class=\"token function\">setInterval</span><span class=\"token punctuation\">(</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token operator\">=&gt;</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">tick</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">,</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token number\">1000</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span>  <span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Note how we save the timer ID right on&nbsp;<code class=\"gatsby-code-text\">this</code>.</p>\n" +
                    "<p>While&nbsp;<code class=\"gatsby-code-text\">this.props</code>&nbsp;is set up by React itself and&nbsp;<code class=\"gatsby-code-text\">this.state</code>&nbsp;has a special meaning, you are free to add additional fields to the class manually if you need to store something that doesn&rsquo;t participate in the data flow (like a timer ID).</p>\n" +
                    "<p>We will tear down the timer in the&nbsp;<code class=\"gatsby-code-text\">componentWillUnmount()</code>&nbsp;lifecycle method:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">  <span class=\"token function\">componentWillUnmount</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token function\">clearInterval</span><span class=\"token punctuation\">(</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>timerID<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span>  <span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Finally, we will implement a method called&nbsp;<code class=\"gatsby-code-text\">tick()</code>&nbsp;that the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;component will run every second.</p>\n" +
                    "<p>It will use&nbsp;<code class=\"gatsby-code-text\">this.setState()</code>&nbsp;to schedule updates to the component local state:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">class</span> <span class=\"token class-name\">Clock</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">constructor</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">super</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state <span class=\"token operator\">=</span> <span class=\"token punctuation\">{</span>date<span class=\"token punctuation\">:</span> <span class=\"token keyword\">new</span> <span class=\"token class-name\">Date</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "  <span class=\"token function\">componentDidMount</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>timerID <span class=\"token operator\">=</span> <span class=\"token function\">setInterval</span><span class=\"token punctuation\">(</span>\n" +
                    "      <span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token operator\">=&gt;</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">tick</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">,</span>\n" +
                    "      <span class=\"token number\">1000</span>\n" +
                    "    <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "  <span class=\"token function\">componentWillUnmount</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token function\">clearInterval</span><span class=\"token punctuation\">(</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>timerID<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token function\">tick</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">setState</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      date<span class=\"token punctuation\">:</span> <span class=\"token keyword\">new</span> <span class=\"token class-name\">Date</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token punctuation\">}</span>\n" +
                    "</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello, world!</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h2<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">It is </span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state<span class=\"token punctuation\">.</span>date<span class=\"token punctuation\">.</span><span class=\"token function\">toLocaleTimeString</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token plain-text\">.</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h2<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">render</span><span class=\"token punctuation\">(</span>\n" +
                    "  <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Clock <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">,</span>\n" +
                    "  document<span class=\"token punctuation\">.</span><span class=\"token function\">getElementById</span><span class=\"token punctuation\">(</span><span class=\"token string\">'root'</span><span class=\"token punctuation\">)</span>\n" +
                    "<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p><a href=\"http://codepen.io/gaearon/pen/amqdNA?editors=0010\"><strong>Try it on CodePen</strong></a></p>\n" +
                    "<p>Now the clock ticks every second.</p>\n" +
                    "<p>Let&rsquo;s quickly recap what&rsquo;s going on and the order in which the methods are called:</p>\n" +
                    "<ol>\n" +
                    "<li>\n" +
                    "<p>When&nbsp;<code class=\"gatsby-code-text\">&lt;Clock /&gt;</code>&nbsp;is passed to&nbsp;<code class=\"gatsby-code-text\">ReactDOM.render()</code>, React calls the constructor of the&nbsp;<code class=\"gatsby-code-text\">Clock</code>component. Since&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;needs to display the current time, it initializes&nbsp;<code class=\"gatsby-code-text\">this.state</code>&nbsp;with an object including the current time. We will later update this state.</p>\n" +
                    "</li>\n" +
                    "<li>\n" +
                    "<p>React then calls the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;component&rsquo;s&nbsp;<code class=\"gatsby-code-text\">render()</code>&nbsp;method. This is how React learns what should be displayed on the screen. React then updates the DOM to match the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&rsquo;s render output.</p>\n" +
                    "</li>\n" +
                    "<li>\n" +
                    "<p>When the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;output is inserted in the DOM, React calls the&nbsp;<code class=\"gatsby-code-text\">componentDidMount()</code>&nbsp;lifecycle method. Inside it, the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;component asks the browser to set up a timer to call the component&rsquo;s&nbsp;<code class=\"gatsby-code-text\">tick()</code>&nbsp;method once a second.</p>\n" +
                    "</li>\n" +
                    "<li>\n" +
                    "<p>Every second the browser calls the&nbsp;<code class=\"gatsby-code-text\">tick()</code>&nbsp;method. Inside it, the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;component schedules a UI update by calling&nbsp;<code class=\"gatsby-code-text\">setState()</code>&nbsp;with an object containing the current time. Thanks to the&nbsp;<code class=\"gatsby-code-text\">setState()</code>&nbsp;call, React knows the state has changed, and calls the&nbsp;<code class=\"gatsby-code-text\">render()</code>&nbsp;method again to learn what should be on the screen. This time,&nbsp;<code class=\"gatsby-code-text\">this.state.date</code>&nbsp;in the&nbsp;<code class=\"gatsby-code-text\">render()</code>&nbsp;method will be different, and so the render output will include the updated time. React updates the DOM accordingly.</p>\n" +
                    "</li>\n" +
                    "<li>\n" +
                    "<p>If the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;component is ever removed from the DOM, React calls the&nbsp;<code class=\"gatsby-code-text\">componentWillUnmount()</code>&nbsp;lifecycle method so the timer is stopped.</p>\n" +
                    "</li>\n" +
                    "</ol>\n" +
                    "<h2 id=\"using-state-correctly\">Using State Correctly</h2>\n" +
                    "<p>There are three things you should know about&nbsp;<code class=\"gatsby-code-text\">setState()</code>.</p>\n" +
                    "<h3 id=\"do-not-modify-state-directly\">Do Not Modify State Directly</h3>\n" +
                    "<p>For example, this will not re-render a component:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token comment\">// Wrong</span>\n" +
                    "<span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state<span class=\"token punctuation\">.</span>comment <span class=\"token operator\">=</span> <span class=\"token string\">'Hello'</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Instead, use&nbsp;<code class=\"gatsby-code-text\">setState()</code>:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token comment\">// Correct</span>\n" +
                    "<span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">setState</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">{</span>comment<span class=\"token punctuation\">:</span> <span class=\"token string\">'Hello'</span><span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>The only place where you can assign&nbsp;<code class=\"gatsby-code-text\">this.state</code>&nbsp;is the constructor.</p>\n" +
                    "<h3 id=\"state-updates-may-be-asynchronous\">State Updates May Be Asynchronous</h3>\n" +
                    "<p>React may batch multiple&nbsp;<code class=\"gatsby-code-text\">setState()</code>&nbsp;calls into a single update for performance.</p>\n" +
                    "<p>Because&nbsp;<code class=\"gatsby-code-text\">this.props</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">this.state</code>&nbsp;may be updated asynchronously, you should not rely on their values for calculating the next state.</p>\n" +
                    "<p>For example, this code may fail to update the counter:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token comment\">// Wrong</span>\n" +
                    "<span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">setState</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">{</span>\n" +
                    "  counter<span class=\"token punctuation\">:</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state<span class=\"token punctuation\">.</span>counter <span class=\"token operator\">+</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>props<span class=\"token punctuation\">.</span>increment<span class=\"token punctuation\">,</span>\n" +
                    "<span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>To fix it, use a second form of&nbsp;<code class=\"gatsby-code-text\">setState()</code>&nbsp;that accepts a function rather than an object. That function will receive the previous state as the first argument, and the props at the time the update is applied as the second argument:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token comment\">// Correct</span>\n" +
                    "<span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">setState</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">(</span>state<span class=\"token punctuation\">,</span> props<span class=\"token punctuation\">)</span> <span class=\"token operator\">=&gt;</span> <span class=\"token punctuation\">(</span><span class=\"token punctuation\">{</span>\n" +
                    "  counter<span class=\"token punctuation\">:</span> state<span class=\"token punctuation\">.</span>counter <span class=\"token operator\">+</span> props<span class=\"token punctuation\">.</span>increment\n" +
                    "<span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>We used an&nbsp;<a href=\"https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Functions/Arrow_functions\">arrow function</a>&nbsp;above, but it also works with regular functions:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token comment\">// Correct</span>\n" +
                    "<span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">setState</span><span class=\"token punctuation\">(</span><span class=\"token keyword\">function</span><span class=\"token punctuation\">(</span>state<span class=\"token punctuation\">,</span> props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">{</span>\n" +
                    "    counter<span class=\"token punctuation\">:</span> state<span class=\"token punctuation\">.</span>counter <span class=\"token operator\">+</span> props<span class=\"token punctuation\">.</span>increment\n" +
                    "  <span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<h3 id=\"state-updates-are-merged\">State Updates are Merged</h3>\n" +
                    "<p>When you call&nbsp;<code class=\"gatsby-code-text\">setState()</code>, React merges the object you provide into the current state.</p>\n" +
                    "<p>For example, your state may contain several independent variables:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">  <span class=\"token function\">constructor</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">super</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state <span class=\"token operator\">=</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">      posts<span class=\"token punctuation\">:</span> <span class=\"token punctuation\">[</span><span class=\"token punctuation\">]</span><span class=\"token punctuation\">,</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      comments<span class=\"token punctuation\">:</span> <span class=\"token punctuation\">[</span><span class=\"token punctuation\">]</span>\n" +
                    "</span>    <span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Then you can update them independently with separate&nbsp;<code class=\"gatsby-code-text\">setState()</code>&nbsp;calls:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">  <span class=\"token function\">componentDidMount</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token function\">fetchPosts</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">.</span><span class=\"token function\">then</span><span class=\"token punctuation\">(</span>response <span class=\"token operator\">=&gt;</span> <span class=\"token punctuation\">{</span>\n" +
                    "      <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">setState</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">        posts<span class=\"token punctuation\">:</span> response<span class=\"token punctuation\">.</span>posts\n" +
                    "</span>      <span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "    <span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "\n" +
                    "    <span class=\"token function\">fetchComments</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">.</span><span class=\"token function\">then</span><span class=\"token punctuation\">(</span>response <span class=\"token operator\">=&gt;</span> <span class=\"token punctuation\">{</span>\n" +
                    "      <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">setState</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">        comments<span class=\"token punctuation\">:</span> response<span class=\"token punctuation\">.</span>comments\n" +
                    "</span>      <span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "    <span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>The merging is shallow, so&nbsp;<code class=\"gatsby-code-text\">this.setState({comments})</code>&nbsp;leaves&nbsp;<code class=\"gatsby-code-text\">this.state.posts</code>&nbsp;intact, but completely replaces&nbsp;<code class=\"gatsby-code-text\">this.state.comments</code>.</p>\n" +
                    "<h2 id=\"the-data-flows-down\">The Data Flows Down</h2>\n" +
                    "<p>Neither parent nor child components can know if a certain component is stateful or stateless, and they shouldn&rsquo;t care whether it is defined as a function or a class.</p>\n" +
                    "<p>This is why state is often called local or encapsulated. It is not accessible to any component other than the one that owns and sets it.</p>\n" +
                    "<p>A component may choose to pass its state down as props to its child components:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h2<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">It is </span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state<span class=\"token punctuation\">.</span>date<span class=\"token punctuation\">.</span><span class=\"token function\">toLocaleTimeString</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token plain-text\">.</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h2<span class=\"token punctuation\">&gt;</span></span></code></pre>\n" +
                    "</div>\n" +
                    "<p>This also works for user-defined components:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>FormattedDate <span class=\"token attr-name\">date</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state<span class=\"token punctuation\">.</span>date<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span></code></pre>\n" +
                    "</div>\n" +
                    "<p>The&nbsp;<code class=\"gatsby-code-text\">FormattedDate</code>&nbsp;component would receive the&nbsp;<code class=\"gatsby-code-text\">date</code>&nbsp;in its props and wouldn&rsquo;t know whether it came from the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&rsquo;s state, from the&nbsp;<code class=\"gatsby-code-text\">Clock</code>&rsquo;s props, or was typed by hand:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">FormattedDate</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h2<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">It is </span><span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>date<span class=\"token punctuation\">.</span><span class=\"token function\">toLocaleTimeString</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span><span class=\"token plain-text\">.</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h2<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p><a href=\"http://codepen.io/gaearon/pen/zKRqNB?editors=0010\"><strong>Try it on CodePen</strong></a></p>\n" +
                    "<p>This is commonly called a &ldquo;top-down&rdquo; or &ldquo;unidirectional&rdquo; data flow. Any state is always owned by some specific component, and any data or UI derived from that state can only affect components &ldquo;below&rdquo; them in the tree.</p>\n" +
                    "<p>If you imagine a component tree as a waterfall of props, each component&rsquo;s state is like an additional water source that joins it at an arbitrary point but also flows down.</p>\n" +
                    "<p>To show that all components are truly isolated, we can create an&nbsp;<code class=\"gatsby-code-text\">App</code>&nbsp;component that renders three&nbsp;<code class=\"gatsby-code-text\">&lt;Clock&gt;</code>s:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">App</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Clock <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Clock <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Clock <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "</span>    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">render</span><span class=\"token punctuation\">(</span>\n" +
                    "  <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>App <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">,</span>\n" +
                    "  document<span class=\"token punctuation\">.</span><span class=\"token function\">getElementById</span><span class=\"token punctuation\">(</span><span class=\"token string\">'root'</span><span class=\"token punctuation\">)</span>\n" +
                    "<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p><a href=\"http://codepen.io/gaearon/pen/vXdGmd?editors=0010\"><strong>Try it on CodePen</strong></a></p>\n" +
                    "<p>Each&nbsp;<code class=\"gatsby-code-text\">Clock</code>&nbsp;sets up its own timer and updates independently.</p>\n" +
                    "<p>In React apps, whether a component is stateful or stateless is considered an implementation detail of the component that may change over time. You can use stateless components inside stateful components, and vice versa.</p>\n" +
                    "</div>");
            sec4React1.setLesson(reactJsLesson1);
            reactJsLesson1.getSections().add(sec4React1);

            Section sec5React1 = new Section();
            sec5React1.setOrdinalNumber(5);
            sec5React1.setDescription("Handling Events");
            sec5React1.setContent("<div class=\"css-7u1i3w\">\n" +
                    "<p>Handling events with React elements is very similar to handling events on DOM elements. There are some syntactic differences:</p>\n" +
                    "<ul>\n" +
                    "<li>React events are named using camelCase, rather than lowercase.</li>\n" +
                    "<li>With JSX you pass a function as the event handler, rather than a string.</li>\n" +
                    "</ul>\n" +
                    "<p>For example, the HTML:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"html\">\n" +
                    "<pre class=\"gatsby-code-html\"><code class=\"gatsby-code-html\"><span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>button <span class=\"token attr-name\">onclick</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>activateLasers()<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  Activate Lasers\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>button<span class=\"token punctuation\">&gt;</span></span></code></pre>\n" +
                    "</div>\n" +
                    "<p>is slightly different in React:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"gatsby-highlight-code-line\"><span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>button <span class=\"token attr-name\">onClick</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>activateLasers<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span><span class=\"token plain-text\">  Activate Lasers</span>\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>button<span class=\"token punctuation\">&gt;</span></span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Another difference is that you cannot return&nbsp;<code class=\"gatsby-code-text\">false</code>&nbsp;to prevent default behavior in React. You must call&nbsp;<code class=\"gatsby-code-text\">preventDefault</code>&nbsp;explicitly. For example, with plain HTML, to prevent the default link behavior of opening a new page, you can write:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"html\">\n" +
                    "<pre class=\"gatsby-code-html\"><code class=\"gatsby-code-html\"><span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>a <span class=\"token attr-name\">href</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>#<span class=\"token punctuation\">\"</span></span> <span class=\"token attr-name\">onclick</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>console.log(<span class=\"token punctuation\">'</span>The link was clicked.<span class=\"token punctuation\">'</span>); return false<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  Click me\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>a<span class=\"token punctuation\">&gt;</span></span></code></pre>\n" +
                    "</div>\n" +
                    "<p>In React, this could instead be:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">ActionLink</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token keyword\">function</span> <span class=\"token function\">handleClick</span><span class=\"token punctuation\">(</span>e<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    e<span class=\"token punctuation\">.</span><span class=\"token function\">preventDefault</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    console<span class=\"token punctuation\">.</span><span class=\"token function\">log</span><span class=\"token punctuation\">(</span><span class=\"token string\">'The link was clicked.'</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token punctuation\">}</span>\n" +
                    "</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>a <span class=\"token attr-name\">href</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>#<span class=\"token punctuation\">\"</span></span> <span class=\"token attr-name\">onClick</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>handleClick<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span><span class=\"token plain-text\">      Click me</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>a<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Here,&nbsp;<code class=\"gatsby-code-text\">e</code>&nbsp;is a synthetic event. React defines these synthetic events according to the&nbsp;<a href=\"https://www.w3.org/TR/DOM-Level-3-Events/\">W3C spec</a>, so you don&rsquo;t need to worry about cross-browser compatibility. See the&nbsp;<a href=\"https://reactjs.org/docs/events.html\"><code class=\"gatsby-code-text\">SyntheticEvent</code></a>reference guide to learn more.</p>\n" +
                    "<p>When using React you should generally not need to call&nbsp;<code class=\"gatsby-code-text\">addEventListener</code>&nbsp;to add listeners to a DOM element after it is created. Instead, just provide a listener when the element is initially rendered.</p>\n" +
                    "<p>When you define a component using an&nbsp;<a href=\"https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Classes\">ES6 class</a>, a common pattern is for an event handler to be a method on the class. For example, this&nbsp;<code class=\"gatsby-code-text\">Toggle</code>&nbsp;component renders a button that lets the user toggle between &ldquo;ON&rdquo; and &ldquo;OFF&rdquo; states:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">class</span> <span class=\"token class-name\">Toggle</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">constructor</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">super</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state <span class=\"token operator\">=</span> <span class=\"token punctuation\">{</span>isToggleOn<span class=\"token punctuation\">:</span> <span class=\"token boolean\">true</span><span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token comment\">// This binding is necessary to make `this` work in the callback</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>handleClick <span class=\"token operator\">=</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>handleClick<span class=\"token punctuation\">.</span><span class=\"token function\">bind</span><span class=\"token punctuation\">(</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span>  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token function\">handleClick</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">setState</span><span class=\"token punctuation\">(</span>state <span class=\"token operator\">=&gt;</span> <span class=\"token punctuation\">(</span><span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      isToggleOn<span class=\"token punctuation\">:</span> <span class=\"token operator\">!</span>state<span class=\"token punctuation\">.</span>isToggleOn\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token punctuation\">}</span>\n" +
                    "</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>button <span class=\"token attr-name\">onClick</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>handleClick<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span>        <span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state<span class=\"token punctuation\">.</span>isToggleOn <span class=\"token operator\">?</span> <span class=\"token string\">'ON'</span> <span class=\"token punctuation\">:</span> <span class=\"token string\">'OFF'</span><span class=\"token punctuation\">}</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>button<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">render</span><span class=\"token punctuation\">(</span>\n" +
                    "  <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Toggle <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">,</span>\n" +
                    "  document<span class=\"token punctuation\">.</span><span class=\"token function\">getElementById</span><span class=\"token punctuation\">(</span><span class=\"token string\">'root'</span><span class=\"token punctuation\">)</span>\n" +
                    "<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p><a href=\"http://codepen.io/gaearon/pen/xEmzGg?editors=0010\"><strong>Try it on CodePen</strong></a></p>\n" +
                    "<p>You have to be careful about the meaning of&nbsp;<code class=\"gatsby-code-text\">this</code>&nbsp;in JSX callbacks. In JavaScript, class methods are not&nbsp;<a href=\"https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Global_objects/Function/bind\">bound</a>&nbsp;by default. If you forget to bind&nbsp;<code class=\"gatsby-code-text\">this.handleClick</code>&nbsp;and pass it to&nbsp;<code class=\"gatsby-code-text\">onClick</code>,&nbsp;<code class=\"gatsby-code-text\">this</code>&nbsp;will be&nbsp;<code class=\"gatsby-code-text\">undefined</code>&nbsp;when the function is actually called.</p>\n" +
                    "<p>This is not React-specific behavior; it is a part of&nbsp;<a href=\"https://www.smashingmagazine.com/2014/01/understanding-javascript-function-prototype-bind/\">how functions work in JavaScript</a>. Generally, if you refer to a method without&nbsp;<code class=\"gatsby-code-text\">()</code>&nbsp;after it, such as&nbsp;<code class=\"gatsby-code-text\">onClick={this.handleClick}</code>, you should bind that method.</p>\n" +
                    "<p>If calling&nbsp;<code class=\"gatsby-code-text\">bind</code>&nbsp;annoys you, there are two ways you can get around this. If you are using the experimental&nbsp;<a href=\"https://babeljs.io/docs/plugins/transform-class-properties/\">public class fields syntax</a>, you can use class fields to correctly bind callbacks:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">class</span> <span class=\"token class-name\">LoggingButton</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// This syntax ensures `this` is bound within handleClick.</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// Warning: this is *experimental* syntax.</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token function-variable function\">handleClick</span> <span class=\"token operator\">=</span> <span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token operator\">=&gt;</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    console<span class=\"token punctuation\">.</span><span class=\"token function\">log</span><span class=\"token punctuation\">(</span><span class=\"token string\">'this is:'</span><span class=\"token punctuation\">,</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token punctuation\">}</span>\n" +
                    "</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>button <span class=\"token attr-name\">onClick</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>handleClick<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"token plain-text\">        Click me</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>button<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>This syntax is enabled by default in&nbsp;<a href=\"https://github.com/facebookincubator/create-react-app\">Create React App</a>.</p>\n" +
                    "<p>If you aren&rsquo;t using class fields syntax, you can use an&nbsp;<a href=\"https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Functions/Arrow_functions\">arrow function</a>&nbsp;in the callback:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">class</span> <span class=\"token class-name\">LoggingButton</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">handleClick</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    console<span class=\"token punctuation\">.</span><span class=\"token function\">log</span><span class=\"token punctuation\">(</span><span class=\"token string\">'this is:'</span><span class=\"token punctuation\">,</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token comment\">// This syntax ensures `this` is bound within handleClick</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>button <span class=\"token attr-name\">onClick</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token punctuation\">(</span>e<span class=\"token punctuation\">)</span> <span class=\"token operator\">=&gt;</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">handleClick</span><span class=\"token punctuation\">(</span>e<span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span><span class=\"token plain-text\">        Click me</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>button<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>The problem with this syntax is that a different callback is created each time the&nbsp;<code class=\"gatsby-code-text\">LoggingButton</code>&nbsp;renders. In most cases, this is fine. However, if this callback is passed as a prop to lower components, those components might do an extra re-rendering. We generally recommend binding in the constructor or using the class fields syntax, to avoid this sort of performance problem.</p>\n" +
                    "<h2 id=\"passing-arguments-to-event-handlers\">Passing Arguments to Event Handlers</h2>\n" +
                    "<p>Inside a loop it is common to want to pass an extra parameter to an event handler. For example, if&nbsp;<code class=\"gatsby-code-text\">id</code>&nbsp;is the row ID, either of the following would work:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>button <span class=\"token attr-name\">onClick</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token punctuation\">(</span>e<span class=\"token punctuation\">)</span> <span class=\"token operator\">=&gt;</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">deleteRow</span><span class=\"token punctuation\">(</span>id<span class=\"token punctuation\">,</span> e<span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Delete Row</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>button<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>button <span class=\"token attr-name\">onClick</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>deleteRow<span class=\"token punctuation\">.</span><span class=\"token function\">bind</span><span class=\"token punctuation\">(</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">,</span> id<span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Delete Row</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>button<span class=\"token punctuation\">&gt;</span></span></code></pre>\n" +
                    "</div>\n" +
                    "<p>The above two lines are equivalent, and use&nbsp;<a href=\"https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions\">arrow functions</a>&nbsp;and&nbsp;<a href=\"https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_objects/Function/bind\"><code class=\"gatsby-code-text\">Function.prototype.bind</code></a>respectively.</p>\n" +
                    "<p>In both cases, the&nbsp;<code class=\"gatsby-code-text\">e</code>&nbsp;argument representing the React event will be passed as a second argument after the ID. With an arrow function, we have to pass it explicitly, but with&nbsp;<code class=\"gatsby-code-text\">bind</code>&nbsp;any further arguments are automatically forwarded.</p>\n" +
                    "</div>");
            sec5React1.setLesson(reactJsLesson1);
            reactJsLesson1.getSections().add(sec5React1);

                        Section sec1React2 = new Section();
            sec1React2.setOrdinalNumber(1);
            sec1React2.setDescription("Accessibility");
            sec1React2.setContent("<div class=\"css-7u1i3w\">\n" +
                    "<h2 id=\"why-accessibility\">Why Accessibility?</h2>\n" +
                    "<p>Web accessibility (also referred to as&nbsp;<a href=\"https://en.wiktionary.org/wiki/a11y\"><strong>a11y</strong></a>) is the design and creation of websites that can be used by everyone. Accessibility support is necessary to allow assistive technology to interpret web pages.</p>\n" +
                    "<p>React fully supports building accessible websites, often by using standard HTML techniques.</p>\n" +
                    "<h2 id=\"standards-and-guidelines\">Standards and Guidelines</h2>\n" +
                    "<h3 id=\"wcag\">WCAG</h3>\n" +
                    "<p>The&nbsp;<a href=\"https://www.w3.org/WAI/intro/wcag\">Web Content Accessibility Guidelines</a>&nbsp;provides guidelines for creating accessible web sites.</p>\n" +
                    "<p>The following WCAG checklists provide an overview:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"https://www.wuhcag.com/wcag-checklist/\">WCAG checklist from Wuhcag</a></li>\n" +
                    "<li><a href=\"http://webaim.org/standards/wcag/checklist\">WCAG checklist from WebAIM</a></li>\n" +
                    "<li><a href=\"http://a11yproject.com/checklist.html\">Checklist from The A11Y Project</a></li>\n" +
                    "</ul>\n" +
                    "<h3 id=\"wai-aria\">WAI-ARIA</h3>\n" +
                    "<p>The&nbsp;<a href=\"https://www.w3.org/WAI/intro/aria\">Web Accessibility Initiative - Accessible Rich Internet Applications</a>&nbsp;document contains techniques for building fully accessible JavaScript widgets.</p>\n" +
                    "<p>Note that all&nbsp;<code class=\"gatsby-code-text\">aria-*</code>&nbsp;HTML attributes are fully supported in JSX. Whereas most DOM properties and attributes in React are camelCased, these attributes should be hyphen-cased (also known as kebab-case, lisp-case, etc) as they are in plain HTML:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>input\n" +
                    "  <span class=\"token attr-name\">type</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>text<span class=\"token punctuation\">\"</span></span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token attr-name\">aria-label</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>labelText<span class=\"token punctuation\">}</span></span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token attr-name\">aria-required</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>true<span class=\"token punctuation\">\"</span></span>\n" +
                    "</span>  <span class=\"token attr-name\">onChange</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>onchangeHandler<span class=\"token punctuation\">}</span></span>\n" +
                    "  <span class=\"token attr-name\">value</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>inputValue<span class=\"token punctuation\">}</span></span>\n" +
                    "  <span class=\"token attr-name\">name</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>name<span class=\"token punctuation\">\"</span></span>\n" +
                    "<span class=\"token punctuation\">/&gt;</span></span></code></pre>\n" +
                    "</div>\n" +
                    "<h2 id=\"semantic-html\">Semantic HTML</h2>\n" +
                    "<p>Semantic HTML is the foundation of accessibility in a web application. Using the various HTML elements to reinforce the meaning of information in our websites will often give us accessibility for free.</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"https://developer.mozilla.org/en-US/docs/Web/HTML/Element\">MDN HTML elements reference</a></li>\n" +
                    "</ul>\n" +
                    "<p>Sometimes we break HTML semantics when we add&nbsp;<code class=\"gatsby-code-text\">&lt;div&gt;</code>&nbsp;elements to our JSX to make our React code work, especially when working with lists (<code class=\"gatsby-code-text\">&lt;ol&gt;</code>,&nbsp;<code class=\"gatsby-code-text\">&lt;ul&gt;</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">&lt;dl&gt;</code>) and the HTML&nbsp;<code class=\"gatsby-code-text\">&lt;table&gt;</code>. In these cases we should rather use&nbsp;<a href=\"https://reactjs.org/docs/fragments.html\">React Fragments</a>&nbsp;to group together multiple elements.</p>\n" +
                    "<p>For example,</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"gatsby-highlight-code-line\"><span class=\"token keyword\">import</span> React<span class=\"token punctuation\">,</span> <span class=\"token punctuation\">{</span> Fragment <span class=\"token punctuation\">}</span> <span class=\"token keyword\">from</span> <span class=\"token string\">'react'</span><span class=\"token punctuation\">;</span>\n" +
                    "</span>\n" +
                    "<span class=\"token keyword\">function</span> <span class=\"token function\">ListItem</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">{</span> item <span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Fragment<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span>      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>dt<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">{</span>item<span class=\"token punctuation\">.</span>term<span class=\"token punctuation\">}</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>dt<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>dd<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">{</span>item<span class=\"token punctuation\">.</span>description<span class=\"token punctuation\">}</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>dd<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>Fragment<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span>  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"token keyword\">function</span> <span class=\"token function\">Glossary</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>dl<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>items<span class=\"token punctuation\">.</span><span class=\"token function\">map</span><span class=\"token punctuation\">(</span>item <span class=\"token operator\">=&gt;</span> <span class=\"token punctuation\">(</span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>ListItem <span class=\"token attr-name\">item</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>item<span class=\"token punctuation\">}</span></span> <span class=\"token attr-name\">key</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>item<span class=\"token punctuation\">.</span>id<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "      <span class=\"token punctuation\">)</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>dl<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>You can map a collection of items to an array of fragments as you would any other type of element as well:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">Glossary</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>dl<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>items<span class=\"token punctuation\">.</span><span class=\"token function\">map</span><span class=\"token punctuation\">(</span>item <span class=\"token operator\">=&gt;</span> <span class=\"token punctuation\">(</span>\n" +
                    "        <span class=\"token comment\">// Fragments should also have a `key` prop when mapping collections</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Fragment <span class=\"token attr-name\">key</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>item<span class=\"token punctuation\">.</span>id<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span>          <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>dt<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">{</span>item<span class=\"token punctuation\">.</span>term<span class=\"token punctuation\">}</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>dt<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "          <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>dd<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">{</span>item<span class=\"token punctuation\">.</span>description<span class=\"token punctuation\">}</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>dd<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">        <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>Fragment<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span>      <span class=\"token punctuation\">)</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>dl<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>When you don&rsquo;t need any props on the Fragment tag you can use the&nbsp;<a href=\"https://reactjs.org/docs/fragments.html#short-syntax\">short syntax</a>, if your tooling supports it:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">ListItem</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">{</span> item <span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span>      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>dt<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">{</span>item<span class=\"token punctuation\">.</span>term<span class=\"token punctuation\">}</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>dt<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>dd<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">{</span>item<span class=\"token punctuation\">.</span>description<span class=\"token punctuation\">}</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>dd<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span>  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>For more info, see&nbsp;<a href=\"https://reactjs.org/docs/fragments.html\">the Fragments documentation</a>.</p>\n" +
                    "<h2 id=\"accessible-forms\">Accessible Forms</h2>\n" +
                    "<h3 id=\"labeling\">Labeling</h3>\n" +
                    "<p>Every HTML form control, such as&nbsp;<code class=\"gatsby-code-text\">&lt;input&gt;</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">&lt;textarea&gt;</code>, needs to be labeled accessibly. We need to provide descriptive labels that are also exposed to screen readers.</p>\n" +
                    "<p>The following resources show us how to do this:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"https://www.w3.org/WAI/tutorials/forms/labels/\">The W3C shows us how to label elements</a></li>\n" +
                    "<li><a href=\"http://webaim.org/techniques/forms/controls\">WebAIM shows us how to label elements</a></li>\n" +
                    "<li><a href=\"https://www.paciellogroup.com/blog/2017/04/what-is-an-accessible-name/\">The Paciello Group explains accessible names</a></li>\n" +
                    "</ul>\n" +
                    "<p>Although these standard HTML practices can be directly used in React, note that the&nbsp;<code class=\"gatsby-code-text\">for</code>attribute is written as&nbsp;<code class=\"gatsby-code-text\">htmlFor</code>&nbsp;in JSX:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"gatsby-highlight-code-line\"><span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>label <span class=\"token attr-name\">htmlFor</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>namedInput<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Name:</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>label<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>input <span class=\"token attr-name\">id</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>namedInput<span class=\"token punctuation\">\"</span></span> <span class=\"token attr-name\">type</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>text<span class=\"token punctuation\">\"</span></span> <span class=\"token attr-name\">name</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>name<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">/&gt;</span></span></code></pre>\n" +
                    "</div>\n" +
                    "<h3 id=\"notifying-the-user-of-errors\">Notifying the user of errors</h3>\n" +
                    "<p>Error situations need to be understood by all users. The following link shows us how to expose error texts to screen readers as well:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"https://www.w3.org/WAI/tutorials/forms/notifications/\">The W3C demonstrates user notifications</a></li>\n" +
                    "<li><a href=\"http://webaim.org/techniques/formvalidation/\">WebAIM looks at form validation</a></li>\n" +
                    "</ul>\n" +
                    "<h2 id=\"focus-control\">Focus Control</h2>\n" +
                    "<p>Ensure that your web application can be fully operated with the keyboard only:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"http://webaim.org/techniques/keyboard/\">WebAIM talks about keyboard accessibility</a></li>\n" +
                    "</ul>\n" +
                    "<h3 id=\"keyboard-focus-and-focus-outline\">Keyboard focus and focus outline</h3>\n" +
                    "<p>Keyboard focus refers to the current element in the DOM that is selected to accept input from the keyboard. We see it everywhere as a focus outline similar to that shown in the following image:</p>\n" +
                    "<a class=\"gatsby-resp-image-link\" href=\"https://reactjs.org/static/keyboard-focus-dec0e6bcc1f882baf76ebc860d4f04e5-9d63d.png\" target=\"_blank\" rel=\"noopener\"><span class=\"gatsby-resp-image-wrapper\"><span class=\"gatsby-resp-image-background-image\"><img class=\"gatsby-resp-image-image\" title=\"\" src=\"https://reactjs.org/static/keyboard-focus-dec0e6bcc1f882baf76ebc860d4f04e5-9d63d.png\" sizes=\"(max-width: 146px) 100vw, 146px\" srcset=\"/static/keyboard-focus-dec0e6bcc1f882baf76ebc860d4f04e5-9d63d.png 146w\" alt=\"Blue keyboard focus outline around a selected link.\" /></span></span></a>\n" +
                    "<p>Only ever use CSS that removes this outline, for example by setting&nbsp;<code class=\"gatsby-code-text\">outline: 0</code>, if you are replacing it with another focus outline implementation.</p>\n" +
                    "<h3 id=\"mechanisms-to-skip-to-desired-content\">Mechanisms to skip to desired content</h3>\n" +
                    "<p>Provide a mechanism to allow users to skip past navigation sections in your application as this assists and speeds up keyboard navigation.</p>\n" +
                    "<p>Skiplinks or Skip Navigation Links are hidden navigation links that only become visible when keyboard users interact with the page. They are very easy to implement with internal page anchors and some styling:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"http://webaim.org/techniques/skipnav/\">WebAIM - Skip Navigation Links</a></li>\n" +
                    "</ul>\n" +
                    "<p>Also use landmark elements and roles, such as&nbsp;<code class=\"gatsby-code-text\">&lt;main&gt;</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">&lt;aside&gt;</code>, to demarcate page regions as assistive technology allow the user to quickly navigate to these sections.</p>\n" +
                    "<p>Read more about the use of these elements to enhance accessibility here:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"http://www.scottohara.me/blog/2018/03/03/landmarks.html\">Accessible Landmarks</a></li>\n" +
                    "</ul>\n" +
                    "<h3 id=\"programmatically-managing-focus\">Programmatically managing focus</h3>\n" +
                    "<p>Our React applications continuously modify the HTML DOM during runtime, sometimes leading to keyboard focus being lost or set to an unexpected element. In order to repair this, we need to programmatically nudge the keyboard focus in the right direction. For example, by resetting keyboard focus to a button that opened a modal window after that modal window is closed.</p>\n" +
                    "<p>MDN Web Docs takes a look at this and describes how we can build&nbsp;<a href=\"https://developer.mozilla.org/en-US/docs/Web/Accessibility/Keyboard-navigable_JavaScript_widgets\">keyboard-navigable JavaScript widgets</a>.</p>\n" +
                    "<p>To set focus in React, we can use&nbsp;<a href=\"https://reactjs.org/docs/refs-and-the-dom.html\">Refs to DOM elements</a>.</p>\n" +
                    "<p>Using this, we first create a ref to an element in the JSX of a component class:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">class</span> <span class=\"token class-name\">CustomTextInput</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">constructor</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">super</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token comment\">// Create a ref to store the textInput DOM element</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>textInput <span class=\"token operator\">=</span> React<span class=\"token punctuation\">.</span><span class=\"token function\">createRef</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span>  <span class=\"token punctuation\">}</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// Use the `ref` callback to store a reference to the text input DOM</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// element in an instance field (for example, this.textInput).</span>\n" +
                    "</span>    <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>input\n" +
                    "        <span class=\"token attr-name\">type</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>text<span class=\"token punctuation\">\"</span></span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">        <span class=\"token attr-name\">ref</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>textInput<span class=\"token punctuation\">}</span></span>\n" +
                    "</span>      <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "    <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Then we can focus it elsewhere in our component when needed:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token function\">focus</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token comment\">// Explicitly focus the text input using the raw DOM API</span>\n" +
                    "  <span class=\"token comment\">// Note: we're accessing \"current\" to get the DOM node</span>\n" +
                    "  <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>textInput<span class=\"token punctuation\">.</span>current<span class=\"token punctuation\">.</span><span class=\"token function\">focus</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Sometimes a parent component needs to set focus to an element in a child component. We can do this by&nbsp;<a href=\"https://reactjs.org/docs/refs-and-the-dom.html#exposing-dom-refs-to-parent-components\">exposing DOM refs to parent components</a>&nbsp;through a special prop on the child component that forwards the parent&rsquo;s ref to the child&rsquo;s DOM node.</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">CustomTextInput</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>input <span class=\"token attr-name\">ref</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>inputRef<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "</span>    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"token keyword\">class</span> <span class=\"token class-name\">Parent</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">constructor</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">super</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>inputElement <span class=\"token operator\">=</span> React<span class=\"token punctuation\">.</span><span class=\"token function\">createRef</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span>  <span class=\"token punctuation\">}</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>CustomTextInput <span class=\"token attr-name\">inputRef</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>inputElement<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "</span>    <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"token comment\">// Now you can set focus when required.</span>\n" +
                    "<span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>inputElement<span class=\"token punctuation\">.</span>current<span class=\"token punctuation\">.</span><span class=\"token function\">focus</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>When using a HOC to extend components, it is recommended to&nbsp;<a href=\"https://reactjs.org/docs/forwarding-refs.html\">forward the ref</a>&nbsp;to the wrapped component using the&nbsp;<code class=\"gatsby-code-text\">forwardRef</code>&nbsp;function of React. If a third party HOC does not implement ref forwarding, the above pattern can still be used as a fallback.</p>\n" +
                    "<p>A great focus management example is the&nbsp;<a href=\"https://github.com/davidtheclark/react-aria-modal\">react-aria-modal</a>. This is a relatively rare example of a fully accessible modal window. Not only does it set initial focus on the cancel button (preventing the keyboard user from accidentally activating the success action) and trap keyboard focus inside the modal, it also resets focus back to the element that initially triggered the modal.</p>\n" +
                    "<blockquote>\n" +
                    "<p>Note:</p>\n" +
                    "<p>While this is a very important accessibility feature, it is also a technique that should be used judiciously. Use it to repair the keyboard focus flow when it is disturbed, not to try and anticipate how users want to use applications.</p>\n" +
                    "</blockquote>\n" +
                    "<h2 id=\"mouse-and-pointer-events\">Mouse and pointer events</h2>\n" +
                    "<p>Ensure that all functionality exposed through a mouse or pointer event can also be accessed using the keyboard alone. Depending only on the pointer device will lead to many cases where keyboard users cannot use your application.</p>\n" +
                    "<p>To illustrate this, let&rsquo;s look at a prolific example of broken accessibility caused by click events. This is the outside click pattern, where a user can disable an opened popover by clicking outside the element.</p>\n" +
                    "<img src=\"https://reactjs.org/outerclick-with-mouse-5523b05b22210c5a2fa0bd1f01339cb3.gif\" alt=\"A toggle button opening a popover list implemented with the click outside pattern and operated with a mouse showing that the close action works.\" />\n" +
                    "<p>This is typically implemented by attaching a&nbsp;<code class=\"gatsby-code-text\">click</code>&nbsp;event to the&nbsp;<code class=\"gatsby-code-text\">window</code>&nbsp;object that closes the popover:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">class</span> <span class=\"token class-name\">OuterClickExample</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"token function\">constructor</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">super</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state <span class=\"token operator\">=</span> <span class=\"token punctuation\">{</span> isOpen<span class=\"token punctuation\">:</span> <span class=\"token boolean\">false</span> <span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>toggleContainer <span class=\"token operator\">=</span> React<span class=\"token punctuation\">.</span><span class=\"token function\">createRef</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>onClickHandler <span class=\"token operator\">=</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>onClickHandler<span class=\"token punctuation\">.</span><span class=\"token function\">bind</span><span class=\"token punctuation\">(</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>onClickOutsideHandler <span class=\"token operator\">=</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>onClickOutsideHandler<span class=\"token punctuation\">.</span><span class=\"token function\">bind</span><span class=\"token punctuation\">(</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token function\">componentDidMount</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    window<span class=\"token punctuation\">.</span><span class=\"token function\">addEventListener</span><span class=\"token punctuation\">(</span><span class=\"token string\">'click'</span><span class=\"token punctuation\">,</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>onClickOutsideHandler<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token punctuation\">}</span>\n" +
                    "</span>\n" +
                    "  <span class=\"token function\">componentWillUnmount</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    window<span class=\"token punctuation\">.</span><span class=\"token function\">removeEventListener</span><span class=\"token punctuation\">(</span><span class=\"token string\">'click'</span><span class=\"token punctuation\">,</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>onClickOutsideHandler<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "  <span class=\"token function\">onClickHandler</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">setState</span><span class=\"token punctuation\">(</span>currentState <span class=\"token operator\">=&gt;</span> <span class=\"token punctuation\">(</span><span class=\"token punctuation\">{</span>\n" +
                    "      isOpen<span class=\"token punctuation\">:</span> <span class=\"token operator\">!</span>currentState<span class=\"token punctuation\">.</span>isOpen\n" +
                    "    <span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token function\">onClickOutsideHandler</span><span class=\"token punctuation\">(</span>event<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">if</span> <span class=\"token punctuation\">(</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state<span class=\"token punctuation\">.</span>isOpen <span class=\"token operator\">&amp;&amp;</span> <span class=\"token operator\">!</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>toggleContainer<span class=\"token punctuation\">.</span>current<span class=\"token punctuation\">.</span><span class=\"token function\">contains</span><span class=\"token punctuation\">(</span>event<span class=\"token punctuation\">.</span>target<span class=\"token punctuation\">)</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">setState</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">{</span> isOpen<span class=\"token punctuation\">:</span> <span class=\"token boolean\">false</span> <span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token punctuation\">}</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token punctuation\">}</span>\n" +
                    "</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">ref</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>toggleContainer<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>button <span class=\"token attr-name\">onClick</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>onClickHandler<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Select an option</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>button<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state<span class=\"token punctuation\">.</span>isOpen <span class=\"token operator\">?</span> <span class=\"token punctuation\">(</span>\n" +
                    "          <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>ul<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "            <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>li<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Option 1</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>li<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "            <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>li<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Option 2</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>li<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "            <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>li<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Option 3</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>li<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "          <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>ul<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token punctuation\">)</span> <span class=\"token punctuation\">:</span> <span class=\"token keyword\">null</span><span class=\"token punctuation\">}</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>This may work fine for users with pointer devices, such as a mouse, but operating this with the keyboard alone leads to broken functionality when tabbing to the next element as the&nbsp;<code class=\"gatsby-code-text\">window</code>object never receives a&nbsp;<code class=\"gatsby-code-text\">click</code>&nbsp;event. This can lead to obscured functionality which blocks users from using your application.</p>\n" +
                    "<img src=\"https://reactjs.org/outerclick-with-keyboard-eca0ca825c8c5e2aa609cee72ef47e27.gif\" alt=\"A toggle button opening a popover list implemented with the click outside pattern and operated with the keyboard showing the popover not being closed on blur and it obscuring other screen elements.\" />\n" +
                    "<p>The same functionality can be achieved by using an appropriate event handlers instead, such as&nbsp;<code class=\"gatsby-code-text\">onBlur</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">onFocus</code>:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">class</span> <span class=\"token class-name\">BlurExample</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">constructor</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">super</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state <span class=\"token operator\">=</span> <span class=\"token punctuation\">{</span> isOpen<span class=\"token punctuation\">:</span> <span class=\"token boolean\">false</span> <span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>timeOutId <span class=\"token operator\">=</span> <span class=\"token keyword\">null</span><span class=\"token punctuation\">;</span>\n" +
                    "\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>onClickHandler <span class=\"token operator\">=</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>onClickHandler<span class=\"token punctuation\">.</span><span class=\"token function\">bind</span><span class=\"token punctuation\">(</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>onBlurHandler <span class=\"token operator\">=</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>onBlurHandler<span class=\"token punctuation\">.</span><span class=\"token function\">bind</span><span class=\"token punctuation\">(</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>onFocusHandler <span class=\"token operator\">=</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>onFocusHandler<span class=\"token punctuation\">.</span><span class=\"token function\">bind</span><span class=\"token punctuation\">(</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "  <span class=\"token function\">onClickHandler</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">setState</span><span class=\"token punctuation\">(</span>currentState <span class=\"token operator\">=&gt;</span> <span class=\"token punctuation\">(</span><span class=\"token punctuation\">{</span>\n" +
                    "      isOpen<span class=\"token punctuation\">:</span> <span class=\"token operator\">!</span>currentState<span class=\"token punctuation\">.</span>isOpen\n" +
                    "    <span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// We close the popover on the next tick by using setTimeout.</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// This is necessary because we need to first check if</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// another child of the element has received focus as</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// the blur event fires prior to the new focus event.</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token function\">onBlurHandler</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>timeOutId <span class=\"token operator\">=</span> <span class=\"token function\">setTimeout</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token operator\">=&gt;</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">setState</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">        isOpen<span class=\"token punctuation\">:</span> <span class=\"token boolean\">false</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token punctuation\">}</span>\n" +
                    "</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// If a child receives focus, do not close the popover.</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token function\">onFocusHandler</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token function\">clearTimeout</span><span class=\"token punctuation\">(</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>timeOutId<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token punctuation\">}</span>\n" +
                    "</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token comment\">// React assists us by bubbling the blur and</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token comment\">// focus events to the parent.</span>\n" +
                    "</span>    <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">onBlur</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>onBlurHandler<span class=\"token punctuation\">}</span></span>\n" +
                    "</span>           <span class=\"token attr-name\">onFocus</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>onFocusHandler<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span>\n" +
                    "</span>        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>button <span class=\"token attr-name\">onClick</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>onClickHandler<span class=\"token punctuation\">}</span></span>\n" +
                    "                <span class=\"token attr-name\">aria-haspopup</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>true<span class=\"token punctuation\">\"</span></span>\n" +
                    "                <span class=\"token attr-name\">aria-expanded</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state<span class=\"token punctuation\">.</span>isOpen<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"token plain-text\">          Select an option</span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>button<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state<span class=\"token punctuation\">.</span>isOpen <span class=\"token operator\">?</span> <span class=\"token punctuation\">(</span>\n" +
                    "          <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>ul<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "            <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>li<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Option 1</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>li<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "            <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>li<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Option 2</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>li<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "            <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>li<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Option 3</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>li<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "          <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>ul<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token punctuation\">)</span> <span class=\"token punctuation\">:</span> <span class=\"token keyword\">null</span><span class=\"token punctuation\">}</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>This code exposes the functionality to both pointer device and keyboard users. Also note the added&nbsp;<code class=\"gatsby-code-text\">aria-*</code>&nbsp;props to support screen-reader users. For simplicity&rsquo;s sake the keyboard events to enable&nbsp;<code class=\"gatsby-code-text\">arrow key</code>&nbsp;interaction of the popover options have not been implemented.</p>\n" +
                    "<img src=\"https://reactjs.org/blur-popover-close-28ce2067489843caf05fe7ce22494542.gif\" alt=\"A popover list correctly closing for both mouse and keyboard users.\" />\n" +
                    "<p>This is one example of many cases where depending on only pointer and mouse events will break functionality for keyboard users. Always testing with the keyboard will immediately highlight the problem areas which can then be fixed by using keyboard aware event handlers.</p>\n" +
                    "<h2 id=\"more-complex-widgets\">More Complex Widgets</h2>\n" +
                    "<p>A more complex user experience should not mean a less accessible one. Whereas accessibility is most easily achieved by coding as close to HTML as possible, even the most complex widget can be coded accessibly.</p>\n" +
                    "<p>Here we require knowledge of&nbsp;<a href=\"https://www.w3.org/TR/wai-aria/#roles\">ARIA Roles</a>&nbsp;as well as&nbsp;<a href=\"https://www.w3.org/TR/wai-aria/#states_and_properties\">ARIA States and Properties</a>. These are toolboxes filled with HTML attributes that are fully supported in JSX and enable us to construct fully accessible, highly functional React components.</p>\n" +
                    "<p>Each type of widget has a specific design pattern and is expected to function in a certain way by users and user agents alike:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"https://www.w3.org/TR/wai-aria-practices/#aria_ex\">WAI-ARIA Authoring Practices - Design Patterns and Widgets</a></li>\n" +
                    "<li><a href=\"http://heydonworks.com/practical_aria_examples/\">Heydon Pickering - ARIA Examples</a></li>\n" +
                    "<li><a href=\"https://inclusive-components.design/\">Inclusive Components</a></li>\n" +
                    "</ul>\n" +
                    "<h2 id=\"other-points-for-consideration\">Other Points for Consideration</h2>\n" +
                    "<h3 id=\"setting-the-language\">Setting the language</h3>\n" +
                    "<p>Indicate the human language of page texts as screen reader software uses this to select the correct voice settings:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"http://webaim.org/techniques/screenreader/#language\">WebAIM - Document Language</a></li>\n" +
                    "</ul>\n" +
                    "<h3 id=\"setting-the-document-title\">Setting the document title</h3>\n" +
                    "<p>Set the document&nbsp;<code class=\"gatsby-code-text\">&lt;title&gt;</code>&nbsp;to correctly describe the current page content as this ensures that the user remains aware of the current page context:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"https://www.w3.org/TR/UNDERSTANDING-WCAG20/navigation-mechanisms-title.html\">WCAG - Understanding the Document Title Requirement</a></li>\n" +
                    "</ul>\n" +
                    "<p>We can set this in React using the&nbsp;<a href=\"https://github.com/gaearon/react-document-title\">React Document Title Component</a>.</p>\n" +
                    "<h3 id=\"color-contrast\">Color contrast</h3>\n" +
                    "<p>Ensure that all readable text on your website has sufficient color contrast to remain maximally readable by users with low vision:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"https://www.w3.org/TR/UNDERSTANDING-WCAG20/visual-audio-contrast-contrast.html\">WCAG - Understanding the Color Contrast Requirement</a></li>\n" +
                    "<li><a href=\"https://www.smashingmagazine.com/2014/10/color-contrast-tips-and-tools-for-accessibility/\">Everything About Color Contrast And Why You Should Rethink It</a></li>\n" +
                    "<li><a href=\"http://a11yproject.com/posts/what-is-color-contrast/\">A11yProject - What is Color Contrast</a></li>\n" +
                    "</ul>\n" +
                    "<p>It can be tedious to manually calculate the proper color combinations for all cases in your website so instead, you can&nbsp;<a href=\"http://jxnblk.com/colorable/\">calculate an entire accessible color palette with Colorable</a>.</p>\n" +
                    "<p>Both the aXe and WAVE tools mentioned below also include color contrast tests and will report on contrast errors.</p>\n" +
                    "<p>If you want to extend your contrast testing abilities you can use these tools:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"http://webaim.org/resources/contrastchecker/\">WebAIM - Color Contrast Checker</a></li>\n" +
                    "<li><a href=\"https://www.paciellogroup.com/resources/contrastanalyser/\">The Paciello Group - Color Contrast Analyzer</a></li>\n" +
                    "</ul>\n" +
                    "<h2 id=\"development-and-testing-tools\">Development and Testing Tools</h2>\n" +
                    "<p>There are a number of tools we can use to assist in the creation of accessible web applications.</p>\n" +
                    "<h3 id=\"the-keyboard\">The keyboard</h3>\n" +
                    "<p>By far the easiest and also one of the most important checks is to test if your entire website can be reached and used with the keyboard alone. Do this by:</p>\n" +
                    "<ol>\n" +
                    "<li>Plugging out your mouse.</li>\n" +
                    "<li>Using&nbsp;<code class=\"gatsby-code-text\">Tab</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">Shift+Tab</code>&nbsp;to browse.</li>\n" +
                    "<li>Using&nbsp;<code class=\"gatsby-code-text\">Enter</code>&nbsp;to activate elements.</li>\n" +
                    "<li>Where required, using your keyboard arrow keys to interact with some elements, such as menus and dropdowns.</li>\n" +
                    "</ol>\n" +
                    "<h3 id=\"development-assistance\">Development assistance</h3>\n" +
                    "<p>We can check some accessibility features directly in our JSX code. Often intellisense checks are already provided in JSX aware IDE&rsquo;s for the ARIA roles, states and properties. We also have access to the following tool:</p>\n" +
                    "<h4 id=\"eslint-plugin-jsx-a11y\">eslint-plugin-jsx-a11y</h4>\n" +
                    "<p>The&nbsp;<a href=\"https://github.com/evcohen/eslint-plugin-jsx-a11y\">eslint-plugin-jsx-a11y</a>&nbsp;plugin for ESLint provides AST linting feedback regarding accessibility issues in your JSX. Many IDE&rsquo;s allow you to integrate these findings directly into code analysis and source code windows.</p>\n" +
                    "<p><a href=\"https://github.com/facebookincubator/create-react-app\">Create React App</a>&nbsp;has this plugin with a subset of rules activated. If you want to enable even more accessibility rules, you can create an&nbsp;<code class=\"gatsby-code-text\">.eslintrc</code>&nbsp;file in the root of your project with this content:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsxon\">\n" +
                    "<pre class=\"gatsby-code-jsxon\"><code class=\"gatsby-code-jsxon\">{\n" +
                    "  \"extends\": [\"react-app\", \"plugin:jsx-a11y/recommended\"],\n" +
                    "  \"plugins\": [\"jsx-a11y\"]\n" +
                    "}</code></pre>\n" +
                    "</div>\n" +
                    "<h3 id=\"testing-accessibility-in-the-browser\">Testing accessibility in the browser</h3>\n" +
                    "<p>A number of tools exist that can run accessibility audits on web pages in your browser. Please use them in combination with other accessibility checks mentioned here as they can only test the technical accessibility of your HTML.</p>\n" +
                    "<h4 id=\"axe-axe-core-and-react-axe\">aXe, aXe-core and react-axe</h4>\n" +
                    "<p>Deque Systems offers&nbsp;<a href=\"https://github.com/dequelabs/axe-core\">aXe-core</a>&nbsp;for automated and end-to-end accessibility tests of your applications. This module includes integrations for Selenium.</p>\n" +
                    "<p><a href=\"https://www.deque.com/products/axe/\">The Accessibility Engine</a>&nbsp;or aXe, is an accessibility inspector browser extension built on&nbsp;<code class=\"gatsby-code-text\">aXe-core</code>.</p>\n" +
                    "<p>You can also use the&nbsp;<a href=\"https://github.com/dylanb/react-axe\">react-axe</a>&nbsp;module to report these accessibility findings directly to the console while developing and debugging.</p>\n" +
                    "<h4 id=\"webaim-wave\">WebAIM WAVE</h4>\n" +
                    "<p>The&nbsp;<a href=\"http://wave.webaim.org/extension/\">Web Accessibility Evaluation Tool</a>&nbsp;is another accessibility browser extension.</p>\n" +
                    "<h4 id=\"accessibility-inspectors-and-the-accessibility-tree\">Accessibility inspectors and the Accessibility Tree</h4>\n" +
                    "<p><a href=\"https://www.paciellogroup.com/blog/2015/01/the-browser-accessibility-tree/\">The Accessibility Tree</a>&nbsp;is a subset of the DOM tree that contains accessible objects for every DOM element that should be exposed to assistive technology, such as screen readers.</p>\n" +
                    "<p>In some browsers we can easily view the accessibility information for each element in the accessibility tree:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"https://gist.github.com/marcysutton/0a42f815878c159517a55e6652e3b23a\">Activate the Accessibility Inspector in Chrome</a></li>\n" +
                    "<li><a href=\"https://developer.apple.com/library/content/documentation/Accessibility/Conceptual/AccessibilityMacOSX/OSXAXTestingApps.html\">Using the Accessibility Inspector in OS X Safari</a></li>\n" +
                    "</ul>\n" +
                    "<h3 id=\"screen-readers\">Screen readers</h3>\n" +
                    "<p>Testing with a screen reader should form part of your accessibility tests.</p>\n" +
                    "<p>Please note that browser / screen reader combinations matter. It is recommended that you test your application in the browser best suited to your screen reader of choice.</p>\n" +
                    "<h3 id=\"commonly-used-screen-readers\">Commonly Used Screen Readers</h3>\n" +
                    "<h4 id=\"nvda-in-firefox\">NVDA in Firefox</h4>\n" +
                    "<p><a href=\"https://www.nvaccess.org/\">NonVisual Desktop Access</a>&nbsp;or NVDA is an open source Windows screen reader that is widely used.</p>\n" +
                    "<p>Refer to the following guides on how to best use NVDA:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"http://webaim.org/articles/nvda/\">WebAIM - Using NVDA to Evaluate Web Accessibility</a></li>\n" +
                    "<li><a href=\"https://dequeuniversity.com/screenreaders/nvda-keyboard-shortcuts\">Deque - NVDA Keyboard Shortcuts</a></li>\n" +
                    "</ul>\n" +
                    "<h4 id=\"voiceover-in-safari\">VoiceOver in Safari</h4>\n" +
                    "<p>VoiceOver is an integrated screen reader on Apple devices.</p>\n" +
                    "<p>Refer to the following guides on how activate and use VoiceOver:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"http://webaim.org/articles/voiceover/\">WebAIM - Using VoiceOver to Evaluate Web Accessibility</a></li>\n" +
                    "<li><a href=\"https://dequeuniversity.com/screenreaders/voiceover-keyboard-shortcuts\">Deque - VoiceOver for OS X Keyboard Shortcuts</a></li>\n" +
                    "<li><a href=\"https://dequeuniversity.com/screenreaders/voiceover-ios-shortcuts\">Deque - VoiceOver for iOS Shortcuts</a></li>\n" +
                    "</ul>\n" +
                    "<h4 id=\"jaws-in-internet-explorer\">JAWS in Internet Explorer</h4>\n" +
                    "<p><a href=\"http://www.freedomscientific.com/Products/Blindness/JAWS\">Job Access With Speech</a>&nbsp;or JAWS, is a prolifically used screen reader on Windows.</p>\n" +
                    "<p>Refer to the following guides on how to best use JAWS:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"http://webaim.org/articles/jaws/\">WebAIM - Using JAWS to Evaluate Web Accessibility</a></li>\n" +
                    "<li><a href=\"https://dequeuniversity.com/screenreaders/jaws-keyboard-shortcuts\">Deque - JAWS Keyboard Shortcuts</a></li>\n" +
                    "</ul>\n" +
                    "<h3 id=\"other-screen-readers\">Other Screen Readers</h3>\n" +
                    "<h4 id=\"chromevox-in-google-chrome\">ChromeVox in Google Chrome</h4>\n" +
                    "<p><a href=\"http://www.chromevox.com/\">ChromeVox</a>&nbsp;is an integrated screen reader on Chromebooks and is available&nbsp;<a href=\"https://chrome.google.com/webstore/detail/chromevox/kgejglhpjiefppelpmljglcjbhoiplfn?hl=en\">as an extension</a>&nbsp;for Google Chrome.</p>\n" +
                    "<p>Refer to the following guides on how best to use ChromeVox:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"https://support.google.com/chromebook/answer/7031755?hl=en\">Google Chromebook Help - Use the Built-in Screen Reader</a></li>\n" +
                    "<li><a href=\"http://www.chromevox.com/keyboard_shortcuts.html\">ChromeVox Classic Keyboard Shortcuts Reference</a></li>\n" +
                    "</ul>\n" +
                    "</div>");
            sec1React2.setLesson(reactJsLesson2);
            reactJsLesson2.getSections().add(sec1React2);

            Section sec2React2 = new Section();
            sec2React2.setOrdinalNumber(2);
            sec2React2.setDescription("Context");
            sec2React2.setContent("<p>Context is designed to share data that can be considered &ldquo;global&rdquo; for a tree of React components, such as the current authenticated user, theme, or preferred language. For example, in the code below we manually thread through a &ldquo;theme&rdquo; prop in order to style the Button component:</p>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<div class=\"gatsby-highlight\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code><span class=\"token keyword\">class</span> <span class=\"token class-name\">App</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Toolbar <span class=\"token attr-name\">theme</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>dark<span class=\"token punctuation\">\"</span></span> <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"token keyword\">function</span> <span class=\"token function\">Toolbar</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// The Toolbar component must take an extra \"theme\" prop</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// and pass it to the ThemedButton. This can become painful</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// if every single button in the app needs to know the theme</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// because it would have to be passed through all components.</span>\n" +
                    "</span>  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>ThemedButton <span class=\"token attr-name\">theme</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>theme<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "</span>    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"token keyword\">class</span> <span class=\"token class-name\">ThemedButton</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Button <span class=\"token attr-name\">theme</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>props<span class=\"token punctuation\">.</span>theme<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<p>Using context, we can avoid passing props through intermediate elements:</p>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<div class=\"gatsby-highlight\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code><span class=\"gatsby-highlight-code-line\"><span class=\"token comment\">// Context lets us pass a value deep into the component tree</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\"><span class=\"token comment\">// without explicitly threading it through every component.</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\"><span class=\"token comment\">// Create a context for the current theme (with \"light\" as the default).</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\"><span class=\"token keyword\">const</span> ThemeContext <span class=\"token operator\">=</span> React<span class=\"token punctuation\">.</span><span class=\"token function\">createContext</span><span class=\"token punctuation\">(</span><span class=\"token string\">'light'</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span>\n" +
                    "<span class=\"token keyword\">class</span> <span class=\"token class-name\">App</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token comment\">// Use a Provider to pass the current theme to the tree below.</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token comment\">// Any component can read it, no matter how deep it is.</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token comment\">// In this example, we're passing \"dark\" as the current value.</span>\n" +
                    "</span>    <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>ThemeContext.Provider <span class=\"token attr-name\">value</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>dark<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span>        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Toolbar <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>ThemeContext.Provider<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"gatsby-highlight-code-line\"><span class=\"token comment\">// A component in the middle doesn't have to</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\"><span class=\"token comment\">// pass the theme down explicitly anymore.</span>\n" +
                    "</span><span class=\"token keyword\">function</span> <span class=\"token function\">Toolbar</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>ThemedButton <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"token keyword\">class</span> <span class=\"token class-name\">ThemedButton</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// Assign a contextType to read the current theme context.</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// React will find the closest theme Provider above and use its value.</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// In this example, the current theme is \"dark\".</span>\n" +
                    "</span>  <span class=\"token keyword\">static</span> contextType <span class=\"token operator\">=</span> ThemeContext<span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Button <span class=\"token attr-name\">theme</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>context<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "</span>  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<h2 id=\"before-you-use-context\">Before You Use Context</h2>\n" +
                    "<p>Context is primarily used when some data needs to be accessible by&nbsp;<em>many</em>&nbsp;components at different nesting levels. Apply it sparingly because it makes component reuse more difficult.</p>\n" +
                    "<p><strong>If you only want to avoid passing some props through many levels,&nbsp;<a href=\"https://reactjs.org/docs/composition-vs-inheritance.html\">component composition</a>&nbsp;is often a simpler solution than context.</strong></p>\n" +
                    "<p>For example, consider a&nbsp;<code class=\"gatsby-code-text\">Page</code>&nbsp;component that passes a&nbsp;<code class=\"gatsby-code-text\">user</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">avatarSize</code>&nbsp;prop several levels down so that deeply nested&nbsp;<code class=\"gatsby-code-text\">Link</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">Avatar</code>&nbsp;components can read it:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Page <span class=\"token attr-name\">user</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>user<span class=\"token punctuation\">}</span></span> <span class=\"token attr-name\">avatarSize</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>avatarSize<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "<span class=\"token comment\">// ... which renders ...</span>\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>PageLayout <span class=\"token attr-name\">user</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>user<span class=\"token punctuation\">}</span></span> <span class=\"token attr-name\">avatarSize</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>avatarSize<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "<span class=\"token comment\">// ... which renders ...</span>\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>NavigationBar <span class=\"token attr-name\">user</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>user<span class=\"token punctuation\">}</span></span> <span class=\"token attr-name\">avatarSize</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>avatarSize<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "<span class=\"token comment\">// ... which renders ...</span>\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Link <span class=\"token attr-name\">href</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>user<span class=\"token punctuation\">.</span>permalink<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Avatar <span class=\"token attr-name\">user</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>user<span class=\"token punctuation\">}</span></span> <span class=\"token attr-name\">size</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>avatarSize<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>Link<span class=\"token punctuation\">&gt;</span></span></code></pre>\n" +
                    "</div>\n" +
                    "<p>It might feel redundant to pass down the&nbsp;<code class=\"gatsby-code-text\">user</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">avatarSize</code>&nbsp;props through many levels if in the end only the&nbsp;<code class=\"gatsby-code-text\">Avatar</code>&nbsp;component really needs it. It&rsquo;s also annoying that whenever the&nbsp;<code class=\"gatsby-code-text\">Avatar</code>&nbsp;component needs more props from the top, you have to add them at all the intermediate levels too.</p>\n" +
                    "<p>One way to solve this issue&nbsp;<strong>without context</strong>&nbsp;is to&nbsp;<a href=\"https://reactjs.org/docs/composition-vs-inheritance.html#containment\">pass down the&nbsp;<code class=\"gatsby-code-text\">Avatar</code>&nbsp;component itself</a>&nbsp;so that the intermediate components don&rsquo;t need to know about the&nbsp;<code class=\"gatsby-code-text\">user</code>&nbsp;prop:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">Page</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">const</span> user <span class=\"token operator\">=</span> props<span class=\"token punctuation\">.</span>user<span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token keyword\">const</span> userLink <span class=\"token operator\">=</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Link <span class=\"token attr-name\">href</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>user<span class=\"token punctuation\">.</span>permalink<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Avatar <span class=\"token attr-name\">user</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>user<span class=\"token punctuation\">}</span></span> <span class=\"token attr-name\">size</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>avatarSize<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>Link<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>PageLayout <span class=\"token attr-name\">userLink</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>userLink<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"token comment\">// Now, we have:</span>\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Page <span class=\"token attr-name\">user</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>user<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "<span class=\"token comment\">// ... which renders ...</span>\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>PageLayout <span class=\"token attr-name\">userLink</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token operator\">...</span><span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "<span class=\"token comment\">// ... which renders ...</span>\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>NavigationBar <span class=\"token attr-name\">userLink</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token operator\">...</span><span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "<span class=\"token comment\">// ... which renders ...</span>\n" +
                    "<span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>userLink<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>With this change, only the top-most Page component needs to know about the&nbsp;<code class=\"gatsby-code-text\">Link</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">Avatar</code>&nbsp;components&rsquo; use of&nbsp;<code class=\"gatsby-code-text\">user</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">avatarSize</code>.</p>\n" +
                    "<p>This&nbsp;<em>inversion of control</em>&nbsp;can make your code cleaner in many cases by reducing the amount of props you need to pass through your application and giving more control to the root components. However, this isn&rsquo;t the right choice in every case: moving more complexity higher in the tree makes those higher-level components more complicated and forces the lower-level components to be more flexible than you may want.</p>\n" +
                    "<p>You&rsquo;re not limited to a single child for a component. You may pass multiple children, or even have multiple separate &ldquo;slots&rdquo; for children,&nbsp;<a href=\"https://reactjs.org/docs/composition-vs-inheritance.html#containment\">as documented here</a>:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">Page</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">const</span> user <span class=\"token operator\">=</span> props<span class=\"token punctuation\">.</span>user<span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token keyword\">const</span> content <span class=\"token operator\">=</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Feed <span class=\"token attr-name\">user</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>user<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token keyword\">const</span> topBar <span class=\"token operator\">=</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>NavigationBar<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Link <span class=\"token attr-name\">href</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>user<span class=\"token punctuation\">.</span>permalink<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "        <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Avatar <span class=\"token attr-name\">user</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>user<span class=\"token punctuation\">}</span></span> <span class=\"token attr-name\">size</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>avatarSize<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>Link<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>NavigationBar<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>PageLayout\n" +
                    "      <span class=\"token attr-name\">topBar</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>topBar<span class=\"token punctuation\">}</span></span>\n" +
                    "      <span class=\"token attr-name\">content</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>content<span class=\"token punctuation\">}</span></span>\n" +
                    "    <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>This pattern is sufficient for many cases when you need to decouple a child from its immediate parents. You can take it even further with&nbsp;<a href=\"https://reactjs.org/docs/render-props.html\">render props</a>&nbsp;if the child needs to communicate with the parent before rendering.</p>\n" +
                    "<p>However, sometimes the same data needs to be accessible by many components in the tree, and at different nesting levels. Context lets you &ldquo;broadcast&rdquo; such data, and changes to it, to all components below. Common examples where using context might be simpler than the alternatives include managing the current locale, theme, or a data cache.</p>");
            sec2React2.setLesson(reactJsLesson2);
            reactJsLesson2.getSections().add(sec2React2);

            Section sec3React2 = new Section();
            sec3React2.setOrdinalNumber(3);
            sec3React2.setDescription("Error Boundaries");
            sec3React2.setContent("<div class=\"css-7u1i3w\">\n" +
                    "<p>In the past, JavaScript errors inside components used to corrupt React&rsquo;s internal state and cause it to&nbsp;<a href=\"https://github.com/facebook/react/issues/4026\">emit</a>&nbsp;<a href=\"https://github.com/facebook/react/issues/6895\">cryptic</a>&nbsp;<a href=\"https://github.com/facebook/react/issues/8579\">errors</a>&nbsp;on next renders. These errors were always caused by an earlier error in the application code, but React did not provide a way to handle them gracefully in components, and could not recover from them.</p>\n" +
                    "<h2 id=\"introducing-error-boundaries\">Introducing Error Boundaries</h2>\n" +
                    "<p>A JavaScript error in a part of the UI shouldn&rsquo;t break the whole app. To solve this problem for React users, React 16 introduces a new concept of an &ldquo;error boundary&rdquo;.</p>\n" +
                    "<p>Error boundaries are React components that&nbsp;<strong>catch JavaScript errors anywhere in their child component tree, log those errors, and display a fallback UI</strong>&nbsp;instead of the component tree that crashed. Error boundaries catch errors during rendering, in lifecycle methods, and in constructors of the whole tree below them.</p>\n" +
                    "<blockquote>\n" +
                    "<p>Note</p>\n" +
                    "<p>Error boundaries do&nbsp;<strong>not</strong>&nbsp;catch errors for:</p>\n" +
                    "<ul>\n" +
                    "<li>Event handlers (<a href=\"https://reactjs.org/docs/error-boundaries.html#how-about-event-handlers\">learn more</a>)</li>\n" +
                    "<li>Asynchronous code (e.g.&nbsp;<code class=\"gatsby-code-text\">setTimeout</code>&nbsp;or&nbsp;<code class=\"gatsby-code-text\">requestAnimationFrame</code>&nbsp;callbacks)</li>\n" +
                    "<li>Server side rendering</li>\n" +
                    "<li>Errors thrown in the error boundary itself (rather than its children)</li>\n" +
                    "</ul>\n" +
                    "</blockquote>\n" +
                    "<p>A class component becomes an error boundary if it defines either (or both) of the lifecycle methods&nbsp;<a href=\"https://reactjs.org/docs/react-component.html#static-getderivedstatefromerror\"><code class=\"gatsby-code-text\">static getDerivedStateFromError()</code></a>&nbsp;or&nbsp;<a href=\"https://reactjs.org/docs/react-component.html#componentdidcatch\"><code class=\"gatsby-code-text\">componentDidCatch()</code></a>. Use&nbsp;<code class=\"gatsby-code-text\">static getDerivedStateFromError()</code>&nbsp;to render a fallback UI after an error has been thrown. Use&nbsp;<code class=\"gatsby-code-text\">componentDidCatch()</code>&nbsp;to log error information.</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">class</span> <span class=\"token class-name\">ErrorBoundary</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">constructor</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">super</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state <span class=\"token operator\">=</span> <span class=\"token punctuation\">{</span> hasError<span class=\"token punctuation\">:</span> <span class=\"token boolean\">false</span> <span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token keyword\">static</span> <span class=\"token function\">getDerivedStateFromError</span><span class=\"token punctuation\">(</span>error<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token comment\">// Update state so the next render will show the fallback UI.</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">return</span> <span class=\"token punctuation\">{</span> hasError<span class=\"token punctuation\">:</span> <span class=\"token boolean\">true</span> <span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token punctuation\">}</span>\n" +
                    "</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token function\">componentDidCatch</span><span class=\"token punctuation\">(</span>error<span class=\"token punctuation\">,</span> info<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token comment\">// You can also log the error to an error reporting service</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token function\">logErrorToMyService</span><span class=\"token punctuation\">(</span>error<span class=\"token punctuation\">,</span> info<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token punctuation\">}</span>\n" +
                    "</span>\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">if</span> <span class=\"token punctuation\">(</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state<span class=\"token punctuation\">.</span>hasError<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token comment\">// You can render any custom fallback UI</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Something went wrong.</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token punctuation\">}</span>\n" +
                    "</span>\n" +
                    "    <span class=\"token keyword\">return</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>props<span class=\"token punctuation\">.</span>children<span class=\"token punctuation\">;</span> \n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Then you can use it as a regular component:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>ErrorBoundary<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>MyWidget <span class=\"token punctuation\">/&gt;</span></span>\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>ErrorBoundary<span class=\"token punctuation\">&gt;</span></span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Error boundaries work like a JavaScript&nbsp;<code class=\"gatsby-code-text\">catch {}</code>&nbsp;block, but for components. Only class components can be error boundaries. In practice, most of the time you&rsquo;ll want to declare an error boundary component once and use it throughout your application.</p>\n" +
                    "<p>Note that&nbsp;<strong>error boundaries only catch errors in the components below them in the tree</strong>. An error boundary can&rsquo;t catch an error within itself. If an error boundary fails trying to render the error message, the error will propagate to the closest error boundary above it. This, too, is similar to how catch {} block works in JavaScript.</p>\n" +
                    "<h2 id=\"live-demo\">Live Demo</h2>\n" +
                    "<p>Check out&nbsp;<a href=\"https://codepen.io/gaearon/pen/wqvxGa?editors=0010\">this example of declaring and using an error boundary</a>&nbsp;with&nbsp;<a href=\"https://reactjs.org/blog/2017/09/26/react-v16.0.html\">React 16</a>.</p>\n" +
                    "<h2 id=\"where-to-place-error-boundaries\">Where to Place Error Boundaries</h2>\n" +
                    "<p>The granularity of error boundaries is up to you. You may wrap top-level route components to display a &ldquo;Something went wrong&rdquo; message to the user, just like server-side frameworks often handle crashes. You may also wrap individual widgets in an error boundary to protect them from crashing the rest of the application.</p>\n" +
                    "<h2 id=\"new-behavior-for-uncaught-errors\">New Behavior for Uncaught Errors</h2>\n" +
                    "<p>This change has an important implication.&nbsp;<strong>As of React 16, errors that were not caught by any error boundary will result in unmounting of the whole React component tree.</strong></p>\n" +
                    "<p>We debated this decision, but in our experience it is worse to leave corrupted UI in place than to completely remove it. For example, in a product like Messenger leaving the broken UI visible could lead to somebody sending a message to the wrong person. Similarly, it is worse for a payments app to display a wrong amount than to render nothing.</p>\n" +
                    "<p>This change means that as you migrate to React 16, you will likely uncover existing crashes in your application that have been unnoticed before. Adding error boundaries lets you provide better user experience when something goes wrong.</p>\n" +
                    "<p>For example, Facebook Messenger wraps content of the sidebar, the info panel, the conversation log, and the message input into separate error boundaries. If some component in one of these UI areas crashes, the rest of them remain interactive.</p>\n" +
                    "<p>We also encourage you to use JS error reporting services (or build your own) so that you can learn about unhandled exceptions as they happen in production, and fix them.</p>\n" +
                    "<h2 id=\"component-stack-traces\">Component Stack Traces</h2>\n" +
                    "<p>React 16 prints all errors that occurred during rendering to the console in development, even if the application accidentally swallows them. In addition to the error message and the JavaScript stack, it also provides component stack traces. Now you can see where exactly in the component tree the failure has happened:</p>\n" +
                    "<a class=\"gatsby-resp-image-link\" href=\"https://reactjs.org/static/error-boundaries-stack-trace-f1276837b03821b43358d44c14072945-71000.png\" target=\"_blank\" rel=\"noopener\"><span class=\"gatsby-resp-image-wrapper\"><span class=\"gatsby-resp-image-background-image\"><img class=\"gatsby-resp-image-image\" title=\"\" src=\"https://reactjs.org/static/error-boundaries-stack-trace-f1276837b03821b43358d44c14072945-acf85.png\" sizes=\"(max-width: 840px) 100vw, 840px\" srcset=\"/static/error-boundaries-stack-trace-f1276837b03821b43358d44c14072945-c1418.png 210w,\n" +
                    "/static/error-boundaries-stack-trace-f1276837b03821b43358d44c14072945-5d5d8.png 420w,\n" +
                    "/static/error-boundaries-stack-trace-f1276837b03821b43358d44c14072945-acf85.png 840w,\n" +
                    "/static/error-boundaries-stack-trace-f1276837b03821b43358d44c14072945-de0cd.png 1260w,\n" +
                    "/static/error-boundaries-stack-trace-f1276837b03821b43358d44c14072945-71000.png 1601w\" alt=\"Error caught by Error Boundary component\" /></span></span></a>\n" +
                    "<p>You can also see the filenames and line numbers in the component stack trace. This works by default in&nbsp;<a href=\"https://github.com/facebookincubator/create-react-app\">Create React App</a>&nbsp;projects:</p>\n" +
                    "<a class=\"gatsby-resp-image-link\" href=\"https://reactjs.org/static/error-boundaries-stack-trace-line-numbers-45611d4fdbd152829b28ae2348d6dcba-4e7a0.png\" target=\"_blank\" rel=\"noopener\"><span class=\"gatsby-resp-image-wrapper\"><span class=\"gatsby-resp-image-background-image\"><img class=\"gatsby-resp-image-image\" title=\"\" src=\"https://reactjs.org/static/error-boundaries-stack-trace-line-numbers-45611d4fdbd152829b28ae2348d6dcba-acf85.png\" sizes=\"(max-width: 840px) 100vw, 840px\" srcset=\"/static/error-boundaries-stack-trace-line-numbers-45611d4fdbd152829b28ae2348d6dcba-c1418.png 210w,\n" +
                    "/static/error-boundaries-stack-trace-line-numbers-45611d4fdbd152829b28ae2348d6dcba-5d5d8.png 420w,\n" +
                    "/static/error-boundaries-stack-trace-line-numbers-45611d4fdbd152829b28ae2348d6dcba-acf85.png 840w,\n" +
                    "/static/error-boundaries-stack-trace-line-numbers-45611d4fdbd152829b28ae2348d6dcba-de0cd.png 1260w,\n" +
                    "/static/error-boundaries-stack-trace-line-numbers-45611d4fdbd152829b28ae2348d6dcba-4e7a0.png 1597w\" alt=\"Error caught by Error Boundary component with line numbers\" /></span></span></a>\n" +
                    "<p>If you don&rsquo;t use Create React App, you can add&nbsp;<a href=\"https://www.npmjs.com/package/babel-plugin-transform-react-jsx-source\">this plugin</a>&nbsp;manually to your Babel configuration. Note that it&rsquo;s intended only for development and&nbsp;<strong>must be disabled in production</strong>.</p>\n" +
                    "<blockquote>\n" +
                    "<p>Note</p>\n" +
                    "<p>Component names displayed in the stack traces depend on the&nbsp;<a href=\"https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Function/name\"><code class=\"gatsby-code-text\">Function.name</code></a>&nbsp;property. If you support older browsers and devices which may not yet provide this natively (e.g. IE 11), consider including a&nbsp;<code class=\"gatsby-code-text\">Function.name</code>&nbsp;polyfill in your bundled application, such as&nbsp;<a href=\"https://github.com/JamesMGreene/Function.name\"><code class=\"gatsby-code-text\">function.name-polyfill</code></a>. Alternatively, you may explicitly set the&nbsp;<a href=\"https://reactjs.org/docs/react-component.html#displayname\"><code class=\"gatsby-code-text\">displayName</code></a>&nbsp;property on all your components.</p>\n" +
                    "</blockquote>\n" +
                    "<h2 id=\"how-about-trycatch\">How About try/catch?</h2>\n" +
                    "<p><code class=\"gatsby-code-text\">try</code>&nbsp;/&nbsp;<code class=\"gatsby-code-text\">catch</code>&nbsp;is great but it only works for imperative code:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">try</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">showButton</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span> <span class=\"token keyword\">catch</span> <span class=\"token punctuation\">(</span><span class=\"token class-name\">error</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token comment\">// ...</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>However, React components are declarative and specify&nbsp;<em>what</em>&nbsp;should be rendered:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Button <span class=\"token punctuation\">/&gt;</span></span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Error boundaries preserve the declarative nature of React, and behave as you would expect. For example, even if an error occurs in a&nbsp;<code class=\"gatsby-code-text\">componentDidUpdate</code>&nbsp;method caused by a&nbsp;<code class=\"gatsby-code-text\">setState</code>somewhere deep in the tree, it will still correctly propagate to the closest error boundary.</p>\n" +
                    "<h2 id=\"how-about-event-handlers\">How About Event Handlers?</h2>\n" +
                    "<p>Error boundaries&nbsp;<strong>do not</strong>&nbsp;catch errors inside event handlers.</p>\n" +
                    "<p>React doesn&rsquo;t need error boundaries to recover from errors in event handlers. Unlike the render method and lifecycle methods, the event handlers don&rsquo;t happen during rendering. So if they throw, React still knows what to display on the screen.</p>\n" +
                    "<p>If you need to catch an error inside event handler, use the regular JavaScript&nbsp;<code class=\"gatsby-code-text\">try</code>&nbsp;/&nbsp;<code class=\"gatsby-code-text\">catch</code>statement:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">class</span> <span class=\"token class-name\">MyComponent</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">constructor</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">super</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state <span class=\"token operator\">=</span> <span class=\"token punctuation\">{</span> error<span class=\"token punctuation\">:</span> <span class=\"token keyword\">null</span> <span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "    <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>handleClick <span class=\"token operator\">=</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>handleClick<span class=\"token punctuation\">.</span><span class=\"token function\">bind</span><span class=\"token punctuation\">(</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "  <span class=\"token function\">handleClick</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">try</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token comment\">// Do something that could throw</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token punctuation\">}</span> <span class=\"token keyword\">catch</span> <span class=\"token punctuation\">(</span><span class=\"token class-name\">error</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">setState</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">{</span> error <span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token punctuation\">}</span>\n" +
                    "</span>  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "  <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">if</span> <span class=\"token punctuation\">(</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>state<span class=\"token punctuation\">.</span>error<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">      <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>h1<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Caught an error.</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>h1<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token punctuation\">}</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">onClick</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>handleClick<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Click Me</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span>  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Note that the above example is demonstrating regular JavaScript behavior and doesn&rsquo;t use error boundaries.</p>\n" +
                    "<h2 id=\"naming-changes-from-react-15\">Naming Changes from React 15</h2>\n" +
                    "<p>React 15 included a very limited support for error boundaries under a different method name:&nbsp;<code class=\"gatsby-code-text\">unstable_handleError</code>. This method no longer works, and you will need to change it to&nbsp;<code class=\"gatsby-code-text\">componentDidCatch</code>&nbsp;in your code starting from the first 16 beta release.</p>\n" +
                    "<p>For this change, we&rsquo;ve provided a&nbsp;<a href=\"https://github.com/reactjs/react-codemod#error-boundaries\">codemod</a>&nbsp;to automatically migrate your code.</p>\n" +
                    "</div>");
            sec3React2.setLesson(reactJsLesson2);
            reactJsLesson2.getSections().add(sec3React2);

            Section sec4React2 = new Section();
            sec4React2.setOrdinalNumber(4);
            sec4React2.setDescription("Forwarding Refs");
            sec4React2.setContent("<div class=\"css-7u1i3w\">\n" +
                    "<p>Ref forwarding is a technique for automatically passing a&nbsp;<a href=\"https://reactjs.org/docs/refs-and-the-dom.html\">ref</a>&nbsp;through a component to one of its children. This is typically not necessary for most components in the application. However, it can be useful for some kinds of components, especially in reusable component libraries. The most common scenarios are described below.</p>\n" +
                    "<h2 id=\"forwarding-refs-to-dom-components\">Forwarding refs to DOM components</h2>\n" +
                    "<p>Consider a&nbsp;<code class=\"gatsby-code-text\">FancyButton</code>&nbsp;component that renders the native&nbsp;<code class=\"gatsby-code-text\">button</code>&nbsp;DOM element:</p>\n" +
                    "<div class=\"gatsby-highlight\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code><span class=\"token keyword\">function</span> <span class=\"token function\">FancyButton</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>button <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>FancyButton<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>children<span class=\"token punctuation\">}</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>button<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<p>React components hide their implementation details, including their rendered output. Other components using&nbsp;<code class=\"gatsby-code-text\">FancyButton</code>&nbsp;<strong>usually will not need to</strong>&nbsp;<a href=\"https://reactjs.org/docs/refs-and-the-dom.html\">obtain a ref</a>&nbsp;to the inner&nbsp;<code class=\"gatsby-code-text\">button</code>DOM element. This is good because it prevents components from relying on each other&rsquo;s DOM structure too much.</p>\n" +
                    "<p>Although such encapsulation is desirable for application-level components like&nbsp;<code class=\"gatsby-code-text\">FeedStory</code>&nbsp;or&nbsp;<code class=\"gatsby-code-text\">Comment</code>, it can be inconvenient for highly reusable &ldquo;leaf&rdquo; components like&nbsp;<code class=\"gatsby-code-text\">FancyButton</code>&nbsp;or&nbsp;<code class=\"gatsby-code-text\">MyTextInput</code>. These components tend to be used throughout the application in a similar manner as a regular DOM&nbsp;<code class=\"gatsby-code-text\">button</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">input</code>, and accessing their DOM nodes may be unavoidable for managing focus, selection, or animations.</p>\n" +
                    "<p><strong>Ref forwarding is an opt-in feature that lets some components take a&nbsp;<code class=\"gatsby-code-text\">ref</code>&nbsp;they receive, and pass it further down (in other words, &ldquo;forward&rdquo; it) to a child.</strong></p>\n" +
                    "<p>In the example below,&nbsp;<code class=\"gatsby-code-text\">FancyButton</code>&nbsp;uses&nbsp;<code class=\"gatsby-code-text\">React.forwardRef</code>&nbsp;to obtain the&nbsp;<code class=\"gatsby-code-text\">ref</code>&nbsp;passed to it, and then forward it to the DOM&nbsp;<code class=\"gatsby-code-text\">button</code>&nbsp;that it renders:</p>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<div class=\"gatsby-highlight\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code><span class=\"gatsby-highlight-code-line\"><span class=\"token keyword\">const</span> FancyButton <span class=\"token operator\">=</span> React<span class=\"token punctuation\">.</span><span class=\"token function\">forwardRef</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">,</span> ref<span class=\"token punctuation\">)</span> <span class=\"token operator\">=&gt;</span> <span class=\"token punctuation\">(</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>button <span class=\"token attr-name\">ref</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>ref<span class=\"token punctuation\">}</span></span> <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>FancyButton<span class=\"token punctuation\">\"</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "</span>    <span class=\"token punctuation\">{</span>props<span class=\"token punctuation\">.</span>children<span class=\"token punctuation\">}</span>\n" +
                    "  <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>button<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"token punctuation\">)</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "\n" +
                    "<span class=\"token comment\">// You can now get a ref directly to the DOM button:</span>\n" +
                    "<span class=\"token keyword\">const</span> ref <span class=\"token operator\">=</span> React<span class=\"token punctuation\">.</span><span class=\"token function\">createRef</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>FancyButton <span class=\"token attr-name\">ref</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>ref<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Click me!</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>FancyButton<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<p>This way, components using&nbsp;<code class=\"gatsby-code-text\">FancyButton</code>&nbsp;can get a ref to the underlying&nbsp;<code class=\"gatsby-code-text\">button</code>&nbsp;DOM node and access it if necessary&mdash;just like if they used a DOM&nbsp;<code class=\"gatsby-code-text\">button</code>&nbsp;directly.</p>\n" +
                    "<p>Here is a step-by-step explanation of what happens in the above example:</p>\n" +
                    "<ol>\n" +
                    "<li>We create a&nbsp;<a href=\"https://reactjs.org/docs/refs-and-the-dom.html\">React ref</a>&nbsp;by calling&nbsp;<code class=\"gatsby-code-text\">React.createRef</code>&nbsp;and assign it to a&nbsp;<code class=\"gatsby-code-text\">ref</code>&nbsp;variable.</li>\n" +
                    "<li>We pass our&nbsp;<code class=\"gatsby-code-text\">ref</code>&nbsp;down to&nbsp;<code class=\"gatsby-code-text\">&lt;FancyButton ref={ref}&gt;</code>&nbsp;by specifying it as a JSX attribute.</li>\n" +
                    "<li>React passes the&nbsp;<code class=\"gatsby-code-text\">ref</code>&nbsp;to the&nbsp;<code class=\"gatsby-code-text\">(props, ref) =&gt; ...</code>&nbsp;function inside&nbsp;<code class=\"gatsby-code-text\">forwardRef</code>&nbsp;as a second argument.</li>\n" +
                    "<li>We forward this&nbsp;<code class=\"gatsby-code-text\">ref</code>&nbsp;argument down to&nbsp;<code class=\"gatsby-code-text\">&lt;button ref={ref}&gt;</code>&nbsp;by specifying it as a JSX attribute.</li>\n" +
                    "<li>When the ref is attached,&nbsp;<code class=\"gatsby-code-text\">ref.current</code>&nbsp;will point to the&nbsp;<code class=\"gatsby-code-text\">&lt;button&gt;</code>&nbsp;DOM node.</li>\n" +
                    "</ol>\n" +
                    "<blockquote>\n" +
                    "<p>Note</p>\n" +
                    "<p>The second&nbsp;<code class=\"gatsby-code-text\">ref</code>&nbsp;argument only exists when you define a component with&nbsp;<code class=\"gatsby-code-text\">React.forwardRef</code>call. Regular function or class components don&rsquo;t receive the&nbsp;<code class=\"gatsby-code-text\">ref</code>&nbsp;argument, and ref is not available in props either.</p>\n" +
                    "<p>Ref forwarding is not limited to DOM components. You can forward refs to class component instances, too.</p>\n" +
                    "</blockquote>\n" +
                    "<h2 id=\"note-for-component-library-maintainers\">Note for component library maintainers</h2>\n" +
                    "<p><strong>When you start using&nbsp;<code class=\"gatsby-code-text\">forwardRef</code>&nbsp;in a component library, you should treat it as a breaking change and release a new major version of your library.</strong>&nbsp;This is because your library likely has an observably different behavior (such as what refs get assigned to, and what types are exported), and this can break apps and other libraries that depend on the old behavior.</p>\n" +
                    "<p>Conditionally applying&nbsp;<code class=\"gatsby-code-text\">React.forwardRef</code>&nbsp;when it exists is also not recommended for the same reasons: it changes how your library behaves and can break your users&rsquo; apps when they upgrade React itself.</p>\n" +
                    "<h2 id=\"forwarding-refs-in-higher-order-components\">Forwarding refs in higher-order components</h2>\n" +
                    "<p>This technique can also be particularly useful with&nbsp;<a href=\"https://reactjs.org/docs/higher-order-components.html\">higher-order components</a>&nbsp;(also known as HOCs). Let&rsquo;s start with an example HOC that logs component props to the console:</p>\n" +
                    "<div class=\"gatsby-highlight\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code><span class=\"gatsby-highlight-code-line\"><span class=\"token keyword\">function</span> <span class=\"token function\">logProps</span><span class=\"token punctuation\">(</span>WrappedComponent<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span>  <span class=\"token keyword\">class</span> <span class=\"token class-name\">LogProps</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token function\">componentDidUpdate</span><span class=\"token punctuation\">(</span>prevProps<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "      console<span class=\"token punctuation\">.</span><span class=\"token function\">log</span><span class=\"token punctuation\">(</span><span class=\"token string\">'old props:'</span><span class=\"token punctuation\">,</span> prevProps<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "      console<span class=\"token punctuation\">.</span><span class=\"token function\">log</span><span class=\"token punctuation\">(</span><span class=\"token string\">'new props:'</span><span class=\"token punctuation\">,</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>props<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "    <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "    <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">      <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>WrappedComponent <span class=\"token spread\"><span class=\"token punctuation\">{</span><span class=\"token punctuation\">...</span><span class=\"token attr-value\">this</span><span class=\"token punctuation\">.</span><span class=\"token attr-value\">props</span><span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "</span>    <span class=\"token punctuation\">}</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "  <span class=\"token keyword\">return</span> LogProps<span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<p>The &ldquo;logProps&rdquo;&nbsp;HOC passes all&nbsp;<code class=\"gatsby-code-text\">props</code>&nbsp;through to the component it wraps, so the rendered output will be the same. For example, we can use this HOC to log all props that get passed to our &ldquo;fancy button&rdquo; component:</p>\n" +
                    "<div class=\"gatsby-highlight\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code><span class=\"token keyword\">class</span> <span class=\"token class-name\">FancyButton</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token function\">focus</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token comment\">// ...</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "  <span class=\"token comment\">// ...</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"token comment\">// Rather than exporting FancyButton, we export LogProps.</span>\n" +
                    "<span class=\"token comment\">// It will render a FancyButton though.</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\"><span class=\"token keyword\">export</span> <span class=\"token keyword\">default</span> <span class=\"token function\">logProps</span><span class=\"token punctuation\">(</span>FancyButton<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<p>There is one caveat to the above example: refs will not get passed through. That&rsquo;s because&nbsp;<code class=\"gatsby-code-text\">ref</code>is not a prop. Like&nbsp;<code class=\"gatsby-code-text\">key</code>, it&rsquo;s handled differently by React. If you add a ref to a HOC, the ref will refer to the outermost container component, not the wrapped component.</p>\n" +
                    "<p>This means that refs intended for our&nbsp;<code class=\"gatsby-code-text\">FancyButton</code>&nbsp;component will actually be attached to the&nbsp;<code class=\"gatsby-code-text\">LogProps</code>&nbsp;component:</p>\n" +
                    "<div class=\"gatsby-highlight\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code><span class=\"token keyword\">import</span> FancyButton <span class=\"token keyword\">from</span> <span class=\"token string\">'./FancyButton'</span><span class=\"token punctuation\">;</span>\n" +
                    "\n" +
                    "<span class=\"gatsby-highlight-code-line\"><span class=\"token keyword\">const</span> ref <span class=\"token operator\">=</span> React<span class=\"token punctuation\">.</span><span class=\"token function\">createRef</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span>\n" +
                    "<span class=\"token comment\">// The FancyButton component we imported is the LogProps HOC.</span>\n" +
                    "<span class=\"token comment\">// Even though the rendered output will be the same,</span>\n" +
                    "<span class=\"token comment\">// Our ref will point to LogProps instead of the inner FancyButton component!</span>\n" +
                    "<span class=\"token comment\">// This means we can't call e.g. ref.current.focus()</span>\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>FancyButton\n" +
                    "  <span class=\"token attr-name\">label</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Click Me<span class=\"token punctuation\">\"</span></span>\n" +
                    "  <span class=\"token attr-name\">handleClick</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>handleClick<span class=\"token punctuation\">}</span></span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token attr-name\">ref</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>ref<span class=\"token punctuation\">}</span></span>\n" +
                    "</span><span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<p>Fortunately, we can explicitly forward refs to the inner&nbsp;<code class=\"gatsby-code-text\">FancyButton</code>&nbsp;component using the&nbsp;<code class=\"gatsby-code-text\">React.forwardRef</code>&nbsp;API.&nbsp;<code class=\"gatsby-code-text\">React.forwardRef</code>&nbsp;accepts a render function that receives&nbsp;<code class=\"gatsby-code-text\">props</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">ref</code>&nbsp;parameters and returns a React node. For example:</p>\n" +
                    "<div class=\"gatsby-highlight\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code><span class=\"token keyword\">function</span> <span class=\"token function\">logProps</span><span class=\"token punctuation\">(</span>Component<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">class</span> <span class=\"token class-name\">LogProps</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token function\">componentDidUpdate</span><span class=\"token punctuation\">(</span>prevProps<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "      console<span class=\"token punctuation\">.</span><span class=\"token function\">log</span><span class=\"token punctuation\">(</span><span class=\"token string\">'old props:'</span><span class=\"token punctuation\">,</span> prevProps<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "      console<span class=\"token punctuation\">.</span><span class=\"token function\">log</span><span class=\"token punctuation\">(</span><span class=\"token string\">'new props:'</span><span class=\"token punctuation\">,</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>props<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "    <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "    <span class=\"token function\">render</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">      <span class=\"token keyword\">const</span> <span class=\"token punctuation\">{</span>forwardedRef<span class=\"token punctuation\">,</span> <span class=\"token operator\">...</span>rest<span class=\"token punctuation\">}</span> <span class=\"token operator\">=</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>props<span class=\"token punctuation\">;</span>\n" +
                    "</span>\n" +
                    "      <span class=\"token comment\">// Assign the custom prop \"forwardedRef\" as a ref</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">      <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>Component <span class=\"token attr-name\">ref</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>forwardedRef<span class=\"token punctuation\">}</span></span> <span class=\"token spread\"><span class=\"token punctuation\">{</span><span class=\"token punctuation\">...</span><span class=\"token attr-value\">rest</span><span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "</span>    <span class=\"token punctuation\">}</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "  <span class=\"token comment\">// Note the second param \"ref\" provided by React.forwardRef.</span>\n" +
                    "  <span class=\"token comment\">// We can pass it along to LogProps as a regular prop, e.g. \"forwardedRef\"</span>\n" +
                    "  <span class=\"token comment\">// And it can then be attached to the Component.</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token keyword\">return</span> React<span class=\"token punctuation\">.</span><span class=\"token function\">forwardRef</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">,</span> ref<span class=\"token punctuation\">)</span> <span class=\"token operator\">=&gt;</span> <span class=\"token punctuation\">{</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">    <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>LogProps <span class=\"token spread\"><span class=\"token punctuation\">{</span><span class=\"token punctuation\">...</span><span class=\"token attr-value\">props</span><span class=\"token punctuation\">}</span></span> <span class=\"token attr-name\">forwardedRef</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>ref<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<h2 id=\"displaying-a-custom-name-in-devtools\">Displaying a custom name in DevTools</h2>\n" +
                    "<p><code class=\"gatsby-code-text\">React.forwardRef</code>&nbsp;accepts a render function. React DevTools uses this function to determine what to display for the ref forwarding component.</p>\n" +
                    "<p>For example, the following component will appear as &rdquo;<em>ForwardRef</em>&rdquo; in the DevTools:</p>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<div class=\"gatsby-highlight\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code><span class=\"token keyword\">const</span> WrappedComponent <span class=\"token operator\">=</span> React<span class=\"token punctuation\">.</span><span class=\"token function\">forwardRef</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">,</span> ref<span class=\"token punctuation\">)</span> <span class=\"token operator\">=&gt;</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>LogProps <span class=\"token spread\"><span class=\"token punctuation\">{</span><span class=\"token punctuation\">...</span><span class=\"token attr-value\">props</span><span class=\"token punctuation\">}</span></span> <span class=\"token attr-name\">forwardedRef</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>ref<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<p>If you name the render function, DevTools will also include its name (e.g. &rdquo;<em>ForwardRef(myFunction)</em>&rdquo;):</p>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<div class=\"gatsby-highlight\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code><span class=\"token keyword\">const</span> WrappedComponent <span class=\"token operator\">=</span> React<span class=\"token punctuation\">.</span><span class=\"token function\">forwardRef</span><span class=\"token punctuation\">(</span>\n" +
                    "  <span class=\"token keyword\">function</span> <span class=\"token function\">myFunction</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">,</span> ref<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>LogProps <span class=\"token spread\"><span class=\"token punctuation\">{</span><span class=\"token punctuation\">...</span><span class=\"token attr-value\">props</span><span class=\"token punctuation\">}</span></span> <span class=\"token attr-name\">forwardedRef</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>ref<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<p>You can even set the function&rsquo;s&nbsp;<code class=\"gatsby-code-text\">displayName</code>&nbsp;property to include the component you&rsquo;re wrapping:</p>\n" +
                    "<p>&nbsp;</p>\n" +
                    "<div class=\"gatsby-highlight\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code><span class=\"token keyword\">function</span> <span class=\"token function\">logProps</span><span class=\"token punctuation\">(</span>Component<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">class</span> <span class=\"token class-name\">LogProps</span> <span class=\"token keyword\">extends</span> <span class=\"token class-name\">React<span class=\"token punctuation\">.</span>Component</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token comment\">// ...</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "  <span class=\"token keyword\">function</span> <span class=\"token function\">forwardRef</span><span class=\"token punctuation\">(</span>props<span class=\"token punctuation\">,</span> ref<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>LogProps <span class=\"token spread\"><span class=\"token punctuation\">{</span><span class=\"token punctuation\">...</span><span class=\"token attr-value\">props</span><span class=\"token punctuation\">}</span></span> <span class=\"token attr-name\">forwardedRef</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>ref<span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "  <span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "  <span class=\"token comment\">// Give this component a more helpful display name in DevTools.</span>\n" +
                    "  <span class=\"token comment\">// e.g. \"ForwardRef(logProps(MyComponent))\"</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token keyword\">const</span> name <span class=\"token operator\">=</span> Component<span class=\"token punctuation\">.</span>displayName <span class=\"token operator\">||</span> Component<span class=\"token punctuation\">.</span>name<span class=\"token punctuation\">;</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  forwardRef<span class=\"token punctuation\">.</span>displayName <span class=\"token operator\">=</span> <span class=\"token template-string\"><span class=\"token string\">`logProps(</span><span class=\"token interpolation\"><span class=\"token interpolation-punctuation punctuation\">${</span>name<span class=\"token interpolation-punctuation punctuation\">}</span></span><span class=\"token string\">)`</span></span><span class=\"token punctuation\">;</span>\n" +
                    "</span>\n" +
                    "  <span class=\"token keyword\">return</span> React<span class=\"token punctuation\">.</span><span class=\"token function\">forwardRef</span><span class=\"token punctuation\">(</span>forwardRef<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>&nbsp;</p>\n" +
                    "</div>");
            sec4React2.setLesson(reactJsLesson2);
            reactJsLesson2.getSections().add(sec4React2);

                        Section sec1React3 = new Section();
            sec1React3.setOrdinalNumber(1);
            sec1React3.setDescription("ReactDOM");
            sec1React3.setContent("<div class=\"css-7u1i3w\">\n" +
                    "<h2 id=\"overview\">Overview</h2>\n" +
                    "<p>The&nbsp;<code class=\"gatsby-code-text\">react-dom</code>&nbsp;package provides DOM-specific methods that can be used at the top level of your app and as an escape hatch to get outside of the React model if you need to. Most of your components should not need to use this module.</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"https://reactjs.org/docs/react-dom.html#render\"><code class=\"gatsby-code-text\">render()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/react-dom.html#hydrate\"><code class=\"gatsby-code-text\">hydrate()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/react-dom.html#unmountcomponentatnode\"><code class=\"gatsby-code-text\">unmountComponentAtNode()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/react-dom.html#finddomnode\"><code class=\"gatsby-code-text\">findDOMNode()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/react-dom.html#createportal\"><code class=\"gatsby-code-text\">createPortal()</code></a></li>\n" +
                    "</ul>\n" +
                    "<h3 id=\"browser-support\">Browser Support</h3>\n" +
                    "<p>React supports all popular browsers, including Internet Explorer 9 and above, although&nbsp;<a href=\"https://reactjs.org/docs/javascript-environment-requirements.html\">some polyfills are required</a>&nbsp;for older browsers such as IE 9 and IE 10.</p>\n" +
                    "<blockquote>\n" +
                    "<p>Note</p>\n" +
                    "<p>We don&rsquo;t support older browsers that don&rsquo;t support ES5 methods, but you may find that your apps do work in older browsers if polyfills such as&nbsp;<a href=\"https://github.com/es-shims/es5-shim\">es5-shim and es5-sham</a>&nbsp;are included in the page. You&rsquo;re on your own if you choose to take this path.</p>\n" +
                    "</blockquote>\n" +
                    "<hr />\n" +
                    "<h2 id=\"reference\">Reference</h2>\n" +
                    "<h3 id=\"render\"><code class=\"gatsby-code-text\">render()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">render</span><span class=\"token punctuation\">(</span>element<span class=\"token punctuation\">,</span> container<span class=\"token punctuation\">[</span><span class=\"token punctuation\">,</span> callback<span class=\"token punctuation\">]</span><span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Render a React element into the DOM in the supplied&nbsp;<code class=\"gatsby-code-text\">container</code>&nbsp;and return a&nbsp;<a href=\"https://reactjs.org/docs/more-about-refs.html\">reference</a>&nbsp;to the component (or returns&nbsp;<code class=\"gatsby-code-text\">null</code>&nbsp;for&nbsp;<a href=\"https://reactjs.org/docs/components-and-props.html#functional-and-class-components\">stateless components</a>).</p>\n" +
                    "<p>If the React element was previously rendered into&nbsp;<code class=\"gatsby-code-text\">container</code>, this will perform an update on it and only mutate the DOM as necessary to reflect the latest React element.</p>\n" +
                    "<p>If the optional callback is provided, it will be executed after the component is rendered or updated.</p>\n" +
                    "<blockquote>\n" +
                    "<p>Note:</p>\n" +
                    "<p><code class=\"gatsby-code-text\">ReactDOM.render()</code>&nbsp;controls the contents of the container node you pass in. Any existing DOM elements inside are replaced when first called. Later calls use React&rsquo;s DOM diffing algorithm for efficient updates.</p>\n" +
                    "<p><code class=\"gatsby-code-text\">ReactDOM.render()</code>&nbsp;does not modify the container node (only modifies the children of the container). It may be possible to insert a component to an existing DOM node without overwriting the existing children.</p>\n" +
                    "<p><code class=\"gatsby-code-text\">ReactDOM.render()</code>&nbsp;currently returns a reference to the root&nbsp;<code class=\"gatsby-code-text\">ReactComponent</code>&nbsp;instance. However, using this return value is legacy and should be avoided because future versions of React may render components asynchronously in some cases. If you need a reference to the root&nbsp;<code class=\"gatsby-code-text\">ReactComponent</code>&nbsp;instance, the preferred solution is to attach a&nbsp;<a href=\"https://reactjs.org/docs/more-about-refs.html#the-ref-callback-attribute\">callback ref</a>&nbsp;to the root element.</p>\n" +
                    "<p>Using&nbsp;<code class=\"gatsby-code-text\">ReactDOM.render()</code>&nbsp;to hydrate a server-rendered container is deprecated and will be removed in React 17. Use&nbsp;<a href=\"https://reactjs.org/docs/react-dom.html#hydrate\"><code class=\"gatsby-code-text\">hydrate()</code></a>&nbsp;instead.</p>\n" +
                    "</blockquote>\n" +
                    "<hr />\n" +
                    "<h3 id=\"hydrate\"><code class=\"gatsby-code-text\">hydrate()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">hydrate</span><span class=\"token punctuation\">(</span>element<span class=\"token punctuation\">,</span> container<span class=\"token punctuation\">[</span><span class=\"token punctuation\">,</span> callback<span class=\"token punctuation\">]</span><span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Same as&nbsp;<a href=\"https://reactjs.org/docs/react-dom.html#render\"><code class=\"gatsby-code-text\">render()</code></a>, but is used to hydrate a container whose HTML contents were rendered by&nbsp;<a href=\"https://reactjs.org/docs/react-dom-server.html\"><code class=\"gatsby-code-text\">ReactDOMServer</code></a>. React will attempt to attach event listeners to the existing markup.</p>\n" +
                    "<p>React expects that the rendered content is identical between the server and the client. It can patch up differences in text content, but you should treat mismatches as bugs and fix them. In development mode, React warns about mismatches during hydration. There are no guarantees that attribute differences will be patched up in case of mismatches. This is important for performance reasons because in most apps, mismatches are rare, and so validating all markup would be prohibitively expensive.</p>\n" +
                    "<p>If a single element&rsquo;s attribute or text content is unavoidably different between the server and the client (for example, a timestamp), you may silence the warning by adding&nbsp;<code class=\"gatsby-code-text\">suppressHydrationWarning={true}</code>&nbsp;to the element. It only works one level deep, and is intended to be an escape hatch. Don&rsquo;t overuse it. Unless it&rsquo;s text content, React still won&rsquo;t attempt to patch it up, so it may remain inconsistent until future updates.</p>\n" +
                    "<p>If you intentionally need to render something different on the server and the client, you can do a two-pass rendering. Components that render something different on the client can read a state variable like&nbsp;<code class=\"gatsby-code-text\">this.state.isClient</code>, which you can set to&nbsp;<code class=\"gatsby-code-text\">true</code>&nbsp;in&nbsp;<code class=\"gatsby-code-text\">componentDidMount()</code>. This way the initial render pass will render the same content as the server, avoiding mismatches, but an additional pass will happen synchronously right after hydration. Note that this approach will make your components slower because they have to render twice, so use it with caution.</p>\n" +
                    "<p>Remember to be mindful of user experience on slow connections. The JavaScript code may load significantly later than the initial HTML render, so if you render something different in the client-only pass, the transition can be jarring. However, if executed well, it may be beneficial to render a &ldquo;shell&rdquo; of the application on the server, and only show some of the extra widgets on the client. To learn how to do this without getting the markup mismatch issues, refer to the explanation in the previous paragraph.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"unmountcomponentatnode\"><code class=\"gatsby-code-text\">unmountComponentAtNode()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">unmountComponentAtNode</span><span class=\"token punctuation\">(</span>container<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Remove a mounted React component from the DOM and clean up its event handlers and state. If no component was mounted in the container, calling this function does nothing. Returns&nbsp;<code class=\"gatsby-code-text\">true</code>&nbsp;if a component was unmounted and&nbsp;<code class=\"gatsby-code-text\">false</code>&nbsp;if there was no component to unmount.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"finddomnode\"><code class=\"gatsby-code-text\">findDOMNode()</code></h3>\n" +
                    "<blockquote>\n" +
                    "<p>Note:</p>\n" +
                    "<p><code class=\"gatsby-code-text\">findDOMNode</code>&nbsp;is an escape hatch used to access the underlying DOM node. In most cases, use of this escape hatch is discouraged because it pierces the component abstraction.&nbsp;<a href=\"https://reactjs.org/docs/strict-mode.html#warning-about-deprecated-finddomnode-usage\">It has been deprecated in&nbsp;<code class=\"gatsby-code-text\">StrictMode</code>.</a></p>\n" +
                    "</blockquote>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">findDOMNode</span><span class=\"token punctuation\">(</span>component<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>If this component has been mounted into the DOM, this returns the corresponding native browser DOM element. This method is useful for reading values out of the DOM, such as form field values and performing DOM measurements.&nbsp;<strong>In most cases, you can attach a ref to the DOM node and avoid using&nbsp;<code class=\"gatsby-code-text\">findDOMNode</code>&nbsp;at all.</strong></p>\n" +
                    "<p>When a component renders to&nbsp;<code class=\"gatsby-code-text\">null</code>&nbsp;or&nbsp;<code class=\"gatsby-code-text\">false</code>,&nbsp;<code class=\"gatsby-code-text\">findDOMNode</code>&nbsp;returns&nbsp;<code class=\"gatsby-code-text\">null</code>. When a component renders to a string,&nbsp;<code class=\"gatsby-code-text\">findDOMNode</code>&nbsp;returns a text DOM node containing that value. As of React 16, a component may return a fragment with multiple children, in which case&nbsp;<code class=\"gatsby-code-text\">findDOMNode</code>&nbsp;will return the DOM node corresponding to the first non-empty child.</p>\n" +
                    "<blockquote>\n" +
                    "<p>Note:</p>\n" +
                    "<p><code class=\"gatsby-code-text\">findDOMNode</code>&nbsp;only works on mounted components (that is, components that have been placed in the DOM). If you try to call this on a component that has not been mounted yet (like calling&nbsp;<code class=\"gatsby-code-text\">findDOMNode()</code>&nbsp;in&nbsp;<code class=\"gatsby-code-text\">render()</code>&nbsp;on a component that has yet to be created) an exception will be thrown.</p>\n" +
                    "<p><code class=\"gatsby-code-text\">findDOMNode</code>&nbsp;cannot be used on function components.</p>\n" +
                    "</blockquote>\n" +
                    "<hr />\n" +
                    "<h3 id=\"createportal\"><code class=\"gatsby-code-text\">createPortal()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">ReactDOM<span class=\"token punctuation\">.</span><span class=\"token function\">createPortal</span><span class=\"token punctuation\">(</span>child<span class=\"token punctuation\">,</span> container<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Creates a portal. Portals provide a way to&nbsp;<a href=\"https://reactjs.org/docs/portals.html\">render children into a DOM node that exists outside the hierarchy of the DOM component</a>.</p>\n" +
                    "</div>");
            sec1React3.setLesson(reactJsLesson3);
            reactJsLesson3.getSections().add(sec1React3);

            Section sec2React3 = new Section();
            sec2React3.setOrdinalNumber(2);
            sec2React3.setDescription("ReactDOMServer");
            sec2React3.setContent("<h2 id=\"overview\">Overview</h2>\n" +
                    "<p>The following methods can be used in both the server and browser environments:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"https://reactjs.org/docs/react-dom-server.html#rendertostring\"><code class=\"gatsby-code-text\">renderToString()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/react-dom-server.html#rendertostaticmarkup\"><code class=\"gatsby-code-text\">renderToStaticMarkup()</code></a></li>\n" +
                    "</ul>\n" +
                    "<p>These additional methods depend on a package (<code class=\"gatsby-code-text\">stream</code>) that is&nbsp;<strong>only available on the server</strong>, and won&rsquo;t work in the browser.</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"https://reactjs.org/docs/react-dom-server.html#rendertonodestream\"><code class=\"gatsby-code-text\">renderToNodeStream()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/react-dom-server.html#rendertostaticnodestream\"><code class=\"gatsby-code-text\">renderToStaticNodeStream()</code></a></li>\n" +
                    "</ul>\n" +
                    "<hr />\n" +
                    "<h2 id=\"reference\">Reference</h2>\n" +
                    "<h3 id=\"rendertostring\"><code class=\"gatsby-code-text\">renderToString()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">ReactDOMServer<span class=\"token punctuation\">.</span><span class=\"token function\">renderToString</span><span class=\"token punctuation\">(</span>element<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Render a React element to its initial HTML. React will return an HTML string. You can use this method to generate HTML on the server and send the markup down on the initial request for faster page loads and to allow search engines to crawl your pages for SEO purposes.</p>\n" +
                    "<p>If you call&nbsp;<a href=\"https://reactjs.org/docs/react-dom.html#hydrate\"><code class=\"gatsby-code-text\">ReactDOM.hydrate()</code></a>&nbsp;on a node that already has this server-rendered markup, React will preserve it and only attach event handlers, allowing you to have a very performant first-load experience.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"rendertostaticmarkup\"><code class=\"gatsby-code-text\">renderToStaticMarkup()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">ReactDOMServer<span class=\"token punctuation\">.</span><span class=\"token function\">renderToStaticMarkup</span><span class=\"token punctuation\">(</span>element<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Similar to&nbsp;<a href=\"https://reactjs.org/docs/react-dom-server.html#rendertostring\"><code class=\"gatsby-code-text\">renderToString</code></a>, except this doesn&rsquo;t create extra DOM attributes that React uses internally, such as&nbsp;<code class=\"gatsby-code-text\">data-reactroot</code>. This is useful if you want to use React as a simple static page generator, as stripping away the extra attributes can save some bytes.</p>\n" +
                    "<p>If you plan to use React on the client to make the markup interactive, do not use this method. Instead, use&nbsp;<a href=\"https://reactjs.org/docs/react-dom-server.html#rendertostring\"><code class=\"gatsby-code-text\">renderToString</code></a>&nbsp;on the server and&nbsp;<a href=\"https://reactjs.org/docs/react-dom.html#hydrate\"><code class=\"gatsby-code-text\">ReactDOM.hydrate()</code></a>&nbsp;on the client.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"rendertonodestream\"><code class=\"gatsby-code-text\">renderToNodeStream()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">ReactDOMServer<span class=\"token punctuation\">.</span><span class=\"token function\">renderToNodeStream</span><span class=\"token punctuation\">(</span>element<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Render a React element to its initial HTML. Returns a&nbsp;<a href=\"https://nodejs.org/api/stream.html#stream_readable_streams\">Readable stream</a>&nbsp;that outputs an HTML string. The HTML output by this stream is exactly equal to what&nbsp;<a href=\"https://reactjs.org/docs/react-dom-server.html#rendertostring\"><code class=\"gatsby-code-text\">ReactDOMServer.renderToString</code></a>&nbsp;would return. You can use this method to generate HTML on the server and send the markup down on the initial request for faster page loads and to allow search engines to crawl your pages for SEO purposes.</p>\n" +
                    "<p>If you call&nbsp;<a href=\"https://reactjs.org/docs/react-dom.html#hydrate\"><code class=\"gatsby-code-text\">ReactDOM.hydrate()</code></a>&nbsp;on a node that already has this server-rendered markup, React will preserve it and only attach event handlers, allowing you to have a very performant first-load experience.</p>\n" +
                    "<blockquote>\n" +
                    "<p>Note:</p>\n" +
                    "<p>Server-only. This API is not available in the browser.</p>\n" +
                    "<p>The stream returned from this method will return a byte stream encoded in utf-8. If you need a stream in another encoding, take a look at a project like&nbsp;<a href=\"https://www.npmjs.com/package/iconv-lite\">iconv-lite</a>, which provides transform streams for transcoding text.</p>\n" +
                    "</blockquote>\n" +
                    "<hr />\n" +
                    "<h3 id=\"rendertostaticnodestream\"><code class=\"gatsby-code-text\">renderToStaticNodeStream()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">ReactDOMServer<span class=\"token punctuation\">.</span><span class=\"token function\">renderToStaticNodeStream</span><span class=\"token punctuation\">(</span>element<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Similar to&nbsp;<a href=\"https://reactjs.org/docs/react-dom-server.html#rendertonodestream\"><code class=\"gatsby-code-text\">renderToNodeStream</code></a>, except this doesn&rsquo;t create extra DOM attributes that React uses internally, such as&nbsp;<code class=\"gatsby-code-text\">data-reactroot</code>. This is useful if you want to use React as a simple static page generator, as stripping away the extra attributes can save some bytes.</p>\n" +
                    "<p>The HTML output by this stream is exactly equal to what&nbsp;<a href=\"https://reactjs.org/docs/react-dom-server.html#rendertostaticmarkup\"><code class=\"gatsby-code-text\">ReactDOMServer.renderToStaticMarkup</code></a>&nbsp;would return.</p>\n" +
                    "<p>If you plan to use React on the client to make the markup interactive, do not use this method. Instead, use&nbsp;<a href=\"https://reactjs.org/docs/react-dom-server.html#rendertonodestream\"><code class=\"gatsby-code-text\">renderToNodeStream</code></a>&nbsp;on the server and&nbsp;<a href=\"https://reactjs.org/docs/react-dom.html#hydrate\"><code class=\"gatsby-code-text\">ReactDOM.hydrate()</code></a>&nbsp;on the client.</p>");
            sec2React3.setLesson(reactJsLesson3);
            reactJsLesson3.getSections().add(sec2React3);

            Section sec3React3 = new Section();
            sec3React3.setOrdinalNumber(3);
            sec3React3.setDescription("DOM Elements");
            sec3React3.setContent("<div class=\"css-7u1i3w\">\n" +
                    "<h2 id=\"differences-in-attributes\">Differences In Attributes</h2>\n" +
                    "<p>There are a number of attributes that work differently between React and HTML:</p>\n" +
                    "<h3 id=\"checked\">checked</h3>\n" +
                    "<p>The&nbsp;<code class=\"gatsby-code-text\">checked</code>&nbsp;attribute is supported by&nbsp;<code class=\"gatsby-code-text\">&lt;input&gt;</code>&nbsp;components of type&nbsp;<code class=\"gatsby-code-text\">checkbox</code>&nbsp;or&nbsp;<code class=\"gatsby-code-text\">radio</code>. You can use it to set whether the component is checked. This is useful for building controlled components.&nbsp;<code class=\"gatsby-code-text\">defaultChecked</code>&nbsp;is the uncontrolled equivalent, which sets whether the component is checked when it is first mounted.</p>\n" +
                    "<h3 id=\"classname\">className</h3>\n" +
                    "<p>To specify a CSS class, use the&nbsp;<code class=\"gatsby-code-text\">className</code>&nbsp;attribute. This applies to all regular DOM and SVG elements like&nbsp;<code class=\"gatsby-code-text\">&lt;div&gt;</code>,&nbsp;<code class=\"gatsby-code-text\">&lt;a&gt;</code>, and others.</p>\n" +
                    "<p>If you use React with Web Components (which is uncommon), use the&nbsp;<code class=\"gatsby-code-text\">class</code>&nbsp;attribute instead.</p>\n" +
                    "<h3 id=\"dangerouslysetinnerhtml\">dangerouslySetInnerHTML</h3>\n" +
                    "<p><code class=\"gatsby-code-text\">dangerouslySetInnerHTML</code>&nbsp;is React&rsquo;s replacement for using&nbsp;<code class=\"gatsby-code-text\">innerHTML</code>&nbsp;in the browser DOM. In general, setting HTML from code is risky because it&rsquo;s easy to inadvertently expose your users to a&nbsp;<a href=\"https://en.wikipedia.org/wiki/Cross-site_scripting\">cross-site scripting (XSS)</a>&nbsp;attack. So, you can set HTML directly from React, but you have to type out&nbsp;<code class=\"gatsby-code-text\">dangerouslySetInnerHTML</code>&nbsp;and pass an object with a&nbsp;<code class=\"gatsby-code-text\">__html</code>&nbsp;key, to remind yourself that it&rsquo;s dangerous. For example:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">createMarkup</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">{</span>__html<span class=\"token punctuation\">:</span> <span class=\"token string\">'First &amp;middot; Second'</span><span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span>\n" +
                    "\n" +
                    "<span class=\"token keyword\">function</span> <span class=\"token function\">MyComponent</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">dangerouslySetInnerHTML</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token function\">createMarkup</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<h3 id=\"htmlfor\">htmlFor</h3>\n" +
                    "<p>Since&nbsp;<code class=\"gatsby-code-text\">for</code>&nbsp;is a reserved word in JavaScript, React elements use&nbsp;<code class=\"gatsby-code-text\">htmlFor</code>&nbsp;instead.</p>\n" +
                    "<h3 id=\"onchange\">onChange</h3>\n" +
                    "<p>The&nbsp;<code class=\"gatsby-code-text\">onChange</code>&nbsp;event behaves as you would expect it to: whenever a form field is changed, this event is fired. We intentionally do not use the existing browser behavior because&nbsp;<code class=\"gatsby-code-text\">onChange</code>&nbsp;is a misnomer for its behavior and React relies on this event to handle user input in real time.</p>\n" +
                    "<h3 id=\"selected\">selected</h3>\n" +
                    "<p>The&nbsp;<code class=\"gatsby-code-text\">selected</code>&nbsp;attribute is supported by&nbsp;<code class=\"gatsby-code-text\">&lt;option&gt;</code>&nbsp;components. You can use it to set whether the component is selected. This is useful for building controlled components.</p>\n" +
                    "<h3 id=\"style\">style</h3>\n" +
                    "<blockquote>\n" +
                    "<p>Note</p>\n" +
                    "<p>Some examples in the documentation use&nbsp;<code class=\"gatsby-code-text\">style</code>&nbsp;for convenience, but&nbsp;<strong>using the&nbsp;<code class=\"gatsby-code-text\">style</code>attribute as the primary means of styling elements is generally not recommended.</strong>&nbsp;In most cases,&nbsp;<a href=\"https://reactjs.org/docs/dom-elements.html#classname\"><code class=\"gatsby-code-text\">className</code></a>&nbsp;should be used to reference classes defined in an external CSS stylesheet.&nbsp;<code class=\"gatsby-code-text\">style</code>&nbsp;is most often used in React applications to add dynamically-computed styles at render time. See also&nbsp;<a href=\"https://reactjs.org/docs/faq-styling.html\">FAQ: Styling and CSS</a>.</p>\n" +
                    "</blockquote>\n" +
                    "<p>The&nbsp;<code class=\"gatsby-code-text\">style</code>&nbsp;attribute accepts a JavaScript object with camelCased properties rather than a CSS string. This is consistent with the DOM&nbsp;<code class=\"gatsby-code-text\">style</code>&nbsp;JavaScript property, is more efficient, and prevents XSS security holes. For example:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">const</span> divStyle <span class=\"token operator\">=</span> <span class=\"token punctuation\">{</span>\n" +
                    "  color<span class=\"token punctuation\">:</span> <span class=\"token string\">'blue'</span><span class=\"token punctuation\">,</span>\n" +
                    "  backgroundImage<span class=\"token punctuation\">:</span> <span class=\"token string\">'url('</span> <span class=\"token operator\">+</span> imgUrl <span class=\"token operator\">+</span> <span class=\"token string\">')'</span><span class=\"token punctuation\">,</span>\n" +
                    "<span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "\n" +
                    "<span class=\"token keyword\">function</span> <span class=\"token function\">HelloWorldComponent</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">style</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>divStyle<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">Hello World!</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Note that styles are not autoprefixed. To support older browsers, you need to supply corresponding style properties:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">const</span> divStyle <span class=\"token operator\">=</span> <span class=\"token punctuation\">{</span>\n" +
                    "  WebkitTransition<span class=\"token punctuation\">:</span> <span class=\"token string\">'all'</span><span class=\"token punctuation\">,</span> <span class=\"token comment\">// note the capital 'W' here</span>\n" +
                    "  msTransition<span class=\"token punctuation\">:</span> <span class=\"token string\">'all'</span> <span class=\"token comment\">// 'ms' is the only lowercase vendor prefix</span>\n" +
                    "<span class=\"token punctuation\">}</span><span class=\"token punctuation\">;</span>\n" +
                    "\n" +
                    "<span class=\"token keyword\">function</span> <span class=\"token function\">ComponentWithTransition</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">style</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span>divStyle<span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">This should work cross-browser</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Style keys are camelCased in order to be consistent with accessing the properties on DOM nodes from JS (e.g.&nbsp;<code class=\"gatsby-code-text\">node.style.backgroundImage</code>). Vendor prefixes&nbsp;<a href=\"http://www.andismith.com/blog/2012/02/modernizr-prefixed/\">other than&nbsp;<code class=\"gatsby-code-text\">ms</code></a>&nbsp;should begin with a capital letter. This is why&nbsp;<code class=\"gatsby-code-text\">WebkitTransition</code>&nbsp;has an uppercase &ldquo;W&rdquo;.</p>\n" +
                    "<p>React will automatically append a &ldquo;px&rdquo; suffix to certain numeric inline style properties. If you want to use units other than &ldquo;px&rdquo;, specify the value as a string with the desired unit. For example:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token comment\">// Result style: '10px'</span>\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">style</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token punctuation\">{</span> height<span class=\"token punctuation\">:</span> <span class=\"token number\">10</span> <span class=\"token punctuation\">}</span><span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">\n" +
                    "  Hello World!\n" +
                    "</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "\n" +
                    "<span class=\"token comment\">// Result style: '10%'</span>\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">style</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token punctuation\">{</span> height<span class=\"token punctuation\">:</span> <span class=\"token string\">'10%'</span> <span class=\"token punctuation\">}</span><span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">\n" +
                    "  Hello World!\n" +
                    "</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Not all style properties are converted to pixel strings though. Certain ones remain unitless (eg&nbsp;<code class=\"gatsby-code-text\">zoom</code>,&nbsp;<code class=\"gatsby-code-text\">order</code>,&nbsp;<code class=\"gatsby-code-text\">flex</code>). A complete list of unitless properties can be seen&nbsp;<a href=\"https://github.com/facebook/react/blob/4131af3e4bf52f3a003537ec95a1655147c81270/src/renderers/dom/shared/CSSProperty.js#L15-L59\">here</a>.</p>\n" +
                    "<h3 id=\"suppresscontenteditablewarning\">suppressContentEditableWarning</h3>\n" +
                    "<p>Normally, there is a warning when an element with children is also marked as&nbsp;<code class=\"gatsby-code-text\">contentEditable</code>, because it won&rsquo;t work. This attribute suppresses that warning. Don&rsquo;t use this unless you are building a library like&nbsp;<a href=\"https://facebook.github.io/draft-js/\">Draft.js</a>&nbsp;that manages&nbsp;<code class=\"gatsby-code-text\">contentEditable</code>&nbsp;manually.</p>\n" +
                    "<h3 id=\"suppresshydrationwarning\">suppressHydrationWarning</h3>\n" +
                    "<p>If you use server-side React rendering, normally there is a warning when the server and the client render different content. However, in some rare cases, it is very hard or impossible to guarantee an exact match. For example, timestamps are expected to differ on the server and on the client.</p>\n" +
                    "<p>If you set&nbsp;<code class=\"gatsby-code-text\">suppressHydrationWarning</code>&nbsp;to&nbsp;<code class=\"gatsby-code-text\">true</code>, React will not warn you about mismatches in the attributes and the content of that element. It only works one level deep, and is intended to be used as an escape hatch. Don&rsquo;t overuse it. You can read more about hydration in the&nbsp;<a href=\"https://reactjs.org/docs/react-dom.html#hydrate\"><code class=\"gatsby-code-text\">ReactDOM.hydrate()</code>&nbsp;documentation</a>.</p>\n" +
                    "<h3 id=\"value\">value</h3>\n" +
                    "<p>The&nbsp;<code class=\"gatsby-code-text\">value</code>&nbsp;attribute is supported by&nbsp;<code class=\"gatsby-code-text\">&lt;input&gt;</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">&lt;textarea&gt;</code>&nbsp;components. You can use it to set the value of the component. This is useful for building controlled components.&nbsp;<code class=\"gatsby-code-text\">defaultValue</code>&nbsp;is the uncontrolled equivalent, which sets the value of the component when it is first mounted.</p>\n" +
                    "<h2 id=\"all-supported-html-attributes\">All Supported HTML Attributes</h2>\n" +
                    "<p>As of React 16, any standard&nbsp;<a href=\"https://reactjs.org/blog/2017/09/08/dom-attributes-in-react-16.html\">or custom</a>&nbsp;DOM attributes are fully supported.</p>\n" +
                    "<p>React has always provided a JavaScript-centric API to the DOM. Since React components often take both custom and DOM-related props, React uses the&nbsp;<code class=\"gatsby-code-text\">camelCase</code>&nbsp;convention just like the DOM APIs:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">tabIndex</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>-1<span class=\"token punctuation\">\"</span></span> <span class=\"token punctuation\">/&gt;</span></span>      <span class=\"token comment\">// Just like node.tabIndex DOM API</span>\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div <span class=\"token attr-name\">className</span><span class=\"token attr-value\"><span class=\"token punctuation\">=</span><span class=\"token punctuation\">\"</span>Button<span class=\"token punctuation\">\"</span></span> <span class=\"token punctuation\">/&gt;</span></span> <span class=\"token comment\">// Just like node.className DOM API</span>\n" +
                    "<span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>input <span class=\"token attr-name\">readOnly</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token boolean\">true</span><span class=\"token punctuation\">}</span></span> <span class=\"token punctuation\">/&gt;</span></span>  <span class=\"token comment\">// Just like node.readOnly DOM API</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>These props work similarly to the corresponding HTML attributes, with the exception of the special cases documented above.</p>\n" +
                    "<p>Some of the DOM attributes supported by React include:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">accept acceptCharset accessKey action allowFullScreen alt async autoComplete\n" +
                    "autoFocus autoPlay capture cellPadding cellSpacing challenge charSet checked\n" +
                    "cite classID className colSpan cols content contentEditable contextMenu controls\n" +
                    "controlsList coords crossOrigin data dateTime default defer dir disabled\n" +
                    "download draggable encType form formAction formEncType formMethod formNoValidate\n" +
                    "formTarget frameBorder headers height hidden high href hrefLang htmlFor\n" +
                    "httpEquiv icon id inputMode integrity is keyParams keyType kind label lang list\n" +
                    "loop low manifest marginHeight marginWidth max maxLength media mediaGroup method\n" +
                    "min minLength multiple muted name noValidate nonce open optimum pattern\n" +
                    "placeholder poster preload profile radioGroup readOnly rel required reversed\n" +
                    "role rowSpan rows sandbox scope scoped scrolling seamless selected shape size\n" +
                    "sizes span spellCheck src srcDoc srcLang srcSet start step style summary\n" +
                    "tabIndex target title type useMap value width wmode wrap</code></pre>\n" +
                    "</div>\n" +
                    "<p>Similarly, all SVG attributes are fully supported:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">accentHeight accumulate additive alignmentBaseline allowReorder alphabetic\n" +
                    "amplitude arabicForm ascent attributeName attributeType autoReverse azimuth\n" +
                    "baseFrequency baseProfile baselineShift bbox begin bias by calcMode capHeight\n" +
                    "clip clipPath clipPathUnits clipRule colorInterpolation\n" +
                    "colorInterpolationFilters colorProfile colorRendering contentScriptType\n" +
                    "contentStyleType cursor cx cy d decelerate descent diffuseConstant direction\n" +
                    "display divisor dominantBaseline dur dx dy edgeMode elevation enableBackground\n" +
                    "end exponent externalResourcesRequired fill fillOpacity fillRule filter\n" +
                    "filterRes filterUnits floodColor floodOpacity focusable fontFamily fontSize\n" +
                    "fontSizeAdjust fontStretch fontStyle fontVariant fontWeight format from fx fy\n" +
                    "g1 g2 glyphName glyphOrientationHorizontal glyphOrientationVertical glyphRef\n" +
                    "gradientTransform gradientUnits hanging horizAdvX horizOriginX ideographic\n" +
                    "imageRendering in in2 intercept k k1 k2 k3 k4 kernelMatrix kernelUnitLength\n" +
                    "kerning keyPoints keySplines keyTimes lengthAdjust letterSpacing lightingColor\n" +
                    "limitingConeAngle local markerEnd markerHeight markerMid markerStart\n" +
                    "markerUnits markerWidth mask maskContentUnits maskUnits mathematical mode\n" +
                    "numOctaves offset opacity operator order orient orientation origin overflow\n" +
                    "overlinePosition overlineThickness paintOrder panose1 pathLength\n" +
                    "patternContentUnits patternTransform patternUnits pointerEvents points\n" +
                    "pointsAtX pointsAtY pointsAtZ preserveAlpha preserveAspectRatio primitiveUnits\n" +
                    "r radius refX refY renderingIntent repeatCount repeatDur requiredExtensions\n" +
                    "requiredFeatures restart result rotate rx ry scale seed shapeRendering slope\n" +
                    "spacing specularConstant specularExponent speed spreadMethod startOffset\n" +
                    "stdDeviation stemh stemv stitchTiles stopColor stopOpacity\n" +
                    "strikethroughPosition strikethroughThickness string stroke strokeDasharray\n" +
                    "strokeDashoffset strokeLinecap strokeLinejoin strokeMiterlimit strokeOpacity\n" +
                    "strokeWidth surfaceScale systemLanguage tableValues targetX targetY textAnchor\n" +
                    "textDecoration textLength textRendering to transform u1 u2 underlinePosition\n" +
                    "underlineThickness unicode unicodeBidi unicodeRange unitsPerEm vAlphabetic\n" +
                    "vHanging vIdeographic vMathematical values vectorEffect version vertAdvY\n" +
                    "vertOriginX vertOriginY viewBox viewTarget visibility widths wordSpacing\n" +
                    "writingMode x x1 x2 xChannelSelector xHeight xlinkActuate xlinkArcrole\n" +
                    "xlinkHref xlinkRole xlinkShow xlinkTitle xlinkType xmlns xmlnsXlink xmlBase\n" +
                    "xmlLang xmlSpace y y1 y2 yChannelSelector z zoomAndPan</code></pre>\n" +
                    "</div>\n" +
                    "<p>You may also use custom attributes as long as they&rsquo;re fully lowercase.</p>\n" +
                    "</div>");
            sec3React3.setLesson(reactJsLesson3);
            reactJsLesson3.getSections().add(sec3React3);

            Section sec4React3 = new Section();
            sec4React3.setOrdinalNumber(4);
            sec4React3.setDescription("SyntheticEvent");
            sec4React3.setContent("<div class=\"css-7u1i3w\">\n" +
                    "<h2 id=\"overview\">Overview</h2>\n" +
                    "<p>Your event handlers will be passed instances of&nbsp;<code class=\"gatsby-code-text\">SyntheticEvent</code>, a cross-browser wrapper around the browser&rsquo;s native event. It has the same interface as the browser&rsquo;s native event, including&nbsp;<code class=\"gatsby-code-text\">stopPropagation()</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">preventDefault()</code>, except the events work identically across all browsers.</p>\n" +
                    "<p>If you find that you need the underlying browser event for some reason, simply use the&nbsp;<code class=\"gatsby-code-text\">nativeEvent</code>&nbsp;attribute to get it. Every&nbsp;<code class=\"gatsby-code-text\">SyntheticEvent</code>&nbsp;object has the following attributes:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">boolean bubbles\n" +
                    "boolean cancelable\n" +
                    "DOMEventTarget currentTarget\n" +
                    "boolean defaultPrevented\n" +
                    "number eventPhase\n" +
                    "boolean isTrusted\n" +
                    "DOMEvent nativeEvent\n" +
                    "<span class=\"token keyword\">void</span> <span class=\"token function\">preventDefault</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span>\n" +
                    "boolean <span class=\"token function\">isDefaultPrevented</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span>\n" +
                    "<span class=\"token keyword\">void</span> <span class=\"token function\">stopPropagation</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span>\n" +
                    "boolean <span class=\"token function\">isPropagationStopped</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span>\n" +
                    "DOMEventTarget target\n" +
                    "number timeStamp\n" +
                    "string type</code></pre>\n" +
                    "</div>\n" +
                    "<blockquote>\n" +
                    "<p>Note:</p>\n" +
                    "<p>As of v0.14, returning&nbsp;<code class=\"gatsby-code-text\">false</code>&nbsp;from an event handler will no longer stop event propagation. Instead,&nbsp;<code class=\"gatsby-code-text\">e.stopPropagation()</code>&nbsp;or&nbsp;<code class=\"gatsby-code-text\">e.preventDefault()</code>&nbsp;should be triggered manually, as appropriate.</p>\n" +
                    "</blockquote>\n" +
                    "<h3 id=\"event-pooling\">Event Pooling</h3>\n" +
                    "<p>The&nbsp;<code class=\"gatsby-code-text\">SyntheticEvent</code>&nbsp;is pooled. This means that the&nbsp;<code class=\"gatsby-code-text\">SyntheticEvent</code>&nbsp;object will be reused and all properties will be nullified after the event callback has been invoked. This is for performance reasons. As such, you cannot access the event in an asynchronous way.</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">function</span> <span class=\"token function\">onClick</span><span class=\"token punctuation\">(</span>event<span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "  console<span class=\"token punctuation\">.</span><span class=\"token function\">log</span><span class=\"token punctuation\">(</span>event<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span> <span class=\"token comment\">// =&gt; nullified object.</span>\n" +
                    "  console<span class=\"token punctuation\">.</span><span class=\"token function\">log</span><span class=\"token punctuation\">(</span>event<span class=\"token punctuation\">.</span>type<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span> <span class=\"token comment\">// =&gt; \"click\"</span>\n" +
                    "  <span class=\"token keyword\">const</span> eventType <span class=\"token operator\">=</span> event<span class=\"token punctuation\">.</span>type<span class=\"token punctuation\">;</span> <span class=\"token comment\">// =&gt; \"click\"</span>\n" +
                    "\n" +
                    "  <span class=\"token function\">setTimeout</span><span class=\"token punctuation\">(</span><span class=\"token keyword\">function</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "    console<span class=\"token punctuation\">.</span><span class=\"token function\">log</span><span class=\"token punctuation\">(</span>event<span class=\"token punctuation\">.</span>type<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span> <span class=\"token comment\">// =&gt; null</span>\n" +
                    "    console<span class=\"token punctuation\">.</span><span class=\"token function\">log</span><span class=\"token punctuation\">(</span>eventType<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span> <span class=\"token comment\">// =&gt; \"click\"</span>\n" +
                    "  <span class=\"token punctuation\">}</span><span class=\"token punctuation\">,</span> <span class=\"token number\">0</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "\n" +
                    "  <span class=\"token comment\">// Won't work. this.state.clickEvent will only contain null values.</span>\n" +
                    "  <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">setState</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">{</span>clickEvent<span class=\"token punctuation\">:</span> event<span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "\n" +
                    "  <span class=\"token comment\">// You can still export event properties.</span>\n" +
                    "  <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span><span class=\"token function\">setState</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">{</span>eventType<span class=\"token punctuation\">:</span> event<span class=\"token punctuation\">.</span>type<span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<blockquote>\n" +
                    "<p>Note:</p>\n" +
                    "<p>If you want to access the event properties in an asynchronous way, you should call&nbsp;<code class=\"gatsby-code-text\">event.persist()</code>&nbsp;on the event, which will remove the synthetic event from the pool and allow references to the event to be retained by user code.</p>\n" +
                    "</blockquote>\n" +
                    "<h2 id=\"supported-events\">Supported Events</h2>\n" +
                    "<p>React normalizes events so that they have consistent properties across different browsers.</p>\n" +
                    "<p>The event handlers below are triggered by an event in the bubbling phase. To register an event handler for the capture phase, append&nbsp;<code class=\"gatsby-code-text\">Capture</code>&nbsp;to the event name; for example, instead of using&nbsp;<code class=\"gatsby-code-text\">onClick</code>, you would use&nbsp;<code class=\"gatsby-code-text\">onClickCapture</code>&nbsp;to handle the click event in the capture phase.</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"https://reactjs.org/docs/events.html#clipboard-events\">Clipboard Events</a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/events.html#composition-events\">Composition Events</a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/events.html#keyboard-events\">Keyboard Events</a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/events.html#focus-events\">Focus Events</a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/events.html#form-events\">Form Events</a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/events.html#mouse-events\">Mouse Events</a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/events.html#pointer-events\">Pointer Events</a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/events.html#selection-events\">Selection Events</a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/events.html#touch-events\">Touch Events</a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/events.html#ui-events\">UI Events</a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/events.html#wheel-events\">Wheel Events</a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/events.html#media-events\">Media Events</a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/events.html#image-events\">Image Events</a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/events.html#animation-events\">Animation Events</a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/events.html#transition-events\">Transition Events</a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/events.html#other-events\">Other Events</a></li>\n" +
                    "</ul>\n" +
                    "<hr />\n" +
                    "<h2 id=\"reference\">Reference</h2>\n" +
                    "<h3 id=\"clipboard-events\">Clipboard Events</h3>\n" +
                    "<p>Event names:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">onCopy onCut onPaste</code></pre>\n" +
                    "</div>\n" +
                    "<p>Properties:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">DOMDataTransfer clipboardData</code></pre>\n" +
                    "</div>\n" +
                    "<hr />\n" +
                    "<h3 id=\"composition-events\">Composition Events</h3>\n" +
                    "<p>Event names:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">onCompositionEnd onCompositionStart onCompositionUpdate</code></pre>\n" +
                    "</div>\n" +
                    "<p>Properties:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">string data</code></pre>\n" +
                    "</div>\n" +
                    "<hr />\n" +
                    "<h3 id=\"keyboard-events\">Keyboard Events</h3>\n" +
                    "<p>Event names:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">onKeyDown onKeyPress onKeyUp</code></pre>\n" +
                    "</div>\n" +
                    "<p>Properties:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">boolean altKey\n" +
                    "number charCode\n" +
                    "boolean ctrlKey\n" +
                    "boolean <span class=\"token function\">getModifierState</span><span class=\"token punctuation\">(</span>key<span class=\"token punctuation\">)</span>\n" +
                    "string key\n" +
                    "number keyCode\n" +
                    "string locale\n" +
                    "number location\n" +
                    "boolean metaKey\n" +
                    "boolean repeat\n" +
                    "boolean shiftKey\n" +
                    "number which</code></pre>\n" +
                    "</div>\n" +
                    "<p>The&nbsp;<code class=\"gatsby-code-text\">key</code>&nbsp;property can take any of the values documented in the&nbsp;<a href=\"https://www.w3.org/TR/uievents-key/#named-key-attribute-values\">DOM Level 3 Events spec</a>.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"focus-events\">Focus Events</h3>\n" +
                    "<p>Event names:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">onFocus onBlur</code></pre>\n" +
                    "</div>\n" +
                    "<p>These focus events work on all elements in the React DOM, not just form elements.</p>\n" +
                    "<p>Properties:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">DOMEventTarget relatedTarget</code></pre>\n" +
                    "</div>\n" +
                    "<hr />\n" +
                    "<h3 id=\"form-events\">Form Events</h3>\n" +
                    "<p>Event names:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">onChange onInput onInvalid onSubmit</code></pre>\n" +
                    "</div>\n" +
                    "<p>For more information about the onChange event, see&nbsp;<a href=\"https://reactjs.org/docs/forms.html\">Forms</a>.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"mouse-events\">Mouse Events</h3>\n" +
                    "<p>Event names:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">onClick onContextMenu onDoubleClick onDrag onDragEnd onDragEnter onDragExit\n" +
                    "onDragLeave onDragOver onDragStart onDrop onMouseDown onMouseEnter onMouseLeave\n" +
                    "onMouseMove onMouseOut onMouseOver onMouseUp</code></pre>\n" +
                    "</div>\n" +
                    "<p>The&nbsp;<code class=\"gatsby-code-text\">onMouseEnter</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">onMouseLeave</code>&nbsp;events propagate from the element being left to the one being entered instead of ordinary bubbling and do not have a capture phase.</p>\n" +
                    "<p>Properties:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">boolean altKey\n" +
                    "number button\n" +
                    "number buttons\n" +
                    "number clientX\n" +
                    "number clientY\n" +
                    "boolean ctrlKey\n" +
                    "boolean <span class=\"token function\">getModifierState</span><span class=\"token punctuation\">(</span>key<span class=\"token punctuation\">)</span>\n" +
                    "boolean metaKey\n" +
                    "number pageX\n" +
                    "number pageY\n" +
                    "DOMEventTarget relatedTarget\n" +
                    "number screenX\n" +
                    "number screenY\n" +
                    "boolean shiftKey</code></pre>\n" +
                    "</div>\n" +
                    "<hr />\n" +
                    "<h3 id=\"pointer-events\">Pointer Events</h3>\n" +
                    "<p>Event names:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">onPointerDown onPointerMove onPointerUp onPointerCancel onGotPointerCapture\n" +
                    "onLostPointerCapture onPointerEnter onPointerLeave onPointerOver onPointerOut</code></pre>\n" +
                    "</div>\n" +
                    "<p>The&nbsp;<code class=\"gatsby-code-text\">onPointerEnter</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">onPointerLeave</code>&nbsp;events propagate from the element being left to the one being entered instead of ordinary bubbling and do not have a capture phase.</p>\n" +
                    "<p>Properties:</p>\n" +
                    "<p>As defined in the&nbsp;<a href=\"https://www.w3.org/TR/pointerevents/\">W3 spec</a>, pointer events extend&nbsp;<a href=\"https://reactjs.org/docs/events.html#mouse-events\">Mouse Events</a>&nbsp;with the following properties:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">number pointerId\n" +
                    "number width\n" +
                    "number height\n" +
                    "number pressure\n" +
                    "number tangentialPressure\n" +
                    "number tiltX\n" +
                    "number tiltY\n" +
                    "number twist\n" +
                    "string pointerType\n" +
                    "boolean isPrimary</code></pre>\n" +
                    "</div>\n" +
                    "<p>A note on cross-browser support:</p>\n" +
                    "<p>Pointer events are not yet supported in every browser (at the time of writing this article, supported browsers include: Chrome, Firefox, Edge, and Internet Explorer). React deliberately does not polyfill support for other browsers because a standard-conform polyfill would significantly increase the bundle size of&nbsp;<code class=\"gatsby-code-text\">react-dom</code>.</p>\n" +
                    "<p>If your application requires pointer events, we recommend adding a third party pointer event polyfill.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"selection-events\">Selection Events</h3>\n" +
                    "<p>Event names:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">onSelect</code></pre>\n" +
                    "</div>\n" +
                    "<hr />\n" +
                    "<h3 id=\"touch-events\">Touch Events</h3>\n" +
                    "<p>Event names:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">onTouchCancel onTouchEnd onTouchMove onTouchStart</code></pre>\n" +
                    "</div>\n" +
                    "<p>Properties:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">boolean altKey\n" +
                    "DOMTouchList changedTouches\n" +
                    "boolean ctrlKey\n" +
                    "boolean <span class=\"token function\">getModifierState</span><span class=\"token punctuation\">(</span>key<span class=\"token punctuation\">)</span>\n" +
                    "boolean metaKey\n" +
                    "boolean shiftKey\n" +
                    "DOMTouchList targetTouches\n" +
                    "DOMTouchList touches</code></pre>\n" +
                    "</div>\n" +
                    "<hr />\n" +
                    "<h3 id=\"ui-events\">UI Events</h3>\n" +
                    "<p>Event names:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">onScroll</code></pre>\n" +
                    "</div>\n" +
                    "<p>Properties:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">number detail\n" +
                    "DOMAbstractView view</code></pre>\n" +
                    "</div>\n" +
                    "<hr />\n" +
                    "<h3 id=\"wheel-events\">Wheel Events</h3>\n" +
                    "<p>Event names:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">onWheel</code></pre>\n" +
                    "</div>\n" +
                    "<p>Properties:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">number deltaMode\n" +
                    "number deltaX\n" +
                    "number deltaY\n" +
                    "number deltaZ</code></pre>\n" +
                    "</div>\n" +
                    "<hr />\n" +
                    "<h3 id=\"media-events\">Media Events</h3>\n" +
                    "<p>Event names:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">onAbort onCanPlay onCanPlayThrough onDurationChange onEmptied onEncrypted\n" +
                    "onEnded onError onLoadedData onLoadedMetadata onLoadStart onPause onPlay\n" +
                    "onPlaying onProgress onRateChange onSeeked onSeeking onStalled onSuspend\n" +
                    "onTimeUpdate onVolumeChange onWaiting</code></pre>\n" +
                    "</div>\n" +
                    "<hr />\n" +
                    "<h3 id=\"image-events\">Image Events</h3>\n" +
                    "<p>Event names:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">onLoad onError</code></pre>\n" +
                    "</div>\n" +
                    "<hr />\n" +
                    "<h3 id=\"animation-events\">Animation Events</h3>\n" +
                    "<p>Event names:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">onAnimationStart onAnimationEnd onAnimationIteration</code></pre>\n" +
                    "</div>\n" +
                    "<p>Properties:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">string animationName\n" +
                    "string pseudoElement\n" +
                    "float elapsedTime</code></pre>\n" +
                    "</div>\n" +
                    "<hr />\n" +
                    "<h3 id=\"transition-events\">Transition Events</h3>\n" +
                    "<p>Event names:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">onTransitionEnd</code></pre>\n" +
                    "</div>\n" +
                    "<p>Properties:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">string propertyName\n" +
                    "string pseudoElement\n" +
                    "float elapsedTime</code></pre>\n" +
                    "</div>\n" +
                    "<hr />\n" +
                    "<h3 id=\"other-events\">Other Events</h3>\n" +
                    "<p>Event names:</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"text\">\n" +
                    "<pre class=\"gatsby-code-text\"><code class=\"gatsby-code-text\">onToggle</code></pre>\n" +
                    "</div>\n" +
                    "</div>");
            sec4React3.setLesson(reactJsLesson3);
            reactJsLesson3.getSections().add(sec4React3);

            Section sec5React3 = new Section();
            sec5React3.setOrdinalNumber(5);
            sec5React3.setDescription("Test Utilities");
            sec5React3.setContent("<h2 id=\"overview\">Overview</h2>\n" +
                    "<p><code class=\"gatsby-code-text\">ReactTestUtils</code>&nbsp;makes it easy to test React components in the testing framework of your choice. At Facebook we use&nbsp;<a href=\"https://facebook.github.io/jest/\">Jest</a>&nbsp;for painless JavaScript testing. Learn how to get started with Jest through the Jest website&rsquo;s&nbsp;<a href=\"http://facebook.github.io/jest/docs/en/tutorial-react.html#content\">React Tutorial</a>.</p>\n" +
                    "<blockquote>\n" +
                    "<p>Note:</p>\n" +
                    "<p>Airbnb has released a testing utility called Enzyme, which makes it easy to assert, manipulate, and traverse your React Components&rsquo; output. If you&rsquo;re deciding on a unit testing utility to use together with Jest, or any other test runner, it&rsquo;s worth checking out:&nbsp;<a href=\"http://airbnb.io/enzyme/\">http://airbnb.io/enzyme/</a></p>\n" +
                    "<p>Alternatively, there is another testing utility called react-testing-library designed to enable and encourage writing tests that use your components as the end users use them. It also works with any test runner:&nbsp;<a href=\"https://git.io/react-testing-library\">https://git.io/react-testing-library</a></p>\n" +
                    "</blockquote>\n" +
                    "<ul>\n" +
                    "<li><a href=\"https://reactjs.org/docs/test-utils.html#simulate\"><code class=\"gatsby-code-text\">Simulate</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/test-utils.html#renderintodocument\"><code class=\"gatsby-code-text\">renderIntoDocument()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/test-utils.html#mockcomponent\"><code class=\"gatsby-code-text\">mockComponent()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/test-utils.html#iselement\"><code class=\"gatsby-code-text\">isElement()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/test-utils.html#iselementoftype\"><code class=\"gatsby-code-text\">isElementOfType()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/test-utils.html#isdomcomponent\"><code class=\"gatsby-code-text\">isDOMComponent()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/test-utils.html#iscompositecomponent\"><code class=\"gatsby-code-text\">isCompositeComponent()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/test-utils.html#iscompositecomponentwithtype\"><code class=\"gatsby-code-text\">isCompositeComponentWithType()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/test-utils.html#findallinrenderedtree\"><code class=\"gatsby-code-text\">findAllInRenderedTree()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/test-utils.html#scryrendereddomcomponentswithclass\"><code class=\"gatsby-code-text\">scryRenderedDOMComponentsWithClass()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/test-utils.html#findrendereddomcomponentwithclass\"><code class=\"gatsby-code-text\">findRenderedDOMComponentWithClass()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/test-utils.html#scryrendereddomcomponentswithtag\"><code class=\"gatsby-code-text\">scryRenderedDOMComponentsWithTag()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/test-utils.html#findrendereddomcomponentwithtag\"><code class=\"gatsby-code-text\">findRenderedDOMComponentWithTag()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/test-utils.html#scryrenderedcomponentswithtype\"><code class=\"gatsby-code-text\">scryRenderedComponentsWithType()</code></a></li>\n" +
                    "<li><a href=\"https://reactjs.org/docs/test-utils.html#findrenderedcomponentwithtype\"><code class=\"gatsby-code-text\">findRenderedComponentWithType()</code></a></li>\n" +
                    "</ul>\n" +
                    "<h2 id=\"reference\">Reference</h2>\n" +
                    "<h2 id=\"shallow-rendering\">Shallow Rendering</h2>\n" +
                    "<p>When writing unit tests for React, shallow rendering can be helpful. Shallow rendering lets you render a component &ldquo;one level deep&rdquo; and assert facts about what its render method returns, without worrying about the behavior of child components, which are not instantiated or rendered. This does not require a DOM.</p>\n" +
                    "<blockquote>\n" +
                    "<p>Note:</p>\n" +
                    "<p>The shallow renderer has moved to&nbsp;<code class=\"gatsby-code-text\">react-test-renderer/shallow</code>.<br /><a href=\"https://reactjs.org/docs/shallow-renderer.html\">Learn more about shallow rendering on its reference page.</a></p>\n" +
                    "</blockquote>\n" +
                    "<h2 id=\"other-utilities\">Other Utilities</h2>\n" +
                    "<h3 id=\"simulate\"><code class=\"gatsby-code-text\">Simulate</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\">Simulate<span class=\"token punctuation\">.</span><span class=\"token punctuation\">{</span>eventName<span class=\"token punctuation\">}</span><span class=\"token punctuation\">(</span>\n" +
                    "  element<span class=\"token punctuation\">,</span>\n" +
                    "  <span class=\"token punctuation\">[</span>eventData<span class=\"token punctuation\">]</span>\n" +
                    "<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Simulate an event dispatch on a DOM node with optional&nbsp;<code class=\"gatsby-code-text\">eventData</code>&nbsp;event data.</p>\n" +
                    "<p><code class=\"gatsby-code-text\">Simulate</code>&nbsp;has a method for&nbsp;<a href=\"https://reactjs.org/docs/events.html#supported-events\">every event that React understands</a>.</p>\n" +
                    "<p><strong>Clicking an element</strong></p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token comment\">// &lt;button ref={(node) =&gt; this.button = node}&gt;...&lt;/button&gt;</span>\n" +
                    "<span class=\"token keyword\">const</span> node <span class=\"token operator\">=</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>button<span class=\"token punctuation\">;</span>\n" +
                    "ReactTestUtils<span class=\"token punctuation\">.</span>Simulate<span class=\"token punctuation\">.</span><span class=\"token function\">click</span><span class=\"token punctuation\">(</span>node<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<p><strong>Changing the value of an input field and then pressing ENTER.</strong></p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token comment\">// &lt;input ref={(node) =&gt; this.textInput = node} /&gt;</span>\n" +
                    "<span class=\"token keyword\">const</span> node <span class=\"token operator\">=</span> <span class=\"token keyword\">this</span><span class=\"token punctuation\">.</span>textInput<span class=\"token punctuation\">;</span>\n" +
                    "node<span class=\"token punctuation\">.</span>value <span class=\"token operator\">=</span> <span class=\"token string\">'giraffe'</span><span class=\"token punctuation\">;</span>\n" +
                    "ReactTestUtils<span class=\"token punctuation\">.</span>Simulate<span class=\"token punctuation\">.</span><span class=\"token function\">change</span><span class=\"token punctuation\">(</span>node<span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "ReactTestUtils<span class=\"token punctuation\">.</span>Simulate<span class=\"token punctuation\">.</span><span class=\"token function\">keyDown</span><span class=\"token punctuation\">(</span>node<span class=\"token punctuation\">,</span> <span class=\"token punctuation\">{</span>key<span class=\"token punctuation\">:</span> <span class=\"token string\">\"Enter\"</span><span class=\"token punctuation\">,</span> keyCode<span class=\"token punctuation\">:</span> <span class=\"token number\">13</span><span class=\"token punctuation\">,</span> which<span class=\"token punctuation\">:</span> <span class=\"token number\">13</span><span class=\"token punctuation\">}</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span></code></pre>\n" +
                    "</div>\n" +
                    "<blockquote>\n" +
                    "<p>Note</p>\n" +
                    "<p>You will have to provide any event property that you&rsquo;re using in your component (e.g. keyCode, which, etc&hellip;) as React is not creating any of these for you.</p>\n" +
                    "</blockquote>\n" +
                    "<hr />\n" +
                    "<h3 id=\"renderintodocument\"><code class=\"gatsby-code-text\">renderIntoDocument()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token function\">renderIntoDocument</span><span class=\"token punctuation\">(</span>element<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Render a React element into a detached DOM node in the document.&nbsp;<strong>This function requires a DOM.</strong></p>\n" +
                    "<blockquote>\n" +
                    "<p>Note:</p>\n" +
                    "<p>You will need to have&nbsp;<code class=\"gatsby-code-text\">window</code>,&nbsp;<code class=\"gatsby-code-text\">window.document</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">window.document.createElement</code>globally available&nbsp;<strong>before</strong>&nbsp;you import&nbsp;<code class=\"gatsby-code-text\">React</code>. Otherwise React will think it can&rsquo;t access the DOM and methods like&nbsp;<code class=\"gatsby-code-text\">setState</code>&nbsp;won&rsquo;t work.</p>\n" +
                    "</blockquote>\n" +
                    "<hr />\n" +
                    "<h3 id=\"mockcomponent\"><code class=\"gatsby-code-text\">mockComponent()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token function\">mockComponent</span><span class=\"token punctuation\">(</span>\n" +
                    "  componentClass<span class=\"token punctuation\">,</span>\n" +
                    "  <span class=\"token punctuation\">[</span>mockTagName<span class=\"token punctuation\">]</span>\n" +
                    "<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Pass a mocked component module to this method to augment it with useful methods that allow it to be used as a dummy React component. Instead of rendering as usual, the component will become a simple&nbsp;<code class=\"gatsby-code-text\">&lt;div&gt;</code>&nbsp;(or other tag if&nbsp;<code class=\"gatsby-code-text\">mockTagName</code>&nbsp;is provided) containing any provided children.</p>\n" +
                    "<blockquote>\n" +
                    "<p>Note:</p>\n" +
                    "<p><code class=\"gatsby-code-text\">mockComponent()</code>&nbsp;is a legacy API. We recommend using&nbsp;<a href=\"https://reactjs.org/docs/test-utils.html#shallow-rendering\">shallow rendering</a>&nbsp;or&nbsp;<a href=\"https://facebook.github.io/jest/docs/en/tutorial-react-native.html#mock-native-modules-using-jestmock\"><code class=\"gatsby-code-text\">jest.mock()</code></a>instead.</p>\n" +
                    "</blockquote>\n" +
                    "<hr />\n" +
                    "<h3 id=\"iselement\"><code class=\"gatsby-code-text\">isElement()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token function\">isElement</span><span class=\"token punctuation\">(</span>element<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Returns&nbsp;<code class=\"gatsby-code-text\">true</code>&nbsp;if&nbsp;<code class=\"gatsby-code-text\">element</code>&nbsp;is any React element.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"iselementoftype\"><code class=\"gatsby-code-text\">isElementOfType()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token function\">isElementOfType</span><span class=\"token punctuation\">(</span>\n" +
                    "  element<span class=\"token punctuation\">,</span>\n" +
                    "  componentClass\n" +
                    "<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Returns&nbsp;<code class=\"gatsby-code-text\">true</code>&nbsp;if&nbsp;<code class=\"gatsby-code-text\">element</code>&nbsp;is a React element whose type is of a React&nbsp;<code class=\"gatsby-code-text\">componentClass</code>.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"isdomcomponent\"><code class=\"gatsby-code-text\">isDOMComponent()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token function\">isDOMComponent</span><span class=\"token punctuation\">(</span>instance<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Returns&nbsp;<code class=\"gatsby-code-text\">true</code>&nbsp;if&nbsp;<code class=\"gatsby-code-text\">instance</code>&nbsp;is a DOM component (such as a&nbsp;<code class=\"gatsby-code-text\">&lt;div&gt;</code>&nbsp;or&nbsp;<code class=\"gatsby-code-text\">&lt;span&gt;</code>).</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"iscompositecomponent\"><code class=\"gatsby-code-text\">isCompositeComponent()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token function\">isCompositeComponent</span><span class=\"token punctuation\">(</span>instance<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Returns&nbsp;<code class=\"gatsby-code-text\">true</code>&nbsp;if&nbsp;<code class=\"gatsby-code-text\">instance</code>&nbsp;is a user-defined component, such as a class or a function.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"iscompositecomponentwithtype\"><code class=\"gatsby-code-text\">isCompositeComponentWithType()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token function\">isCompositeComponentWithType</span><span class=\"token punctuation\">(</span>\n" +
                    "  instance<span class=\"token punctuation\">,</span>\n" +
                    "  componentClass\n" +
                    "<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Returns&nbsp;<code class=\"gatsby-code-text\">true</code>&nbsp;if&nbsp;<code class=\"gatsby-code-text\">instance</code>&nbsp;is a component whose type is of a React&nbsp;<code class=\"gatsby-code-text\">componentClass</code>.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"findallinrenderedtree\"><code class=\"gatsby-code-text\">findAllInRenderedTree()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token function\">findAllInRenderedTree</span><span class=\"token punctuation\">(</span>\n" +
                    "  tree<span class=\"token punctuation\">,</span>\n" +
                    "  test\n" +
                    "<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Traverse all components in&nbsp;<code class=\"gatsby-code-text\">tree</code>&nbsp;and accumulate all components where&nbsp;<code class=\"gatsby-code-text\">test(component)</code>&nbsp;is&nbsp;<code class=\"gatsby-code-text\">true</code>. This is not that useful on its own, but it&rsquo;s used as a primitive for other test utils.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"scryrendereddomcomponentswithclass\"><code class=\"gatsby-code-text\">scryRenderedDOMComponentsWithClass()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token function\">scryRenderedDOMComponentsWithClass</span><span class=\"token punctuation\">(</span>\n" +
                    "  tree<span class=\"token punctuation\">,</span>\n" +
                    "  className\n" +
                    "<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Finds all DOM elements of components in the rendered tree that are DOM components with the class name matching&nbsp;<code class=\"gatsby-code-text\">className</code>.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"findrendereddomcomponentwithclass\"><code class=\"gatsby-code-text\">findRenderedDOMComponentWithClass()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token function\">findRenderedDOMComponentWithClass</span><span class=\"token punctuation\">(</span>\n" +
                    "  tree<span class=\"token punctuation\">,</span>\n" +
                    "  className\n" +
                    "<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Like&nbsp;<a href=\"https://reactjs.org/docs/test-utils.html#scryrendereddomcomponentswithclass\"><code class=\"gatsby-code-text\">scryRenderedDOMComponentsWithClass()</code></a>&nbsp;but expects there to be one result, and returns that one result, or throws exception if there is any other number of matches besides one.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"scryrendereddomcomponentswithtag\"><code class=\"gatsby-code-text\">scryRenderedDOMComponentsWithTag()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token function\">scryRenderedDOMComponentsWithTag</span><span class=\"token punctuation\">(</span>\n" +
                    "  tree<span class=\"token punctuation\">,</span>\n" +
                    "  tagName\n" +
                    "<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Finds all DOM elements of components in the rendered tree that are DOM components with the tag name matching&nbsp;<code class=\"gatsby-code-text\">tagName</code>.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"findrendereddomcomponentwithtag\"><code class=\"gatsby-code-text\">findRenderedDOMComponentWithTag()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token function\">findRenderedDOMComponentWithTag</span><span class=\"token punctuation\">(</span>\n" +
                    "  tree<span class=\"token punctuation\">,</span>\n" +
                    "  tagName\n" +
                    "<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Like&nbsp;<a href=\"https://reactjs.org/docs/test-utils.html#scryrendereddomcomponentswithtag\"><code class=\"gatsby-code-text\">scryRenderedDOMComponentsWithTag()</code></a>&nbsp;but expects there to be one result, and returns that one result, or throws exception if there is any other number of matches besides one.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"scryrenderedcomponentswithtype\"><code class=\"gatsby-code-text\">scryRenderedComponentsWithType()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token function\">scryRenderedComponentsWithType</span><span class=\"token punctuation\">(</span>\n" +
                    "  tree<span class=\"token punctuation\">,</span>\n" +
                    "  componentClass\n" +
                    "<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Finds all instances of components with type equal to&nbsp;<code class=\"gatsby-code-text\">componentClass</code>.</p>\n" +
                    "<hr />\n" +
                    "<h3 id=\"findrenderedcomponentwithtype\"><code class=\"gatsby-code-text\">findRenderedComponentWithType()</code></h3>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token function\">findRenderedComponentWithType</span><span class=\"token punctuation\">(</span>\n" +
                    "  tree<span class=\"token punctuation\">,</span>\n" +
                    "  componentClass\n" +
                    "<span class=\"token punctuation\">)</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>Same as&nbsp;<a href=\"https://reactjs.org/docs/test-utils.html#scryrenderedcomponentswithtype\"><code class=\"gatsby-code-text\">scryRenderedComponentsWithType()</code></a>&nbsp;but expects there to be one result and returns that one result, or throws exception if there is any other number of matches besides one.</p>");
            sec5React3.setLesson(reactJsLesson3);
            reactJsLesson3.getSections().add(sec5React3);


            Section sec1React4 = new Section();
            sec1React4.setOrdinalNumber(1);
            sec1React4.setDescription("Introducing Hooks");
            sec1React4.setContent("<h2 id=\"no-breaking-changes\">No Breaking Changes</h2>\n" +
                    "<p>Before we continue, note that Hooks are:</p>\n" +
                    "<ul>\n" +
                    "<li><strong>Completely opt-in.</strong>&nbsp;You can try Hooks in a few components without rewriting any existing code. But you don&rsquo;t have to learn or use Hooks right now if you don&rsquo;t want to.</li>\n" +
                    "<li><strong>100% backwards-compatible.</strong>&nbsp;Hooks don&rsquo;t contain any breaking changes.</li>\n" +
                    "<li><strong>Available now.</strong>&nbsp;Hooks are currently in an alpha release, and we hope to include them in React 16.7 after receiving community feedback.</li>\n" +
                    "</ul>\n" +
                    "<p><strong>There are no plans to remove classes from React.</strong>&nbsp;You can read more about the gradual adoption strategy for Hooks in the&nbsp;<a href=\"https://reactjs.org/docs/hooks-intro.html#gradual-adoption-strategy\">bottom section</a>&nbsp;of this page.</p>\n" +
                    "<p><strong>Hooks don&rsquo;t replace your knowledge of React concepts.</strong>&nbsp;Instead, Hooks provide a more direct API to the React concepts you already know: props, state, context, refs, and lifecycle. As we will show later, Hooks also offer a new powerful way to combine them.</p>\n" +
                    "<p><strong>If you just want to start learning Hooks, feel free to&nbsp;<a href=\"https://reactjs.org/docs/hooks-overview.html\">jump directly to the next page!</a></strong>&nbsp;You can also keep reading this page to learn more about why we&rsquo;re adding Hooks, and how we&rsquo;re going to start using them without rewriting our applications.</p>\n" +
                    "<h2 id=\"motivation\">Motivation</h2>\n" +
                    "<p>Hooks solve a wide variety of seemingly unconnected problems in React that we&rsquo;ve encountered over five years of writing and maintaining tens of thousands of components. Whether you&rsquo;re learning React, use it daily, or even prefer a different library with a similar component model, you might recognize some of these problems.</p>\n" +
                    "<h3 id=\"its-hard-to-reuse-stateful-logic-between-components\">It&rsquo;s hard to reuse stateful logic between components</h3>\n" +
                    "<p>React doesn&rsquo;t offer a way to &ldquo;attach&rdquo; reusable behavior to a component (for example, connecting it to a store). If you&rsquo;ve worked with React for a while, you may be familiar with patterns like&nbsp;<a href=\"https://reactjs.org/docs/render-props.html\">render props</a>&nbsp;and&nbsp;<a href=\"https://reactjs.org/docs/higher-order-components.html\">higher-order components</a>&nbsp;that try to solve this. But these patterns require you to restructure your components when you use them, which can be cumbersome and make code harder to follow. If you look at a typical React application in React DevTools, you will likely find a &ldquo;wrapper hell&rdquo; of components surrounded by layers of providers, consumers, higher-order components, render props, and other abstractions. While we could&nbsp;<a href=\"https://github.com/facebook/react-devtools/pull/503\">filter them out in DevTools</a>, this points to a deeper underlying problem: React needs a better primitive for sharing stateful logic.</p>\n" +
                    "<p>With Hooks, you can extract stateful logic from a component so it can be tested independently and reused.&nbsp;<strong>Hooks allow you to reuse stateful logic without changing your component hierarchy.</strong>&nbsp;This makes it easy to share Hooks among many components or with the community.</p>\n" +
                    "<p>We&rsquo;ll discuss this more in&nbsp;<a href=\"https://reactjs.org/docs/hooks-custom.html\">Building Your Own Hooks</a>.</p>\n" +
                    "<h3 id=\"complex-components-become-hard-to-understand\">Complex components become hard to understand</h3>\n" +
                    "<p>We&rsquo;ve often had to maintain components that started out simple but grew into an unmanageable mess of stateful logic and side effects. Each lifecycle method often contains a mix of unrelated logic. For example, components might perform some data fetching in&nbsp;<code class=\"gatsby-code-text\">componentDidMount</code>&nbsp;and&nbsp;<code class=\"gatsby-code-text\">componentDidUpdate</code>. However, the same&nbsp;<code class=\"gatsby-code-text\">componentDidMount</code>method might also contain some unrelated logic that sets up event listeners, with cleanup performed in&nbsp;<code class=\"gatsby-code-text\">componentWillUnmount</code>. Mutually related code that changes together gets split apart, but completely unrelated code ends up combined in a single method. This makes it too easy to introduce bugs and inconsistencies.</p>\n" +
                    "<p>In many cases it&rsquo;s not possible to break these components into smaller ones because the stateful logic is all over the place. It&rsquo;s also difficult to test them. This is one of the reasons many people prefer to combine React with a separate state management library. However, that often introduces too much abstraction, requires you to jump between different files, and makes reusing components more difficult.</p>\n" +
                    "<p>To solve this,&nbsp;<strong>Hooks let you split one component into smaller functions based on what pieces are related (such as setting up a subscription or fetching data)</strong>, rather than forcing a split based on lifecycle methods. You may also opt into managing the component&rsquo;s local state with a reducer to make it more predictable.</p>\n" +
                    "<p>We&rsquo;ll discuss this more in&nbsp;<a href=\"https://reactjs.org/docs/hooks-effect.html#tip-use-multiple-effects-to-separate-concerns\">Using the Effect Hook</a>.</p>\n" +
                    "<h3 id=\"classes-confuse-both-people-and-machines\">Classes confuse both people and machines</h3>\n" +
                    "<p>In our observation, classes are the biggest barrier to learning React. You have to understand how&nbsp;<code class=\"gatsby-code-text\">this</code>&nbsp;works in JavaScript, which is very different from how it works in most languages. You have to remember to bind the event handlers. Without unstable&nbsp;<a href=\"https://babeljs.io/docs/en/babel-plugin-transform-class-properties/\">syntax proposals</a>, the code is very verbose. People can understand props, state, and top-down data flow perfectly well but still struggle with classes. The distinction between function and class components in React and when to use each one leads to disagreements even between experienced React developers.</p>\n" +
                    "<p>Additionally, React has been out for about five years, and we want to make sure it stays relevant in the next five years. As&nbsp;<a href=\"https://svelte.technology/\">Svelte</a>,&nbsp;<a href=\"https://angular.io/\">Angular</a>,&nbsp;<a href=\"https://glimmerjs.com/\">Glimmer</a>, and others show,&nbsp;<a href=\"https://en.wikipedia.org/wiki/Ahead-of-time_compilation\">ahead-of-time compilation</a>&nbsp;of components has a lot of future potential. Especially if it&rsquo;s not limited to templates. Recently, we&rsquo;ve been experimenting with&nbsp;<a href=\"https://github.com/facebook/react/issues/7323\">component folding</a>&nbsp;using&nbsp;<a href=\"https://prepack.io/\">Prepack</a>, and we&rsquo;ve seen promising early results. However, we found that class components can encourage unintentional patterns that make these optimizations fall back to a slower path. Classes present issues for today&rsquo;s tools, too. For example, classes don&rsquo;t minify very well, and they make hot reloading flaky and unreliable. We want to present an API that makes it more likely for code to stay on the optimizable path.</p>\n" +
                    "<p>To solve these problems,&nbsp;<strong>Hooks let you use more of React&rsquo;s features without classes.</strong>Conceptually, React components have always been closer to functions. Hooks embrace functions, but without sacrificing the practical spirit of React. Hooks provide access to imperative escape hatches and don&rsquo;t require you to learn complex functional or reactive programming techniques.</p>\n" +
                    "<blockquote>\n" +
                    "<p>Examples</p>\n" +
                    "<p><a href=\"https://reactjs.org/docs/hooks-overview.html\">Hooks at a Glance</a>&nbsp;is a good place to start learning Hooks.</p>\n" +
                    "</blockquote>\n" +
                    "<h2 id=\"gradual-adoption-strategy\">Gradual Adoption Strategy</h2>\n" +
                    "<blockquote>\n" +
                    "<p><strong>TLDR: There are no plans to remove classes from React.</strong></p>\n" +
                    "</blockquote>\n" +
                    "<p>We know that React developers are focused on shipping products and don&rsquo;t have time to look into every new API that&rsquo;s being released. Hooks are very new, and it might be better to wait for more examples and tutorials before considering learning or adopting them.</p>\n" +
                    "<p>We also understand that the bar for adding a new primitive to React is extremely high. For curious readers, we have prepared a&nbsp;<a href=\"https://github.com/reactjs/rfcs/pull/68\">detailed RFC</a>&nbsp;that dives into motivation with more details, and provides extra perspective on the specific design decisions and related prior art.</p>\n" +
                    "<p><strong>Crucially, Hooks work side-by-side with existing code so you can adopt them gradually.</strong>We are sharing this experimental API to get early feedback from those in the community who are interested in shaping the future of React &mdash; and we will iterate on Hooks in the open.</p>\n" +
                    "<p>Finally, there is no rush to migrate to Hooks. We recommend avoiding any &ldquo;big rewrites&rdquo;, especially for existing, complex class components. It takes a bit of a mindshift to start &ldquo;thinking in Hooks&rdquo;. In our experience, it&rsquo;s best to practice using Hooks in new and non-critical components first, and ensure that everybody on your team feels comfortable with them. After you give Hooks a try, please feel free to&nbsp;<a href=\"https://github.com/facebook/react/issues/new\">send us feedback</a>, positive or negative.</p>\n" +
                    "<p>We intend for Hooks to cover all existing use cases for classes, but&nbsp;<strong>we will keep supporting class components for the foreseeable future.</strong>&nbsp;At Facebook, we have tens of thousands of components written as classes, and we have absolutely no plans to rewrite them. Instead, we are starting to use Hooks in the new code side by side with classes.</p>\n" +
                    "<h2 id=\"next-steps\">&nbsp;</h2>");
            sec1React4.setLesson(reactJsLesson4);
            reactJsLesson4.getSections().add(sec1React4);

            Section sec2React4 = new Section();
            sec2React4.setOrdinalNumber(2);
            sec2React4.setDescription("Hooks at a Glance");
            sec2React4.setContent("<p><em>Hooks</em>&nbsp;are a new feature proposal that lets you use state and other React features without writing a class. They&rsquo;re currently in React v16.7.0-alpha and being discussed in&nbsp;<a href=\"https://github.com/reactjs/rfcs/pull/68\">an open RFC</a>.</p>\n" +
                    "<div class=\"gatsby-highlight\" data-language=\"jsx\">\n" +
                    "<pre class=\"gatsby-code-jsx\"><code class=\"gatsby-code-jsx\"><span class=\"token keyword\">import</span> <span class=\"token punctuation\">{</span> useState <span class=\"token punctuation\">}</span> <span class=\"token keyword\">from</span> <span class=\"token string\">'react'</span><span class=\"token punctuation\">;</span>\n" +
                    "\n" +
                    "<span class=\"token keyword\">function</span> <span class=\"token function\">Example</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token punctuation\">{</span>\n" +
                    "<span class=\"gatsby-highlight-code-line\">  <span class=\"token comment\">// Declare a new state variable, which we'll call \"count\"</span>\n" +
                    "</span><span class=\"gatsby-highlight-code-line\">  <span class=\"token keyword\">const</span> <span class=\"token punctuation\">[</span>count<span class=\"token punctuation\">,</span> setCount<span class=\"token punctuation\">]</span> <span class=\"token operator\">=</span> <span class=\"token function\">useState</span><span class=\"token punctuation\">(</span><span class=\"token number\">0</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "</span>\n" +
                    "  <span class=\"token keyword\">return</span> <span class=\"token punctuation\">(</span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>p<span class=\"token punctuation\">&gt;</span></span><span class=\"token plain-text\">You clicked </span><span class=\"token punctuation\">{</span>count<span class=\"token punctuation\">}</span><span class=\"token plain-text\"> times</span><span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>p<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;</span>button <span class=\"token attr-name\">onClick</span><span class=\"token script language-javascript\"><span class=\"token script-punctuation punctuation\">=</span><span class=\"token punctuation\">{</span><span class=\"token punctuation\">(</span><span class=\"token punctuation\">)</span> <span class=\"token operator\">=&gt;</span> <span class=\"token function\">setCount</span><span class=\"token punctuation\">(</span>count <span class=\"token operator\">+</span> <span class=\"token number\">1</span><span class=\"token punctuation\">)</span><span class=\"token punctuation\">}</span></span><span class=\"token punctuation\">&gt;</span></span>\n" +
                    "<span class=\"token plain-text\">        Click me</span>\n" +
                    "      <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>button<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "    <span class=\"token tag\"><span class=\"token punctuation\">&lt;/</span>div<span class=\"token punctuation\">&gt;</span></span>\n" +
                    "  <span class=\"token punctuation\">)</span><span class=\"token punctuation\">;</span>\n" +
                    "<span class=\"token punctuation\">}</span></code></pre>\n" +
                    "</div>\n" +
                    "<p>This new function&nbsp;<code class=\"gatsby-code-text\">useState</code>&nbsp;is the first &ldquo;Hook&rdquo; we&rsquo;ll learn about, but this example is just a teaser. Don&rsquo;t worry if it doesn&rsquo;t make sense yet!</p>\n" +
                    "<p><strong>You can start learning Hooks&nbsp;<a href=\"https://reactjs.org/docs/hooks-overview.html\">on the next page</a>.</strong>&nbsp;On this page, we&rsquo;ll continue by explaining why we&rsquo;re adding Hooks to React and how they can help you write great applications.</p>");
            sec2React4.setLesson(reactJsLesson4);
            reactJsLesson4.getSections().add(sec2React4);

            Section sec3React4 = new Section();
            sec3React4.setOrdinalNumber(3);
            sec3React4.setDescription("Using the State Hook");
            sec3React4.setContent("USing the state hook");
            sec3React4.setLesson(reactJsLesson4);
            reactJsLesson4.getSections().add(sec3React4);

            Section sec4React4 = new Section();
            sec4React4.setOrdinalNumber(4);
            sec4React4.setDescription("Using the Effect Hook");
            sec4React4.setContent("The Effect Hook lets you perform side effects in function components:\n" +
                    "\n" +
                    "import { useState, useEffect } from 'react';\n" +
                    "\n" +
                    "function Example() {\n" +
                    "  const [count, setCount] = useState(0);\n" +
                    "\n" +
                    "  // Similar to componentDidMount and componentDidUpdate:\n" +
                    "  useEffect(() => {\n" +
                    "    // Update the document title using the browser API\n" +
                    "    document.title = `You clicked ${count} times`;\n" +
                    "  });\n" +
                    "\n" +
                    "  return (\n" +
                    "    <div>\n" +
                    "      <p>You clicked {count} times</p>\n" +
                    "      <button onClick={() => setCount(count + 1)}>\n" +
                    "        Click me\n" +
                    "      </button>\n" +
                    "    </div>\n" +
                    "  );\n" +
                    "}\n" +
                    "This snippet is based on the counter example from the previous page, but we added a new feature to it: we set the document title to a custom message including the number of clicks.\n" +
                    "\n" +
                    "Data fetching, setting up a subscription, and manually changing the DOM in React components are all examples of side effects. Whether or not you’re used to calling these operations “side effects” (or just “effects”), you’ve likely performed them in your components before.\n" +
                    "\n" +
                    "Tip\n" +
                    "\n" +
                    "If you’re familiar with React class lifecycle methods, you can think of useEffect Hook as componentDidMount, componentDidUpdate, and componentWillUnmount combined.\n" +
                    "\n" +
                    "There are two common kinds of side effects in React components: those that don’t require cleanup, and those that do. Let’s look at this distinction in more detail.\n" +
                    "\n" +
                    "Effects Without Cleanup\n" +
                    "Sometimes, we want to run some additional code after React has updated the DOM. Network requests, manual DOM mutations, and logging are common examples of effects that don’t require a cleanup. We say that because we can run them and immediately forget about them. Let’s compare how classes and Hooks let us express such side effects.\n" +
                    "\n" +
                    "Example Using Classes\n" +
                    "In React class components, the render method itself shouldn’t cause side effects. It would be too early — we typically want to perform our effects after React has updated the DOM.\n" +
                    "\n" +
                    "This is why in React classes, we put side effects into componentDidMount and componentDidUpdate. Coming back to our example, here is a React counter class component that updates the document title right after React makes changes to the DOM:\n" +
                    "\n" +
                    "class Example extends React.Component {\n" +
                    "  constructor(props) {\n" +
                    "    super(props);\n" +
                    "    this.state = {\n" +
                    "      count: 0\n" +
                    "    };\n" +
                    "  }\n" +
                    "\n" +
                    "  componentDidMount() {\n" +
                    "    document.title = `You clicked ${this.state.count} times`;\n" +
                    "  }\n" +
                    "\n" +
                    "  componentDidUpdate() {\n" +
                    "    document.title = `You clicked ${this.state.count} times`;\n" +
                    "  }\n" +
                    "\n" +
                    "  render() {\n" +
                    "    return (\n" +
                    "      <div>\n" +
                    "        <p>You clicked {this.state.count} times</p>\n" +
                    "        <button onClick={() => this.setState({ count: this.state.count + 1 })}>\n" +
                    "          Click me\n" +
                    "        </button>\n" +
                    "      </div>\n" +
                    "    );\n" +
                    "  }\n" +
                    "}\n" +
                    "Note how we have to duplicate the code between these two lifecycle methods in class.\n" +
                    "\n" +
                    "This is because in many cases we want to perform the same side effect regardless of whether the component just mounted, or if it has been updated. Conceptually, we want it to happen after every render — but React class components don’t have a method like this. We could extract a separate method but we would still have to call it in two places.\n" +
                    "\n" +
                    "Now let’s see how we can do the same with the useEffect Hook.\n" +
                    "\n" +
                    "Example Using Hooks\n" +
                    "We’ve already seen this example at the top of this page, but let’s take a closer look at it:\n" +
                    "\n" +
                    "import { useState, useEffect } from 'react';\n" +
                    "\n" +
                    "function Example() {\n" +
                    "  const [count, setCount] = useState(0);\n" +
                    "\n" +
                    "  useEffect(() => {\n" +
                    "    document.title = `You clicked ${count} times`;\n" +
                    "  });\n" +
                    "\n" +
                    "  return (\n" +
                    "    <div>\n" +
                    "      <p>You clicked {count} times</p>\n" +
                    "      <button onClick={() => setCount(count + 1)}>\n" +
                    "        Click me\n" +
                    "      </button>\n" +
                    "    </div>\n" +
                    "  );\n" +
                    "}\n" +
                    "What does useEffect do? By using this Hook, you tell React that your component needs to do something after render. React will remember the function you passed (we’ll refer to it as our “effect”), and call it later after performing the DOM updates. In this effect, we set the document title, but we could also perform data fetching or call some other imperative API.\n" +
                    "\n" +
                    "Why is useEffect called inside a component? Placing useEffect inside the component lets us access the count state variable (or any props) right from the effect. We don’t need a special API to read it — it’s already in the function scope. Hooks embrace JavaScript closures and avoid introducing React-specific APIs where JavaScript already provides a solution.\n" +
                    "\n" +
                    "Does useEffect run after every render? Yes! By default, it runs both after the first render and after every update. (We will later talk about how to customize this.) Instead of thinking in terms of “mounting” and “updating”, you might find it easier to think that effects happen “after render”. React guarantees the DOM has been updated by the time it runs the effects.\n" +
                    "\n" +
                    "Detailed Explanation\n" +
                    "Now that we know more about effects, these lines should make sense:\n" +
                    "\n" +
                    "function Example() {\n" +
                    "  const [count, setCount] = useState(0);\n" +
                    "\n" +
                    "  useEffect(() => {\n" +
                    "    document.title = `You clicked ${count} times`;\n" +
                    "  });\n" +
                    "We declare the count state variable, and then we tell React we need to use an effect. We pass a function to the useEffect Hook. This function we pass is our effect. Inside our effect, we set the document title using the document.title browser API. We can read the latest count inside the effect because it’s in the scope of our function. When React renders our component, it will remember the effect we used, and then run our effect after updating the DOM. This happens for every render, including the first one.\n" +
                    "\n" +
                    "Experienced JavaScript developers might notice that the function passed to useEffect is going to be different on every render. This is intentional. In fact, this is what lets us read the count value from inside the effect without worrying about it getting stale. Every time we re-render, we schedule a different effect, replacing the previous one. In a way, this makes the effects behave more like a part of the render result — each effect “belongs” to a particular render. We will see more clearly why this is useful later on this page.\n" +
                    "\n" +
                    "Tip\n" +
                    "\n" +
                    "Unlike componentDidMount or componentDidUpdate, effects scheduled with useEffect don’t block the browser from updating the screen. This makes your app feel more responsive. The majority of effects don’t need to happen synchronously. In the uncommon cases where they do (such as measuring the layout), there is a separate useLayoutEffect Hook with an API identical to useEffect.\n" +
                    "\n" +
                    "Effects with Cleanup\n" +
                    "Earlier, we looked at how to express side effects that don’t require any cleanup. However, some effects do. For example, we might want to set up a subscription to some external data source. In that case, it is important to clean up so that we don’t introduce a memory leak! Let’s compare how we can do it with classes and with Hooks.\n" +
                    "\n" +
                    "Example Using Classes\n" +
                    "In a React class, you would typically set up a subscription in componentDidMount, and clean it up in componentWillUnmount. For example, let’s say we have a ChatAPI module that lets us subscribe to a friend’s online status. Here’s how we might subscribe and display that status using a class:\n" +
                    "\n" +
                    "class FriendStatus extends React.Component {\n" +
                    "  constructor(props) {\n" +
                    "    super(props);\n" +
                    "    this.state = { isOnline: null };\n" +
                    "    this.handleStatusChange = this.handleStatusChange.bind(this);\n" +
                    "  }\n" +
                    "\n" +
                    "  componentDidMount() {\n" +
                    "    ChatAPI.subscribeToFriendStatus(\n" +
                    "      this.props.friend.id,\n" +
                    "      this.handleStatusChange\n" +
                    "    );\n" +
                    "  }\n" +
                    "\n" +
                    "  componentWillUnmount() {\n" +
                    "    ChatAPI.unsubscribeFromFriendStatus(\n" +
                    "      this.props.friend.id,\n" +
                    "      this.handleStatusChange\n" +
                    "    );\n" +
                    "  }\n" +
                    "\n" +
                    "  handleStatusChange(status) {\n" +
                    "    this.setState({\n" +
                    "      isOnline: status.isOnline\n" +
                    "    });\n" +
                    "  }\n" +
                    "\n" +
                    "  render() {\n" +
                    "    if (this.state.isOnline === null) {\n" +
                    "      return 'Loading...';\n" +
                    "    }\n" +
                    "    return this.state.isOnline ? 'Online' : 'Offline';\n" +
                    "  }\n" +
                    "}\n" +
                    "Notice how componentDidMount and componentWillUnmount need to mirror each other. Lifecycle methods force us to split this logic even though conceptually code in both of them is related to the same effect.\n" +
                    "\n" +
                    "Note\n" +
                    "\n" +
                    "Eagle-eyed readers may notice that this example also needs a componentDidUpdate method to be fully correct. We’ll ignore this for now but will come back to it in a later section of this page.\n" +
                    "\n" +
                    "Example Using Hooks\n" +
                    "Let’s see how we could write this component with Hooks.\n" +
                    "\n" +
                    "You might be thinking that we’d need a separate effect to perform the cleanup. But code for adding and removing a subscription is so tightly related that useEffect is designed to keep it together. If your effect returns a function, React will run it when it is time to clean up:\n" +
                    "\n" +
                    "import { useState, useEffect } from 'react';\n" +
                    "\n" +
                    "function FriendStatus(props) {\n" +
                    "  const [isOnline, setIsOnline] = useState(null);\n" +
                    "\n" +
                    "  function handleStatusChange(status) {\n" +
                    "    setIsOnline(status.isOnline);\n" +
                    "  }\n" +
                    "\n" +
                    "  useEffect(() => {\n" +
                    "    ChatAPI.subscribeToFriendStatus(props.friend.id, handleStatusChange);\n" +
                    "    // Specify how to clean up after this effect:\n" +
                    "    return function cleanup() {\n" +
                    "      ChatAPI.unsubscribeFromFriendStatus(props.friend.id, handleStatusChange);\n" +
                    "    };\n" +
                    "  });\n" +
                    "\n" +
                    "  if (isOnline === null) {\n" +
                    "    return 'Loading...';\n" +
                    "  }\n" +
                    "  return isOnline ? 'Online' : 'Offline';\n" +
                    "}\n" +
                    "Why did we return a function from our effect? This is the optional cleanup mechanism for effects. Every effect may return a function that cleans up after it. This lets us keep the logic for adding and removing subscriptions close to each other. They’re part of the same effect!\n" +
                    "\n" +
                    "When exactly does React clean up an effect? React performs the cleanup when the component unmounts. However, as we learned earlier, effects run for every render and not just once. This is why React also cleans up effects from the previous render before running the effects next time. We’ll discuss why this helps avoid bugs and how to opt out of this behavior in case it creates performance issues later below.\n" +
                    "\n" +
                    "Note\n" +
                    "\n" +
                    "We don’t have to return a named function from the effect. We called it cleanup here to clarify its purpose, but you could return an arrow function or call it something different.\n" +
                    "\n" +
                    "Recap\n" +
                    "We’ve learned that useEffect lets us express different kinds of side effects after a component renders. Some effects might require cleanup so they return a function:\n" +
                    "\n" +
                    "  useEffect(() => {\n" +
                    "    ChatAPI.subscribeToFriendStatus(props.friend.id, handleStatusChange);\n" +
                    "    return () => {\n" +
                    "      ChatAPI.unsubscribeFromFriendStatus(props.friend.id, handleStatusChange);\n" +
                    "    };\n" +
                    "  });\n" +
                    "Other effects might not have a cleanup phase, and don’t return anything.\n" +
                    "\n" +
                    "  useEffect(() => {\n" +
                    "    document.title = `You clicked ${count} times`;\n" +
                    "  });\n" +
                    "The Effect Hook unifies both use cases with a single API.\n" +
                    "\n" +
                    "If you feel like you have a decent grasp on how the Effect Hook works, or if you feel overwhelmed, you can jump to the next page about Rules of Hooks now.\n" +
                    "\n" +
                    "Tips for Using Effects\n" +
                    "We’ll continue this page with an in-depth look at some aspects of useEffect that experienced React users will likely be curious about. Don’t feel obligated to dig into them now. You can always come back to this page to learn more details about the Effect Hook.\n" +
                    "\n" +
                    "Tip: Use Multiple Effects to Separate Concerns\n" +
                    "One of the problems we outlined in the Motivation for Hooks is that class lifecycle methods often contain unrelated logic, but related logic gets broken up into several methods. Here is a component that combines the counter and the friend status indicator logic from the previous examples:\n" +
                    "\n" +
                    "class FriendStatusWithCounter extends React.Component {\n" +
                    "  constructor(props) {\n" +
                    "    super(props);\n" +
                    "    this.state = { count: 0, isOnline: null };\n" +
                    "    this.handleStatusChange = this.handleStatusChange.bind(this);\n" +
                    "  }\n" +
                    "\n" +
                    "  componentDidMount() {\n" +
                    "    document.title = `You clicked ${this.state.count} times`;\n" +
                    "    ChatAPI.subscribeToFriendStatus(\n" +
                    "      this.props.friend.id,\n" +
                    "      this.handleStatusChange\n" +
                    "    );\n" +
                    "  }\n" +
                    "\n" +
                    "  componentDidUpdate() {\n" +
                    "    document.title = `You clicked ${this.state.count} times`;\n" +
                    "  }\n" +
                    "\n" +
                    "  componentWillUnmount() {\n" +
                    "    ChatAPI.unsubscribeFromFriendStatus(\n" +
                    "      this.props.friend.id,\n" +
                    "      this.handleStatusChange\n" +
                    "    );\n" +
                    "  }\n" +
                    "\n" +
                    "  handleStatusChange(status) {\n" +
                    "    this.setState({\n" +
                    "      isOnline: status.isOnline\n" +
                    "    });\n" +
                    "  }\n" +
                    "  // ...\n" +
                    "Note how the logic that sets document.title is split between componentDidMount and componentDidUpdate. The subscription logic is also spread between componentDidMount and componentWillUnmount. And componentDidMount contains code for both tasks.\n" +
                    "\n" +
                    "So, how can Hooks solve this problem? Just like you can use the State Hook more than once, you can also use several effects. This lets us separate unrelated logic into different effects:\n" +
                    "\n" +
                    "function FriendStatusWithCounter(props) {\n" +
                    "  const [count, setCount] = useState(0);\n" +
                    "  useEffect(() => {\n" +
                    "    document.title = `You clicked ${count} times`;\n" +
                    "  });\n" +
                    "\n" +
                    "  const [isOnline, setIsOnline] = useState(null);\n" +
                    "  useEffect(() => {\n" +
                    "    ChatAPI.subscribeToFriendStatus(props.friend.id, handleStatusChange);\n" +
                    "    return () => {\n" +
                    "      ChatAPI.unsubscribeFromFriendStatus(props.friend.id, handleStatusChange);\n" +
                    "    };\n" +
                    "  });\n" +
                    "\n" +
                    "  function handleStatusChange(status) {\n" +
                    "    setIsOnline(status.isOnline);\n" +
                    "  }\n" +
                    "  // ...\n" +
                    "}\n" +
                    "Hooks lets us split the code based on what it is doing rather than a lifecycle method name. React will apply every effect used by the component, in the order they were specified.\n" +
                    "\n" +
                    "Explanation: Why Effects Run on Each Update\n" +
                    "If you’re used to classes, you might be wondering why the effect cleanup phase happens after every re-render, and not just once during unmounting. Let’s look at a practical example to see why this design helps us create components with fewer bugs.\n" +
                    "\n" +
                    "Earlier on this page, we introduced an example FriendStatus component that displays whether a friend is online or not. Our class reads friend.id from this.props, subscribes to the friend status after the component mounts, and unsubscribes during unmounting:\n" +
                    "\n" +
                    "  componentDidMount() {\n" +
                    "    ChatAPI.subscribeToFriendStatus(\n" +
                    "      this.props.friend.id,\n" +
                    "      this.handleStatusChange\n" +
                    "    );\n" +
                    "  }\n" +
                    "\n" +
                    "  componentWillUnmount() {\n" +
                    "    ChatAPI.unsubscribeFromFriendStatus(\n" +
                    "      this.props.friend.id,\n" +
                    "      this.handleStatusChange\n" +
                    "    );\n" +
                    "  }\n" +
                    "But what happens if the friend prop changes while the component is on the screen? Our component would continue displaying the online status of a different friend. This is a bug. We would also cause a memory leak or crash when unmounting since the unsubscribe call would use the wrong friend ID.\n" +
                    "\n" +
                    "In a class component, we would need to add componentDidUpdate to handle this case:\n" +
                    "\n" +
                    "  componentDidMount() {\n" +
                    "    ChatAPI.subscribeToFriendStatus(\n" +
                    "      this.props.friend.id,\n" +
                    "      this.handleStatusChange\n" +
                    "    );\n" +
                    "  }\n" +
                    "\n" +
                    "  componentDidUpdate(prevProps) {\n" +
                    "    // Unsubscribe from the previous friend.id\n" +
                    "    ChatAPI.unsubscribeFromFriendStatus(\n" +
                    "      prevProps.friend.id,\n" +
                    "      this.handleStatusChange\n" +
                    "    );\n" +
                    "    // Subscribe to the next friend.id\n" +
                    "    ChatAPI.subscribeToFriendStatus(\n" +
                    "      this.props.friend.id,\n" +
                    "      this.handleStatusChange\n" +
                    "    );\n" +
                    "  }\n" +
                    "\n" +
                    "  componentWillUnmount() {\n" +
                    "    ChatAPI.unsubscribeFromFriendStatus(\n" +
                    "      this.props.friend.id,\n" +
                    "      this.handleStatusChange\n" +
                    "    );\n" +
                    "  }\n" +
                    "Forgetting to handle componentDidUpdate properly is a common source of bugs in React applications.\n" +
                    "\n" +
                    "Now consider the version of this component that uses Hooks:\n" +
                    "\n" +
                    "function FriendStatus(props) {\n" +
                    "  // ...\n" +
                    "  useEffect(() => {\n" +
                    "    ChatAPI.subscribeToFriendStatus(props.friend.id, handleStatusChange);\n" +
                    "    return () => {\n" +
                    "      ChatAPI.unsubscribeFromFriendStatus(props.friend.id, handleStatusChange);\n" +
                    "    };\n" +
                    "  });\n" +
                    "It doesn’t suffer from this bug. (But we also didn’t make any changes to it.)\n" +
                    "\n" +
                    "There is no special code for handling updates because useEffect handles them by default. It cleans up the previous effects before applying the next effects. To illustrate this, here is a sequence of subscribe and unsubscribe calls that this component could produce over time:\n" +
                    "\n" +
                    "// Mount with { friend: { id: 100 } } props\n" +
                    "ChatAPI.subscribeToFriendStatus(100, handleStatusChange);     // Run first effect\n" +
                    "\n" +
                    "// Update with { friend: { id: 200 } } props\n" +
                    "ChatAPI.unsubscribeFromFriendStatus(100, handleStatusChange); // Clean up previous effect\n" +
                    "ChatAPI.subscribeToFriendStatus(200, handleStatusChange);     // Run next effect\n" +
                    "\n" +
                    "// Update with { friend: { id: 300 } } props\n" +
                    "ChatAPI.unsubscribeFromFriendStatus(200, handleStatusChange); // Clean up previous effect\n" +
                    "ChatAPI.subscribeToFriendStatus(300, handleStatusChange);     // Run next effect\n" +
                    "\n" +
                    "// Unmount\n" +
                    "ChatAPI.unsubscribeFromFriendStatus(300, handleStatusChange); // Clean up last effect\n" +
                    "This behavior ensures consistency by default and prevents bugs that are common in class components due to missing update logic.\n" +
                    "\n" +
                    "Tip: Optimizing Performance by Skipping Effects\n" +
                    "In some cases, cleaning up or applying the effect after every render might create a performance problem. In class components, we can solve this by writing an extra comparison with prevProps or prevState inside componentDidUpdate:\n" +
                    "\n" +
                    "componentDidUpdate(prevProps, prevState) {\n" +
                    "  if (prevState.count !== this.state.count) {\n" +
                    "    document.title = `You clicked ${this.state.count} times`;\n" +
                    "  }\n" +
                    "}\n" +
                    "This requirement is common enough that it is built into the useEffect Hook API. You can tell React to skip applying an effect if certain values haven’t changed between re-renders. To do so, pass an array as an optional second argument to useEffect:\n" +
                    "\n" +
                    "useEffect(() => {\n" +
                    "  document.title = `You clicked ${count} times`;\n" +
                    "}, [count]); // Only re-run the effect if count changes\n" +
                    "In the example above, we pass [count] as the second argument. What does this mean? If the count is 5, and then our component re-renders with count still equal to 5, React will compare [5] from the previous render and [5] from the next render. Because all items in the array are the same (5 === 5), React would skip the effect. That’s our optimization.\n" +
                    "\n" +
                    "When we render with count updated to 6, React will compare the items in the [5] array from the previous render to items in the [6] array from the next render. This time, React will re-apply the effect because 5 !== 6. If there are multiple items in the array, React will re-run the effect even if just one of them is different.\n" +
                    "\n" +
                    "This also works for effects that have a cleanup phase:\n" +
                    "\n" +
                    "useEffect(() => {\n" +
                    "  ChatAPI.subscribeToFriendStatus(props.friend.id, handleStatusChange);\n" +
                    "  return () => {\n" +
                    "    ChatAPI.unsubscribeFromFriendStatus(props.friend.id, handleStatusChange);\n" +
                    "  };\n" +
                    "}, [props.friend.id]); // Only re-subscribe if props.friend.id changes\n" +
                    "In the future, the second argument might get added automatically by a build-time transformation.\n" +
                    "\n" +
                    "Note\n" +
                    "\n" +
                    "If you use this optimization, make sure the array includes any values from the outer scope that change over time and that are used by the effect. Otherwise, your code will reference stale values from previous renders. We’ll also discuss other optimization options in the Hooks API reference.\n" +
                    "\n" +
                    "If you want to run an effect and clean it up only once (on mount and unmount), you can pass an empty array ([]) as a second argument. This tells React that your effect doesn’t depend on any values from props or state, so it never needs to re-run. This isn’t handled as a special case — it follows directly from how the inputs array always works. While passing [] is closer to the familiar componentDidMount and componentWillUnmount mental model, we suggest not making it a habit because it often leads to bugs, as discussed above. Don’t forget that React defers running useEffect until after the browser has painted, so doing extra work is less of a problem.\n" +
                    "\n");
            sec4React4.setLesson(reactJsLesson4);
            reactJsLesson4.getSections().add(sec4React4);

            Section sec5React4 = new Section();
            sec5React4.setOrdinalNumber(5);
            sec5React4.setDescription("Rules of Hooks");
            sec5React4.setContent("Hook");
            sec5React4.setLesson(reactJsLesson4);
            reactJsLesson4.getSections().add(sec5React4);


                        Section sec1Vue1 = new Section();
            sec1Vue1.setOrdinalNumber(1);
            sec1Vue1.setDescription("Template Syntax");
            sec1Vue1.setContent("<p>Vue.js uses an HTML-based template syntax that allows you to declaratively bind the rendered DOM to the underlying Vue instance&rsquo;s data. All Vue.js templates are valid HTML that can be parsed by spec-compliant browsers and HTML parsers.</p>\n" +
                    "<p>Under the hood, Vue compiles the templates into Virtual DOM render functions. Combined with the reactivity system, Vue is able to intelligently figure out the minimal number of components to re-render and apply the minimal amount of DOM manipulations when the app state changes.</p>\n" +
                    "<p>If you are familiar with Virtual DOM concepts and prefer the raw power of JavaScript, you can also&nbsp;<a href=\"https://vuejs.org/v2/guide/render-function.html\">directly write render functions</a>&nbsp;instead of templates, with optional JSX support.</p>\n" +
                    "<h2 id=\"Interpolations\"><a class=\"headerlink\" title=\"Interpolations\" href=\"https://vuejs.org/v2/guide/syntax.html#Interpolations\" data-scroll=\"\">Interpolations</a></h2>\n" +
                    "<h3 id=\"Text\"><a class=\"headerlink\" title=\"Text\" href=\"https://vuejs.org/v2/guide/syntax.html#Text\" data-scroll=\"\">Text</a></h3>\n" +
                    "<p>The most basic form of data binding is text interpolation using the &ldquo;Mustache&rdquo; syntax (double curly braces):</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">span</span>&gt;</span>Message: {{ msg }}<span class=\"tag\">&lt;/<span class=\"name\">span</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>The mustache tag will be replaced with the value of the&nbsp;<code>msg</code>&nbsp;property on the corresponding data object. It will also be updated whenever the data object&rsquo;s&nbsp;<code>msg</code>property changes.</p>\n" +
                    "<p>You can also perform one-time interpolations that do not update on data change by using the&nbsp;<a href=\"https://vuejs.org/v2/api/#v-once\">v-once directive</a>, but keep in mind this will also affect any other bindings on the same node:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">span</span> <span class=\"attr\">v-once</span>&gt;</span>This will never change: {{ msg }}<span class=\"tag\">&lt;/<span class=\"name\">span</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<h3 id=\"Raw-HTML\"><a class=\"headerlink\" title=\"Raw HTML\" href=\"https://vuejs.org/v2/guide/syntax.html#Raw-HTML\" data-scroll=\"\">Raw HTML</a></h3>\n" +
                    "<p>The double mustaches interprets the data as plain text, not HTML. In order to output real HTML, you will need to use the&nbsp;<code>v-html</code>&nbsp;directive:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">p</span>&gt;</span>Using mustaches: {{ rawHtml }}<span class=\"tag\">&lt;/<span class=\"name\">p</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">p</span>&gt;</span>Using v-html directive: <span class=\"tag\">&lt;<span class=\"name\">span</span> <span class=\"attr\">v-html</span>=<span class=\"string\">\"rawHtml\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">span</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">p</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<div id=\"example1\" class=\"demo\">\n" +
                    "<p>Using mustaches: &lt;span style=\"color: red\"&gt;This should be red.&lt;/span&gt;</p>\n" +
                    "<p>Using v-html directive:&nbsp;This should be red.</p>\n" +
                    "</div>\n" +
                    "<p>The contents of the&nbsp;<code>span</code>&nbsp;will be replaced with the value of the&nbsp;<code>rawHtml</code>&nbsp;property, interpreted as plain HTML - data bindings are ignored. Note that you cannot use&nbsp;<code>v-html</code>&nbsp;to compose template partials, because Vue is not a string-based templating engine. Instead, components are preferred as the fundamental unit for UI reuse and composition.</p>\n" +
                    "<p class=\"tip\">Dynamically rendering arbitrary HTML on your website can be very dangerous because it can easily lead to&nbsp;<a href=\"https://en.wikipedia.org/wiki/Cross-site_scripting\" target=\"_blank\" rel=\"noopener\">XSS vulnerabilities</a>. Only use HTML interpolation on trusted content and&nbsp;<strong>never</strong>&nbsp;on user-provided content.</p>\n" +
                    "<h3 id=\"Attributes\"><a class=\"headerlink\" title=\"Attributes\" href=\"https://vuejs.org/v2/guide/syntax.html#Attributes\" data-scroll=\"\">Attributes</a></h3>\n" +
                    "<p>Mustaches cannot be used inside HTML attributes. Instead, use a&nbsp;<a href=\"https://vuejs.org/v2/api/#v-bind\">v-bind directive</a>:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">v-bind:id</span>=<span class=\"string\">\"dynamicId\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>In the case of boolean attributes, where their mere existence implies&nbsp;<code>true</code>,&nbsp;<code>v-bind</code>works a little differently. In this example:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">button</span> <span class=\"attr\">v-bind:disabled</span>=<span class=\"string\">\"isButtonDisabled\"</span>&gt;</span>Button<span class=\"tag\">&lt;/<span class=\"name\">button</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>If&nbsp;<code>isButtonDisabled</code>&nbsp;has the value of&nbsp;<code>null</code>,&nbsp;<code>undefined</code>, or&nbsp;<code>false</code>, the&nbsp;<code>disabled</code>attribute will not even be included in the rendered&nbsp;<code>&lt;button&gt;</code>&nbsp;element.</p>\n" +
                    "<h3 id=\"Using-JavaScript-Expressions\"><a class=\"headerlink\" title=\"Using JavaScript Expressions\" href=\"https://vuejs.org/v2/guide/syntax.html#Using-JavaScript-Expressions\" data-scroll=\"\">Using JavaScript Expressions</a></h3>\n" +
                    "<p>So far we&rsquo;ve only been binding to simple property keys in our templates. But Vue.js actually supports the full power of JavaScript expressions inside all data bindings:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\">{{ number + 1 }}</span><br /><br /><span class=\"line\">{{ ok ? 'YES' : 'NO' }}</span><br /><br /><span class=\"line\">{{ message.split('').reverse().join('') }}</span><br /><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">v-bind:id</span>=<span class=\"string\">\"'list-' + id\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>These expressions will be evaluated as JavaScript in the data scope of the owner Vue instance. One restriction is that each binding can only contain&nbsp;<strong>one single expression</strong>, so the following will&nbsp;<strong>NOT</strong>&nbsp;work:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"comment\">&lt;!-- this is a statement, not an expression: --&gt;</span></span><br /><span class=\"line\">{{ var a = 1 }}</span><br /><br /><span class=\"line\"><span class=\"comment\">&lt;!-- flow control won't work either, use ternary expressions --&gt;</span></span><br /><span class=\"line\">{{ if (ok) { return message } }}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p class=\"tip\">Template expressions are sandboxed and only have access to a whitelist of globals such as&nbsp;<code>Math</code>&nbsp;and&nbsp;<code>Date</code>. You should not attempt to access user defined globals in template expressions.</p>\n" +
                    "<h2 id=\"Directives\"><a class=\"headerlink\" title=\"Directives\" href=\"https://vuejs.org/v2/guide/syntax.html#Directives\" data-scroll=\"\">Directives</a></h2>\n" +
                    "<p>Directives are special attributes with the&nbsp;<code>v-</code>&nbsp;prefix. Directive attribute values are expected to be&nbsp;<strong>a single JavaScript expression</strong>&nbsp;(with the exception of&nbsp;<code>v-for</code>, which will be discussed later). A directive&rsquo;s job is to reactively apply side effects to the DOM when the value of its expression changes. Let&rsquo;s review the example we saw in the introduction:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">p</span> <span class=\"attr\">v-if</span>=<span class=\"string\">\"seen\"</span>&gt;</span>Now you see me<span class=\"tag\">&lt;/<span class=\"name\">p</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Here, the&nbsp;<code>v-if</code>&nbsp;directive would remove/insert the&nbsp;<code>&lt;p&gt;</code>&nbsp;element based on the truthiness of the value of the expression&nbsp;<code>seen</code>.</p>\n" +
                    "<h3 id=\"Arguments\"><a class=\"headerlink\" title=\"Arguments\" href=\"https://vuejs.org/v2/guide/syntax.html#Arguments\" data-scroll=\"\">Arguments</a></h3>\n" +
                    "<p>Some directives can take an &ldquo;argument&rdquo;, denoted by a colon after the directive name. For example, the&nbsp;<code>v-bind</code>&nbsp;directive is used to reactively update an HTML attribute:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">a</span> <span class=\"attr\">v-bind:href</span>=<span class=\"string\">\"url\"</span>&gt;</span> ... <span class=\"tag\">&lt;/<span class=\"name\">a</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Here&nbsp;<code>href</code>&nbsp;is the argument, which tells the&nbsp;<code>v-bind</code>&nbsp;directive to bind the element&rsquo;s&nbsp;<code>href</code>&nbsp;attribute to the value of the expression&nbsp;<code>url</code>.</p>\n" +
                    "<p>Another example is the&nbsp;<code>v-on</code>&nbsp;directive, which listens to DOM events:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">a</span> <span class=\"attr\">v-on:click</span>=<span class=\"string\">\"doSomething\"</span>&gt;</span> ... <span class=\"tag\">&lt;/<span class=\"name\">a</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Here the argument is the event name to listen to. We will talk about event handling in more detail too.</p>\n" +
                    "<h3 id=\"Modifiers\"><a class=\"headerlink\" title=\"Modifiers\" href=\"https://vuejs.org/v2/guide/syntax.html#Modifiers\" data-scroll=\"\">Modifiers</a></h3>\n" +
                    "<p>Modifiers are special postfixes denoted by a dot, which indicate that a directive should be bound in some special way. For example, the&nbsp;<code>.prevent</code>&nbsp;modifier tells the&nbsp;<code>v-on</code>directive to call&nbsp;<code>event.preventDefault()</code>&nbsp;on the triggered event:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">form</span> <span class=\"attr\">v-on:submit.prevent</span>=<span class=\"string\">\"onSubmit\"</span>&gt;</span> ... <span class=\"tag\">&lt;/<span class=\"name\">form</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>You&rsquo;ll see other examples of modifiers later,&nbsp;<a href=\"https://vuejs.org/v2/guide/events.html#Event-Modifiers\">for&nbsp;<code>v-on</code></a>&nbsp;and&nbsp;<a href=\"https://vuejs.org/v2/guide/forms.html#Modifiers\">for&nbsp;<code>v-model</code></a>, when we explore those features.</p>\n" +
                    "<h2 id=\"Shorthands\"><a class=\"headerlink\" title=\"Shorthands\" href=\"https://vuejs.org/v2/guide/syntax.html#Shorthands\" data-scroll=\"\">Shorthands</a></h2>\n" +
                    "<p>The&nbsp;<code>v-</code>&nbsp;prefix serves as a visual cue for identifying Vue-specific attributes in your templates. This is useful when you are using Vue.js to apply dynamic behavior to some existing markup, but can feel verbose for some frequently used directives. At the same time, the need for the&nbsp;<code>v-</code>&nbsp;prefix becomes less important when you are building a&nbsp;<a href=\"https://en.wikipedia.org/wiki/Single-page_application\" target=\"_blank\" rel=\"noopener\">SPA</a>where Vue.js manages every template. Therefore, Vue.js provides special shorthands for two of the most often used directives,&nbsp;<code>v-bind</code>&nbsp;and&nbsp;<code>v-on</code>:</p>\n" +
                    "<h3 id=\"v-bind-Shorthand\"><a class=\"headerlink\" title=\"v-bind Shorthand\" href=\"https://vuejs.org/v2/guide/syntax.html#v-bind-Shorthand\" data-scroll=\"\"><code>v-bind</code>&nbsp;Shorthand</a></h3>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"comment\">&lt;!-- full syntax --&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">a</span> <span class=\"attr\">v-bind:href</span>=<span class=\"string\">\"url\"</span>&gt;</span> ... <span class=\"tag\">&lt;/<span class=\"name\">a</span>&gt;</span></span><br /><br /><span class=\"line\"><span class=\"comment\">&lt;!-- shorthand --&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">a</span> <span class=\"attr\">:href</span>=<span class=\"string\">\"url\"</span>&gt;</span> ... <span class=\"tag\">&lt;/<span class=\"name\">a</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<h3 id=\"v-on-Shorthand\"><a class=\"headerlink\" title=\"v-on Shorthand\" href=\"https://vuejs.org/v2/guide/syntax.html#v-on-Shorthand\" data-scroll=\"\"><code>v-on</code>&nbsp;Shorthand</a></h3>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"comment\">&lt;!-- full syntax --&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">a</span> <span class=\"attr\">v-on:click</span>=<span class=\"string\">\"doSomething\"</span>&gt;</span> ... <span class=\"tag\">&lt;/<span class=\"name\">a</span>&gt;</span></span><br /><br /><span class=\"line\"><span class=\"comment\">&lt;!-- shorthand --&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">a</span> @<span class=\"attr\">click</span>=<span class=\"string\">\"doSomething\"</span>&gt;</span> ... <span class=\"tag\">&lt;/<span class=\"name\">a</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>They may look a bit different from normal HTML, but&nbsp;<code>:</code>&nbsp;and&nbsp;<code>@</code>&nbsp;are valid chars for attribute names and all Vue.js supported browsers can parse it correctly. In addition, they do not appear in the final rendered markup. The shorthand syntax is totally optional, but you will likely appreciate it when you learn more about its usage later.</p>");
            sec1Vue1.setLesson(vueJsLesson1);
            vueJsLesson1.getSections().add(sec1Vue1);

            Section sec2Vue1 = new Section();
            sec2Vue1.setOrdinalNumber(2);
            sec2Vue1.setDescription("Computed Properties and Watchers");
            sec2Vue1.setContent("<p>In-template expressions are very convenient, but they are meant for simple operations. Putting too much logic in your templates can make them bloated and hard to maintain. For example:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">id</span>=<span class=\"string\">\"example\"</span>&gt;</span></span><br /><span class=\"line\">  {{ message.split('').reverse().join('') }}</span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>At this point, the template is no longer simple and declarative. You have to look at it for a second before realizing that it displays&nbsp;<code>message</code>&nbsp;in reverse. The problem is made worse when you want to include the reversed message in your template more than once.</p>\n" +
                    "<p>That&rsquo;s why for any complex logic, you should use a&nbsp;<strong>computed property</strong>.</p>\n" +
                    "<h3 id=\"Basic-Example\"><a class=\"headerlink\" title=\"Basic Example\" href=\"https://vuejs.org/v2/guide/computed.html#Basic-Example\" data-scroll=\"\">Basic Example</a></h3>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">id</span>=<span class=\"string\">\"example\"</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">p</span>&gt;</span>Original message: \"{{ message }}\"<span class=\"tag\">&lt;/<span class=\"name\">p</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">p</span>&gt;</span>Computed reversed message: \"{{ reversedMessage }}\"<span class=\"tag\">&lt;/<span class=\"name\">p</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"keyword\">var</span> vm = <span class=\"keyword\">new</span> Vue({</span><br /><span class=\"line\">  el: <span class=\"string\">'#example'</span>,</span><br /><span class=\"line\">  data: {</span><br /><span class=\"line\">    message: <span class=\"string\">'Hello'</span></span><br /><span class=\"line\">  },</span><br /><span class=\"line\">  computed: {</span><br /><span class=\"line\">    <span class=\"comment\">// a computed getter</span></span><br /><span class=\"line\">    reversedMessage: <span class=\"function\"><span class=\"keyword\">function</span> () </span>{</span><br /><span class=\"line\">      <span class=\"comment\">// `this` points to the vm instance</span></span><br /><span class=\"line\">      <span class=\"keyword\">return</span> <span class=\"keyword\">this</span>.message.split(<span class=\"string\">''</span>).reverse().join(<span class=\"string\">''</span>)</span><br /><span class=\"line\">    }</span><br /><span class=\"line\">  }</span><br /><span class=\"line\">})</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Result:</p>\n" +
                    "<div id=\"example\" class=\"demo\">\n" +
                    "<p>Original message: \"Hello\"</p>\n" +
                    "<p>Computed reversed message: \"olleH\"</p>\n" +
                    "</div>\n" +
                    "<p>Here we have declared a computed property&nbsp;<code>reversedMessage</code>. The function we provided will be used as the getter function for the property&nbsp;<code>vm.reversedMessage</code>:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"built_in\">console</span>.log(vm.reversedMessage) <span class=\"comment\">// =&gt; 'olleH'</span></span><br /><span class=\"line\">vm.message = <span class=\"string\">'Goodbye'</span></span><br /><span class=\"line\"><span class=\"built_in\">console</span>.log(vm.reversedMessage) <span class=\"comment\">// =&gt; 'eybdooG'</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>You can open the console and play with the example vm yourself. The value of&nbsp;<code>vm.reversedMessage</code>&nbsp;is always dependent on the value of&nbsp;<code>vm.message</code>.</p>\n" +
                    "<p>You can data-bind to computed properties in templates just like a normal property. Vue is aware that&nbsp;<code>vm.reversedMessage</code>&nbsp;depends on&nbsp;<code>vm.message</code>, so it will update any bindings that depend on&nbsp;<code>vm.reversedMessage</code>&nbsp;when&nbsp;<code>vm.message</code>&nbsp;changes. And the best part is that we&rsquo;ve created this dependency relationship declaratively: the computed getter function has no side effects, which makes it easier to test and understand.</p>\n" +
                    "<h3 id=\"Computed-Caching-vs-Methods\"><a class=\"headerlink\" title=\"Computed Caching vs Methods\" href=\"https://vuejs.org/v2/guide/computed.html#Computed-Caching-vs-Methods\" data-scroll=\"\">Computed Caching vs Methods</a></h3>\n" +
                    "<p>You may have noticed we can achieve the same result by invoking a method in the expression:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">p</span>&gt;</span>Reversed message: \"{{ reverseMessage() }}\"<span class=\"tag\">&lt;/<span class=\"name\">p</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"comment\">// in component</span></span><br /><span class=\"line\">methods: {</span><br /><span class=\"line\">  reverseMessage: <span class=\"function\"><span class=\"keyword\">function</span> () </span>{</span><br /><span class=\"line\">    <span class=\"keyword\">return</span> <span class=\"keyword\">this</span>.message.split(<span class=\"string\">''</span>).reverse().join(<span class=\"string\">''</span>)</span><br /><span class=\"line\">  }</span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Instead of a computed property, we can define the same function as a method instead. For the end result, the two approaches are indeed exactly the same. However, the difference is that&nbsp;<strong>computed properties are cached based on their dependencies.</strong>&nbsp;A computed property will only re-evaluate when some of its dependencies have changed. This means as long as&nbsp;<code>message</code>&nbsp;has not changed, multiple access to the&nbsp;<code>reversedMessage</code>&nbsp;computed property will immediately return the previously computed result without having to run the function again.</p>\n" +
                    "<p>This also means the following computed property will never update, because&nbsp;<code>Date.now()</code>&nbsp;is not a reactive dependency:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\">computed: {</span><br /><span class=\"line\">  now: <span class=\"function\"><span class=\"keyword\">function</span> () </span>{</span><br /><span class=\"line\">    <span class=\"keyword\">return</span> <span class=\"built_in\">Date</span>.now()</span><br /><span class=\"line\">  }</span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>In comparison, a method invocation will&nbsp;<strong>always</strong>&nbsp;run the function whenever a re-render happens.</p>\n" +
                    "<p>Why do we need caching? Imagine we have an expensive computed property&nbsp;<strong>A</strong>, which requires looping through a huge Array and doing a lot of computations. Then we may have other computed properties that in turn depend on&nbsp;<strong>A</strong>. Without caching, we would be executing&nbsp;<strong>A</strong>&rsquo;s getter many more times than necessary! In cases where you do not want caching, use a method instead.</p>\n" +
                    "<h3 id=\"Computed-vs-Watched-Property\"><a class=\"headerlink\" title=\"Computed vs Watched Property\" href=\"https://vuejs.org/v2/guide/computed.html#Computed-vs-Watched-Property\" data-scroll=\"\">Computed vs Watched Property</a></h3>\n" +
                    "<p>Vue does provide a more generic way to observe and react to data changes on a Vue instance:&nbsp;<strong>watch properties</strong>. When you have some data that needs to change based on some other data, it is tempting to overuse&nbsp;<code>watch</code>&nbsp;- especially if you are coming from an AngularJS background. However, it is often a better idea to use a computed property rather than an imperative&nbsp;<code>watch</code>&nbsp;callback. Consider this example:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">id</span>=<span class=\"string\">\"demo\"</span>&gt;</span>{{ fullName }}<span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"keyword\">var</span> vm = <span class=\"keyword\">new</span> Vue({</span><br /><span class=\"line\">  el: <span class=\"string\">'#demo'</span>,</span><br /><span class=\"line\">  data: {</span><br /><span class=\"line\">    firstName: <span class=\"string\">'Foo'</span>,</span><br /><span class=\"line\">    lastName: <span class=\"string\">'Bar'</span>,</span><br /><span class=\"line\">    fullName: <span class=\"string\">'Foo Bar'</span></span><br /><span class=\"line\">  },</span><br /><span class=\"line\">  watch: {</span><br /><span class=\"line\">    firstName: <span class=\"function\"><span class=\"keyword\">function</span> (<span class=\"params\">val</span>) </span>{</span><br /><span class=\"line\">      <span class=\"keyword\">this</span>.fullName = val + <span class=\"string\">' '</span> + <span class=\"keyword\">this</span>.lastName</span><br /><span class=\"line\">    },</span><br /><span class=\"line\">    lastName: <span class=\"function\"><span class=\"keyword\">function</span> (<span class=\"params\">val</span>) </span>{</span><br /><span class=\"line\">      <span class=\"keyword\">this</span>.fullName = <span class=\"keyword\">this</span>.firstName + <span class=\"string\">' '</span> + val</span><br /><span class=\"line\">    }</span><br /><span class=\"line\">  }</span><br /><span class=\"line\">})</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>The above code is imperative and repetitive. Compare it with a computed property version:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"keyword\">var</span> vm = <span class=\"keyword\">new</span> Vue({</span><br /><span class=\"line\">  el: <span class=\"string\">'#demo'</span>,</span><br /><span class=\"line\">  data: {</span><br /><span class=\"line\">    firstName: <span class=\"string\">'Foo'</span>,</span><br /><span class=\"line\">    lastName: <span class=\"string\">'Bar'</span></span><br /><span class=\"line\">  },</span><br /><span class=\"line\">  computed: {</span><br /><span class=\"line\">    fullName: <span class=\"function\"><span class=\"keyword\">function</span> () </span>{</span><br /><span class=\"line\">      <span class=\"keyword\">return</span> <span class=\"keyword\">this</span>.firstName + <span class=\"string\">' '</span> + <span class=\"keyword\">this</span>.lastName</span><br /><span class=\"line\">    }</span><br /><span class=\"line\">  }</span><br /><span class=\"line\">})</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Much better, isn&rsquo;t it?</p>\n" +
                    "<h3 id=\"Computed-Setter\"><a class=\"headerlink\" title=\"Computed Setter\" href=\"https://vuejs.org/v2/guide/computed.html#Computed-Setter\" data-scroll=\"\">Computed Setter</a></h3>\n" +
                    "<p>Computed properties are by default getter-only, but you can also provide a setter when you need it:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"comment\">// ...</span></span><br /><span class=\"line\">computed: {</span><br /><span class=\"line\">  fullName: {</span><br /><span class=\"line\">    <span class=\"comment\">// getter</span></span><br /><span class=\"line\">    get: <span class=\"function\"><span class=\"keyword\">function</span> () </span>{</span><br /><span class=\"line\">      <span class=\"keyword\">return</span> <span class=\"keyword\">this</span>.firstName + <span class=\"string\">' '</span> + <span class=\"keyword\">this</span>.lastName</span><br /><span class=\"line\">    },</span><br /><span class=\"line\">    <span class=\"comment\">// setter</span></span><br /><span class=\"line\">    set: <span class=\"function\"><span class=\"keyword\">function</span> (<span class=\"params\">newValue</span>) </span>{</span><br /><span class=\"line\">      <span class=\"keyword\">var</span> names = newValue.split(<span class=\"string\">' '</span>)</span><br /><span class=\"line\">      <span class=\"keyword\">this</span>.firstName = names[<span class=\"number\">0</span>]</span><br /><span class=\"line\">      <span class=\"keyword\">this</span>.lastName = names[names.length - <span class=\"number\">1</span>]</span><br /><span class=\"line\">    }</span><br /><span class=\"line\">  }</span><br /><span class=\"line\">}</span><br /><span class=\"line\"><span class=\"comment\">// ...</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Now when you run&nbsp;<code>vm.fullName = 'John Doe'</code>, the setter will be invoked and&nbsp;<code>vm.firstName</code>&nbsp;and&nbsp;<code>vm.lastName</code>&nbsp;will be updated accordingly.</p>");
            sec2Vue1.setLesson(vueJsLesson1);
            vueJsLesson1.getSections().add(sec2Vue1);

            Section sec3Vue1 = new Section();
            sec3Vue1.setOrdinalNumber(3);
            sec3Vue1.setDescription("Class and Style Bindings");
            sec3Vue1.setContent("<h2 id=\"Binding-HTML-Classes\"><a class=\"headerlink\" title=\"Binding HTML Classes\" href=\"https://vuejs.org/v2/guide/class-and-style.html#Binding-HTML-Classes\" data-scroll=\"\">Binding HTML Classes</a></h2>\n" +
                    "<h3 id=\"Object-Syntax\"><a class=\"headerlink\" title=\"Object Syntax\" href=\"https://vuejs.org/v2/guide/class-and-style.html#Object-Syntax\" data-scroll=\"\">Object Syntax</a></h3>\n" +
                    "<p>We can pass an object to&nbsp;<code>v-bind:class</code>&nbsp;to dynamically toggle classes:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">v-bind:class</span>=<span class=\"string\">\"{ active: isActive }\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>The above syntax means the presence of the&nbsp;<code>active</code>&nbsp;class will be determined by the&nbsp;<a href=\"https://developer.mozilla.org/en-US/docs/Glossary/Truthy\" target=\"_blank\" rel=\"noopener\">truthiness</a>&nbsp;of the data property&nbsp;<code>isActive</code>.</p>\n" +
                    "<p>You can have multiple classes toggled by having more fields in the object. In addition, the&nbsp;<code>v-bind:class</code>&nbsp;directive can also co-exist with the plain&nbsp;<code>class</code>&nbsp;attribute. So given the following template:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">class</span>=<span class=\"string\">\"static\"</span></span></span><br /><span class=\"line\"><span class=\"tag\">     <span class=\"attr\">v-bind:class</span>=<span class=\"string\">\"{ active: isActive, 'text-danger': hasError }\"</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>And the following data:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\">data: {</span><br /><span class=\"line\">  isActive: <span class=\"literal\">true</span>,</span><br /><span class=\"line\">  hasError: <span class=\"literal\">false</span></span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>It will render:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">class</span>=<span class=\"string\">\"static active\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>When&nbsp;<code>isActive</code>&nbsp;or&nbsp;<code>hasError</code>&nbsp;changes, the class list will be updated accordingly. For example, if&nbsp;<code>hasError</code>&nbsp;becomes&nbsp;<code>true</code>, the class list will become&nbsp;<code>\"static active text-danger\"</code>.</p>\n" +
                    "<p>The bound object doesn&rsquo;t have to be inline:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">v-bind:class</span>=<span class=\"string\">\"classObject\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\">data: {</span><br /><span class=\"line\">  classObject: {</span><br /><span class=\"line\">    active: <span class=\"literal\">true</span>,</span><br /><span class=\"line\">    <span class=\"string\">'text-danger'</span>: <span class=\"literal\">false</span></span><br /><span class=\"line\">  }</span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>This will render the same result. We can also bind to a&nbsp;<a href=\"https://vuejs.org/v2/guide/computed.html\">computed property</a>&nbsp;that returns an object. This is a common and powerful pattern:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">v-bind:class</span>=<span class=\"string\">\"classObject\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\">data: {</span><br /><span class=\"line\">  isActive: <span class=\"literal\">true</span>,</span><br /><span class=\"line\">  error: <span class=\"literal\">null</span></span><br /><span class=\"line\">},</span><br /><span class=\"line\">computed: {</span><br /><span class=\"line\">  classObject: <span class=\"function\"><span class=\"keyword\">function</span> () </span>{</span><br /><span class=\"line\">    <span class=\"keyword\">return</span> {</span><br /><span class=\"line\">      active: <span class=\"keyword\">this</span>.isActive &amp;&amp; !<span class=\"keyword\">this</span>.error,</span><br /><span class=\"line\">      <span class=\"string\">'text-danger'</span>: <span class=\"keyword\">this</span>.error &amp;&amp; <span class=\"keyword\">this</span>.error.type === <span class=\"string\">'fatal'</span></span><br /><span class=\"line\">    }</span><br /><span class=\"line\">  }</span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<h3 id=\"Array-Syntax\"><a class=\"headerlink\" title=\"Array Syntax\" href=\"https://vuejs.org/v2/guide/class-and-style.html#Array-Syntax\" data-scroll=\"\">Array Syntax</a></h3>\n" +
                    "<p>We can pass an array to&nbsp;<code>v-bind:class</code>&nbsp;to apply a list of classes:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">v-bind:class</span>=<span class=\"string\">\"[activeClass, errorClass]\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\">data: {</span><br /><span class=\"line\">  activeClass: <span class=\"string\">'active'</span>,</span><br /><span class=\"line\">  errorClass: <span class=\"string\">'text-danger'</span></span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Which will render:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">class</span>=<span class=\"string\">\"active text-danger\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>If you would like to also toggle a class in the list conditionally, you can do it with a ternary expression:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">v-bind:class</span>=<span class=\"string\">\"[isActive ? activeClass : '', errorClass]\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>This will always apply&nbsp;<code>errorClass</code>, but will only apply&nbsp;<code>activeClass</code>&nbsp;when&nbsp;<code>isActive</code>is truthy.</p>\n" +
                    "<p>However, this can be a bit verbose if you have multiple conditional classes. That&rsquo;s why it&rsquo;s also possible to use the object syntax inside array syntax:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">v-bind:class</span>=<span class=\"string\">\"[{ active: isActive }, errorClass]\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<h3 id=\"With-Components\"><a class=\"headerlink\" title=\"With Components\" href=\"https://vuejs.org/v2/guide/class-and-style.html#With-Components\" data-scroll=\"\">With Components</a></h3>\n" +
                    "<blockquote>\n" +
                    "<p>This section assumes knowledge of&nbsp;<a href=\"https://vuejs.org/v2/guide/components.html\">Vue Components</a>. Feel free to skip it and come back later.</p>\n" +
                    "</blockquote>\n" +
                    "<p>When you use the&nbsp;<code>class</code>&nbsp;attribute on a custom component, those classes will be added to the component&rsquo;s root element. Existing classes on this element will not be overwritten.</p>\n" +
                    "<p>For example, if you declare this component:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\">Vue.component(<span class=\"string\">'my-component'</span>, {</span><br /><span class=\"line\">  template: <span class=\"string\">'&lt;p class=\"foo bar\"&gt;Hi&lt;/p&gt;'</span></span><br /><span class=\"line\">})</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Then add some classes when using it:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">my-component</span> <span class=\"attr\">class</span>=<span class=\"string\">\"baz boo\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">my-component</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>The rendered HTML will be:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">p</span> <span class=\"attr\">class</span>=<span class=\"string\">\"foo bar baz boo\"</span>&gt;</span>Hi<span class=\"tag\">&lt;/<span class=\"name\">p</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>The same is true for class bindings:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">my-component</span> <span class=\"attr\">v-bind:class</span>=<span class=\"string\">\"{ active: isActive }\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">my-component</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>When&nbsp;<code>isActive</code>&nbsp;is truthy, the rendered HTML will be:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">p</span> <span class=\"attr\">class</span>=<span class=\"string\">\"foo bar active\"</span>&gt;</span>Hi<span class=\"tag\">&lt;/<span class=\"name\">p</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>");
            sec3Vue1.setLesson(vueJsLesson1);
            vueJsLesson1.getSections().add(sec3Vue1);

            Section sec4Vue1 = new Section();
            sec4Vue1.setOrdinalNumber(4);
            sec4Vue1.setDescription("Conditional Rendering");
            sec4Vue1.setContent("<h2 id=\"v-if\"><a class=\"headerlink\" title=\"v-if\" href=\"https://vuejs.org/v2/guide/conditional.html#v-if\" data-scroll=\"\"><code>v-if</code></a></h2>\n" +
                    "<p>In string templates, for example&nbsp;<a href=\"https://handlebarsjs.com/\" target=\"_blank\" rel=\"noopener\">Handlebars</a>, we would write a conditional block like this:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"comment\">&lt;!-- Handlebars template --&gt;</span></span><br /><span class=\"line\">{{#if ok}}</span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">h1</span>&gt;</span>Yes<span class=\"tag\">&lt;/<span class=\"name\">h1</span>&gt;</span></span><br /><span class=\"line\">{{/if}}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>In Vue, we use the&nbsp;<code>v-if</code>&nbsp;directive to achieve the same:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">h1</span> <span class=\"attr\">v-if</span>=<span class=\"string\">\"ok\"</span>&gt;</span>Yes<span class=\"tag\">&lt;/<span class=\"name\">h1</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>It is also possible to add an &ldquo;else block&rdquo; with&nbsp;<code>v-else</code>:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">h1</span> <span class=\"attr\">v-if</span>=<span class=\"string\">\"ok\"</span>&gt;</span>Yes<span class=\"tag\">&lt;/<span class=\"name\">h1</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">h1</span> <span class=\"attr\">v-else</span>&gt;</span>No<span class=\"tag\">&lt;/<span class=\"name\">h1</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<h3 id=\"Conditional-Groups-with-v-if-on-lt-template-gt\"><a class=\"headerlink\" style=\"text-decoration: none; color: #2c3e50; font-weight: 600; pointer-events: auto;\" title=\"Conditional Groups with v-if on &lt;template&gt;\" href=\"https://vuejs.org/v2/guide/conditional.html#Conditional-Groups-with-v-if-on-lt-template-gt\" data-scroll=\"\">Conditional Groups with&nbsp;<code>v-if</code>&nbsp;on&nbsp;<code>&lt;template&gt;</code></a></h3>\n" +
                    "<p>Because&nbsp;<code>v-if</code>&nbsp;is a directive, it has to be attached to a single element. But what if we want to toggle more than one element? In this case we can use&nbsp;<code>v-if</code>&nbsp;on a&nbsp;<code>&lt;template&gt;</code>&nbsp;element, which serves as an invisible wrapper. The final rendered result will not include the&nbsp;<code>&lt;template&gt;</code>&nbsp;element.</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">template</span> <span class=\"attr\">v-if</span>=<span class=\"string\">\"ok\"</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">h1</span>&gt;</span>Title<span class=\"tag\">&lt;/<span class=\"name\">h1</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">p</span>&gt;</span>Paragraph 1<span class=\"tag\">&lt;/<span class=\"name\">p</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">p</span>&gt;</span>Paragraph 2<span class=\"tag\">&lt;/<span class=\"name\">p</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">template</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<h3 id=\"v-else\"><a class=\"headerlink\" title=\"v-else\" href=\"https://vuejs.org/v2/guide/conditional.html#v-else\" data-scroll=\"\"><code>v-else</code></a></h3>\n" +
                    "<p>You can use the&nbsp;<code>v-else</code>&nbsp;directive to indicate an &ldquo;else block&rdquo; for&nbsp;<code>v-if</code>:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">v-if</span>=<span class=\"string\">\"Math.random() &gt; 0.5\"</span>&gt;</span></span><br /><span class=\"line\">  Now you see me</span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">v-else</span>&gt;</span></span><br /><span class=\"line\">  Now you don't</span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>A&nbsp;<code>v-else</code>&nbsp;element must immediately follow a&nbsp;<code>v-if</code>&nbsp;or a&nbsp;<code>v-else-if</code>&nbsp;element - otherwise it will not be recognized.</p>\n" +
                    "<h3 id=\"v-else-if\"><a class=\"headerlink\" title=\"v-else-if\" href=\"https://vuejs.org/v2/guide/conditional.html#v-else-if\" data-scroll=\"\"><code>v-else-if</code></a></h3>\n" +
                    "<blockquote>\n" +
                    "<p>New in 2.1.0+</p>\n" +
                    "</blockquote>\n" +
                    "<p>The&nbsp;<code>v-else-if</code>, as the name suggests, serves as an &ldquo;else if block&rdquo; for&nbsp;<code>v-if</code>. It can also be chained multiple times:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">v-if</span>=<span class=\"string\">\"type === 'A'\"</span>&gt;</span></span><br /><span class=\"line\">  A</span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">v-else-if</span>=<span class=\"string\">\"type === 'B'\"</span>&gt;</span></span><br /><span class=\"line\">  B</span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">v-else-if</span>=<span class=\"string\">\"type === 'C'\"</span>&gt;</span></span><br /><span class=\"line\">  C</span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">v-else</span>&gt;</span></span><br /><span class=\"line\">  Not A/B/C</span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Similar to&nbsp;<code>v-else</code>, a&nbsp;<code>v-else-if</code>&nbsp;element must immediately follow a&nbsp;<code>v-if</code>&nbsp;or a&nbsp;<code>v-else-if</code>&nbsp;element.</p>\n" +
                    "<h3 id=\"Controlling-Reusable-Elements-with-key\"><a class=\"headerlink\" title=\"Controlling Reusable Elements with key\" href=\"https://vuejs.org/v2/guide/conditional.html#Controlling-Reusable-Elements-with-key\" data-scroll=\"\">Controlling Reusable Elements with&nbsp;<code>key</code></a></h3>\n" +
                    "<p>Vue tries to render elements as efficiently as possible, often re-using them instead of rendering from scratch. Beyond helping make Vue very fast, this can have some useful advantages. For example, if you allow users to toggle between multiple login types:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">template</span> <span class=\"attr\">v-if</span>=<span class=\"string\">\"loginType === 'username'\"</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">label</span>&gt;</span>Username<span class=\"tag\">&lt;/<span class=\"name\">label</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">input</span> <span class=\"attr\">placeholder</span>=<span class=\"string\">\"Enter your username\"</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">template</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">template</span> <span class=\"attr\">v-else</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">label</span>&gt;</span>Email<span class=\"tag\">&lt;/<span class=\"name\">label</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">input</span> <span class=\"attr\">placeholder</span>=<span class=\"string\">\"Enter your email address\"</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">template</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Then switching the&nbsp;<code>loginType</code>&nbsp;in the code above will not erase what the user has already entered. Since both templates use the same elements, the&nbsp;<code>&lt;input&gt;</code>&nbsp;is not replaced - just its&nbsp;<code>placeholder</code>.</p>\n" +
                    "<p>Check it out for yourself by entering some text in the input, then pressing the toggle button:</p>\n" +
                    "<div id=\"no-key-example\" class=\"demo\">\n" +
                    "<div><label>Username</label>&nbsp;<input type=\"text\" placeholder=\"Enter your username\" /></div>\n" +
                    "<button>Toggle login type</button></div>\n" +
                    "<p>This isn&rsquo;t always desirable though, so Vue offers a way for you to say, &ldquo;These two elements are completely separate - don&rsquo;t re-use them.&rdquo; Add a&nbsp;<code>key</code>&nbsp;attribute with unique values:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">template</span> <span class=\"attr\">v-if</span>=<span class=\"string\">\"loginType === 'username'\"</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">label</span>&gt;</span>Username<span class=\"tag\">&lt;/<span class=\"name\">label</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">input</span> <span class=\"attr\">placeholder</span>=<span class=\"string\">\"Enter your username\"</span> <span class=\"attr\">key</span>=<span class=\"string\">\"username-input\"</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">template</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">template</span> <span class=\"attr\">v-else</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">label</span>&gt;</span>Email<span class=\"tag\">&lt;/<span class=\"name\">label</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">input</span> <span class=\"attr\">placeholder</span>=<span class=\"string\">\"Enter your email address\"</span> <span class=\"attr\">key</span>=<span class=\"string\">\"email-input\"</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">template</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Now those inputs will be rendered from scratch each time you toggle. See for yourself:</p>\n" +
                    "<div id=\"key-example\" class=\"demo\">\n" +
                    "<div><label>Username</label>&nbsp;<input type=\"text\" placeholder=\"Enter your username\" /></div>\n" +
                    "<button>Toggle login type</button></div>\n" +
                    "<p>Note that the&nbsp;<code>&lt;label&gt;</code>&nbsp;elements are still efficiently re-used, because they don&rsquo;t have&nbsp;<code>key</code>&nbsp;attributes.</p>\n" +
                    "<h2 id=\"v-show\"><a class=\"headerlink\" title=\"v-show\" href=\"https://vuejs.org/v2/guide/conditional.html#v-show\" data-scroll=\"\"><code>v-show</code></a></h2>\n" +
                    "<p>Another option for conditionally displaying an element is the&nbsp;<code>v-show</code>&nbsp;directive. The usage is largely the same:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">h1</span> <span class=\"attr\">v-show</span>=<span class=\"string\">\"ok\"</span>&gt;</span>Hello!<span class=\"tag\">&lt;/<span class=\"name\">h1</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>The difference is that an element with&nbsp;<code>v-show</code>&nbsp;will always be rendered and remain in the DOM;&nbsp;<code>v-show</code>&nbsp;only toggles the&nbsp;<code>display</code>&nbsp;CSS property of the element.</p>\n" +
                    "<p class=\"tip\">Note that&nbsp;<code>v-show</code>&nbsp;doesn&rsquo;t support the&nbsp;<code>&lt;template&gt;</code>&nbsp;element, nor does it work with&nbsp;<code>v-else</code>.</p>\n" +
                    "<h2 id=\"v-if-vs-v-show\"><a class=\"headerlink\" title=\"v-if vs v-show\" href=\"https://vuejs.org/v2/guide/conditional.html#v-if-vs-v-show\" data-scroll=\"\"><code>v-if</code>&nbsp;vs&nbsp;<code>v-show</code></a></h2>\n" +
                    "<p><code>v-if</code>&nbsp;is &ldquo;real&rdquo; conditional rendering because it ensures that event listeners and child components inside the conditional block are properly destroyed and re-created during toggles.</p>\n" +
                    "<p><code>v-if</code>&nbsp;is also&nbsp;<strong>lazy</strong>: if the condition is false on initial render, it will not do anything - the conditional block won&rsquo;t be rendered until the condition becomes true for the first time.</p>\n" +
                    "<p>In comparison,&nbsp;<code>v-show</code>&nbsp;is much simpler - the element is always rendered regardless of initial condition, with CSS-based toggling.</p>\n" +
                    "<p>Generally speaking,&nbsp;<code>v-if</code>&nbsp;has higher toggle costs while&nbsp;<code>v-show</code>&nbsp;has higher initial render costs. So prefer&nbsp;<code>v-show</code>&nbsp;if you need to toggle something very often, and prefer&nbsp;<code>v-if</code>&nbsp;if the condition is unlikely to change at runtime.</p>\n" +
                    "<h2 id=\"v-if-with-v-for\"><a class=\"headerlink\" title=\"v-if with v-for\" href=\"https://vuejs.org/v2/guide/conditional.html#v-if-with-v-for\" data-scroll=\"\"><code>v-if</code>&nbsp;with&nbsp;<code>v-for</code></a></h2>\n" +
                    "<p class=\"tip\">Using&nbsp;<code>v-if</code>&nbsp;and&nbsp;<code>v-for</code>&nbsp;together is&nbsp;<strong>not recommended</strong>. See the&nbsp;<a href=\"https://vuejs.org/v2/style-guide/#Avoid-v-if-with-v-for-essential\">style guide</a>&nbsp;for further information.</p>\n" +
                    "<p>When used together with&nbsp;<code>v-if</code>,&nbsp;<code>v-for</code>&nbsp;has a higher priority than&nbsp;<code>v-if</code>. See the&nbsp;<a href=\"https://vuejs.org/v2/guide/list.html#V-for-and-v-if\">list rendering guide</a>&nbsp;for details.</p>");
            sec4Vue1.setLesson(vueJsLesson1);
            vueJsLesson1.getSections().add(sec4Vue1);

            Section sec5Vue1 = new Section();
            sec5Vue1.setOrdinalNumber(5);
            sec5Vue1.setDescription("Component Registration");
            sec5Vue1.setContent("<h2 id=\"Component-Names\"><a class=\"headerlink\" title=\"Component Names\" href=\"https://vuejs.org/v2/guide/components-registration.html#Component-Names\" data-scroll=\"\">Component Names</a></h2>\n" +
                    "<p>When registering a component, it will always be given a name. For example, in the global registration we&rsquo;ve seen so far:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\">Vue.component(<span class=\"string\">'my-component-name'</span>, { <span class=\"comment\">/* ... */</span> })</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>The component&rsquo;s name is the first argument of&nbsp;<code>Vue.component</code>.</p>\n" +
                    "<p>The name you give a component may depend on where you intend to use it. When using a component directly in the DOM (as opposed to in a string template or&nbsp;<a href=\"https://vuejs.org/v2/guide/single-file-components.html\">single-file component</a>), we strongly recommend following the&nbsp;<a href=\"https://html.spec.whatwg.org/multipage/custom-elements.html#valid-custom-element-name\" target=\"_blank\" rel=\"noopener\">W3C rules</a>&nbsp;for custom tag names (all-lowercase, must contain a hyphen). This helps you avoid conflicts with current and future HTML elements.</p>\n" +
                    "<p>You can see other recommendations for component names in the&nbsp;<a href=\"https://vuejs.org/v2/style-guide/#Base-component-names-strongly-recommended\">Style Guide</a>.</p>\n" +
                    "<h3 id=\"Name-Casing\"><a class=\"headerlink\" title=\"Name Casing\" href=\"https://vuejs.org/v2/guide/components-registration.html#Name-Casing\" data-scroll=\"\">Name Casing</a></h3>\n" +
                    "<p>You have two options when defining component names:</p>\n" +
                    "<h4 id=\"With-kebab-case\">With kebab-case</h4>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\">Vue.component(<span class=\"string\">'my-component-name'</span>, { <span class=\"comment\">/* ... */</span> })</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>When defining a component with kebab-case, you must also use kebab-case when referencing its custom element, such as in&nbsp;<code>&lt;my-component-name&gt;</code>.</p>\n" +
                    "<h4 id=\"With-PascalCase\">With PascalCase</h4>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\">Vue.component(<span class=\"string\">'MyComponentName'</span>, { <span class=\"comment\">/* ... */</span> })</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>When defining a component with PascalCase, you can use either case when referencing its custom element. That means both&nbsp;<code>&lt;my-component-name&gt;</code>&nbsp;and&nbsp;<code>&lt;MyComponentName&gt;</code>are acceptable. Note, however, that only kebab-case names are valid directly in the DOM (i.e. non-string templates).</p>\n" +
                    "<h2 id=\"Global-Registration\"><a class=\"headerlink\" title=\"Global Registration\" href=\"https://vuejs.org/v2/guide/components-registration.html#Global-Registration\" data-scroll=\"\">Global Registration</a></h2>\n" +
                    "<p>So far, we&rsquo;ve only created components using&nbsp;<code>Vue.component</code>:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\">Vue.component(<span class=\"string\">'my-component-name'</span>, {</span><br /><span class=\"line\">  <span class=\"comment\">// ... options ...</span></span><br /><span class=\"line\">})</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>These components are&nbsp;<strong>globally registered</strong>. That means they can be used in the template of any root Vue instance (<code>new Vue</code>) created after registration. For example:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\">Vue.component(<span class=\"string\">'component-a'</span>, { <span class=\"comment\">/* ... */</span> })</span><br /><span class=\"line\">Vue.component(<span class=\"string\">'component-b'</span>, { <span class=\"comment\">/* ... */</span> })</span><br /><span class=\"line\">Vue.component(<span class=\"string\">'component-c'</span>, { <span class=\"comment\">/* ... */</span> })</span><br /><br /><span class=\"line\"><span class=\"keyword\">new</span> Vue({ <span class=\"attr\">el</span>: <span class=\"string\">'#app'</span> })</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">div</span> <span class=\"attr\">id</span>=<span class=\"string\">\"app\"</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">component-a</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">component-a</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">component-b</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">component-b</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">component-c</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">component-c</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>This even applies to all subcomponents, meaning all three of these components will also be available&nbsp;<em>inside each other</em>.</p>\n" +
                    "<h2 id=\"Local-Registration\"><a class=\"headerlink\" title=\"Local Registration\" href=\"https://vuejs.org/v2/guide/components-registration.html#Local-Registration\" data-scroll=\"\">Local Registration</a></h2>\n" +
                    "<p>Global registration often isn&rsquo;t ideal. For example, if you&rsquo;re using a build system like Webpack, globally registering all components means that even if you stop using a component, it could still be included in your final build. This unnecessarily increases the amount of JavaScript your users have to download.</p>\n" +
                    "<p>In these cases, you can define your components as plain JavaScript objects:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"keyword\">var</span> ComponentA = { <span class=\"comment\">/* ... */</span> }</span><br /><span class=\"line\"><span class=\"keyword\">var</span> ComponentB = { <span class=\"comment\">/* ... */</span> }</span><br /><span class=\"line\"><span class=\"keyword\">var</span> ComponentC = { <span class=\"comment\">/* ... */</span> }</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Then define the components you&rsquo;d like to use in a&nbsp;<code>components</code>&nbsp;option:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"keyword\">new</span> Vue({</span><br /><span class=\"line\">  el: <span class=\"string\">'#app'</span>,</span><br /><span class=\"line\">  components: {</span><br /><span class=\"line\">    <span class=\"string\">'component-a'</span>: ComponentA,</span><br /><span class=\"line\">    <span class=\"string\">'component-b'</span>: ComponentB</span><br /><span class=\"line\">  }</span><br /><span class=\"line\">})</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>For each property in the&nbsp;<code>components</code>&nbsp;object, the key will be the name of the custom element, while the value will contain the options object for the component.</p>\n" +
                    "<p>Note that&nbsp;<strong>locally registered components are&nbsp;<em>not</em>&nbsp;also available in subcomponents</strong>. For example, if you wanted&nbsp;<code>ComponentA</code>&nbsp;to be available in&nbsp;<code>ComponentB</code>, you&rsquo;d have to use:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"keyword\">var</span> ComponentA = { <span class=\"comment\">/* ... */</span> }</span><br /><br /><span class=\"line\"><span class=\"keyword\">var</span> ComponentB = {</span><br /><span class=\"line\">  components: {</span><br /><span class=\"line\">    <span class=\"string\">'component-a'</span>: ComponentA</span><br /><span class=\"line\">  },</span><br /><span class=\"line\">  <span class=\"comment\">// ...</span></span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Or if you&rsquo;re using ES2015 modules, such as through Babel and Webpack, that might look more like:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"keyword\">import</span> ComponentA <span class=\"keyword\">from</span> <span class=\"string\">'./ComponentA.vue'</span></span><br /><br /><span class=\"line\"><span class=\"keyword\">export</span> <span class=\"keyword\">default</span> {</span><br /><span class=\"line\">  components: {</span><br /><span class=\"line\">    ComponentA</span><br /><span class=\"line\">  },</span><br /><span class=\"line\">  <span class=\"comment\">// ...</span></span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Note that in ES2015+, placing a variable name like&nbsp;<code>ComponentA</code>&nbsp;inside an object is shorthand for&nbsp;<code>ComponentA: ComponentA</code>, meaning the name of the variable is both:</p>\n" +
                    "<ul>\n" +
                    "<li>the custom element name to use in the template, and</li>\n" +
                    "<li>the name of the variable containing the component options</li>\n" +
                    "</ul>");
            sec5Vue1.setLesson(vueJsLesson1);
            vueJsLesson1.getSections().add(sec5Vue1);

            Section sec6Vue1 = new Section();
            sec6Vue1.setOrdinalNumber(6);
            sec6Vue1.setDescription("Props");
            sec6Vue1.setContent("Prop Casing (camelCase vs kebab-case)\n" +
                    "HTML attribute names are case-insensitive, so browsers will interpret any uppercase characters as lowercase. That means when you’re using in-DOM templates, camelCased prop names need to use their kebab-cased (hyphen-delimited) equivalents:\n" +
                    "\n" +
                    "Vue.component('blog-post', {\n" +
                    "  // camelCase in JavaScript\n" +
                    "  props: ['postTitle'],\n" +
                    "  template: '<h3>{{ postTitle }}</h3>'\n" +
                    "})\n" +
                    "<!-- kebab-case in HTML -->\n" +
                    "<blog-post post-title=\"hello!\"></blog-post>\n" +
                    "Again, if you’re using string templates, this limitation does not apply.\n" +
                    "\n" +
                    "Prop Types\n" +
                    "So far, we’ve only seen props listed as an array of strings:\n" +
                    "\n" +
                    "props: ['title', 'likes', 'isPublished', 'commentIds', 'author']\n" +
                    "Usually though, you’ll want every prop to be a specific type of value. In these cases, you can list props as an object, where the properties’ names and values contain the prop names and types, respectively:\n" +
                    "\n" +
                    "props: {\n" +
                    "  title: String,\n" +
                    "  likes: Number,\n" +
                    "  isPublished: Boolean,\n" +
                    "  commentIds: Array,\n" +
                    "  author: Object\n" +
                    "}\n" +
                    "This not only documents your component, but will also warn users in the browser’s JavaScript console if they pass the wrong type. You’ll learn much more about type checks and other prop validations further down this page.\n" +
                    "\n" +
                    "Passing Static or Dynamic Props\n" +
                    "So far, you’ve seen props passed a static value, like in:\n" +
                    "\n" +
                    "<blog-post title=\"My journey with Vue\"></blog-post>\n" +
                    "You’ve also seen props assigned dynamically with v-bind, such as in:\n" +
                    "\n" +
                    "<!-- Dynamically assign the value of a variable -->\n" +
                    "<blog-post v-bind:title=\"post.title\"></blog-post>\n" +
                    "\n" +
                    "<!-- Dynamically assign the value of a complex expression -->\n" +
                    "<blog-post v-bind:title=\"post.title + ' by ' + post.author.name\"></blog-post>\n" +
                    "In the two examples above, we happen to pass string values, but any type of value can actually be passed to a prop.\n" +
                    "\n" +
                    "Passing a Number\n" +
                    "<!-- Even though `42` is static, we need v-bind to tell Vue that -->\n" +
                    "<!-- this is a JavaScript expression rather than a string.       -->\n" +
                    "<blog-post v-bind:likes=\"42\"></blog-post>\n" +
                    "\n" +
                    "<!-- Dynamically assign to the value of a variable. -->\n" +
                    "<blog-post v-bind:likes=\"post.likes\"></blog-post>\n" +
                    "Passing a Boolean\n" +
                    "<!-- Including the prop with no value will imply `true`. -->\n" +
                    "<blog-post is-published></blog-post>\n" +
                    "\n" +
                    "<!-- Even though `false` is static, we need v-bind to tell Vue that -->\n" +
                    "<!-- this is a JavaScript expression rather than a string.          -->\n" +
                    "<blog-post v-bind:is-published=\"false\"></blog-post>\n" +
                    "\n" +
                    "<!-- Dynamically assign to the value of a variable. -->\n" +
                    "<blog-post v-bind:is-published=\"post.isPublished\"></blog-post>\n" +
                    "Passing an Array\n" +
                    "<!-- Even though the array is static, we need v-bind to tell Vue that -->\n" +
                    "<!-- this is a JavaScript expression rather than a string.            -->\n" +
                    "<blog-post v-bind:comment-ids=\"[234, 266, 273]\"></blog-post>\n" +
                    "\n" +
                    "<!-- Dynamically assign to the value of a variable. -->\n" +
                    "<blog-post v-bind:comment-ids=\"post.commentIds\"></blog-post>\n" +
                    "Passing an Object\n" +
                    "<!-- Even though the object is static, we need v-bind to tell Vue that -->\n" +
                    "<!-- this is a JavaScript expression rather than a string.             -->\n" +
                    "<blog-post v-bind:author=\"{ name: 'Veronica', company: 'Veridian Dynamics' }\"></blog-post>\n" +
                    "\n" +
                    "<!-- Dynamically assign to the value of a variable. -->\n" +
                    "<blog-post v-bind:author=\"post.author\"></blog-post>\n" +
                    "Passing the Properties of an Object\n" +
                    "If you want to pass all the properties of an object as props, you can use v-bind without an argument (v-bind instead of v-bind:prop-name). For example, given a post object:\n" +
                    "\n" +
                    "post: {\n" +
                    "  id: 1,\n" +
                    "  title: 'My Journey with Vue'\n" +
                    "}\n" +
                    "The following template:\n" +
                    "\n" +
                    "<blog-post v-bind=\"post\"></blog-post>\n" +
                    "Will be equivalent to:\n" +
                    "\n" +
                    "<blog-post\n" +
                    "  v-bind:id=\"post.id\"\n" +
                    "  v-bind:title=\"post.title\"\n" +
                    "></blog-post>");
            sec6Vue1.setLesson(vueJsLesson1);
            vueJsLesson1.getSections().add(sec6Vue1);

            Section sec7Vue1 = new Section();
            sec7Vue1.setOrdinalNumber(7);
            sec7Vue1.setDescription("Custom Events");
            sec7Vue1.setContent("<h2 id=\"Event-Names\"><a class=\"headerlink\" title=\"Event Names\" href=\"https://vuejs.org/v2/guide/components-custom-events.html#Event-Names\" data-scroll=\"\">Event Names</a></h2>\n" +
                    "<p>Unlike components and props, event names don&rsquo;t provide any automatic case transformation. Instead, the name of an emitted event must exactly match the name used to listen to that event. For example, if emitting a camelCased event name:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"keyword\">this</span>.$emit(<span class=\"string\">'myEvent'</span>)</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Listening to the kebab-cased version will have no effect:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">my-component</span> <span class=\"attr\">v-on:my-event</span>=<span class=\"string\">\"doSomething\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">my-component</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Unlike components and props, event names will never be used as variable or property names in JavaScript, so there&rsquo;s no reason to use camelCase or PascalCase. Additionally,&nbsp;<code>v-on</code>&nbsp;event listeners inside DOM templates will be automatically transformed to lowercase (due to HTML&rsquo;s case-insensitivity), so&nbsp;<code>v-on:myEvent</code>&nbsp;would become&nbsp;<code>v-on:myevent</code>&nbsp;&ndash; making&nbsp;<code>myEvent</code>&nbsp;impossible to listen to.</p>\n" +
                    "<p>For these reasons, we recommend you&nbsp;<strong>always use kebab-case for event names</strong>.</p>\n" +
                    "<h2 id=\"Customizing-Component-v-model\"><a class=\"headerlink\" title=\"Customizing Component v-model\" href=\"https://vuejs.org/v2/guide/components-custom-events.html#Customizing-Component-v-model\" data-scroll=\"\">Customizing Component&nbsp;<code>v-model</code></a></h2>\n" +
                    "<blockquote>\n" +
                    "<p>New in 2.2.0+</p>\n" +
                    "</blockquote>\n" +
                    "<p>By default,&nbsp;<code>v-model</code>&nbsp;on a component uses&nbsp;<code>value</code>&nbsp;as the prop and&nbsp;<code>input</code>&nbsp;as the event, but some input types such as checkboxes and radio buttons may want to use the&nbsp;<code>value</code>&nbsp;attribute for a&nbsp;<a href=\"https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/checkbox#Value\" target=\"_blank\" rel=\"noopener\">different purpose</a>. Using the&nbsp;<code>model</code>&nbsp;option can avoid a conflict in such cases:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\">Vue.component(<span class=\"string\">'base-checkbox'</span>, {</span><br /><span class=\"line\">  model: {</span><br /><span class=\"line\">    prop: <span class=\"string\">'checked'</span>,</span><br /><span class=\"line\">    event: <span class=\"string\">'change'</span></span><br /><span class=\"line\">  },</span><br /><span class=\"line\">  props: {</span><br /><span class=\"line\">    checked: <span class=\"built_in\">Boolean</span></span><br /><span class=\"line\">  },</span><br /><span class=\"line\">  template: <span class=\"string\">`</span></span><br /><span class=\"line\"><span class=\"string\">    &lt;input</span></span><br /><span class=\"line\"><span class=\"string\">      type=\"checkbox\"</span></span><br /><span class=\"line\"><span class=\"string\">      v-bind:checked=\"checked\"</span></span><br /><span class=\"line\"><span class=\"string\">      v-on:change=\"$emit('change', $event.target.checked)\"</span></span><br /><span class=\"line\"><span class=\"string\">    &gt;</span></span><br /><span class=\"line\"><span class=\"string\">  `</span></span><br /><span class=\"line\">})</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Now when using&nbsp;<code>v-model</code>&nbsp;on this component:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">base-checkbox</span> <span class=\"attr\">v-model</span>=<span class=\"string\">\"lovingVue\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">base-checkbox</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>the value of&nbsp;<code>lovingVue</code>&nbsp;will be passed to the&nbsp;<code>checked</code>&nbsp;prop. The&nbsp;<code>lovingVue</code>&nbsp;property will then be updated when&nbsp;<code>&lt;base-checkbox&gt;</code>&nbsp;emits a&nbsp;<code>change</code>&nbsp;event with a new value.</p>\n" +
                    "<p class=\"tip\">Note that you still have to declare the&nbsp;<code>checked</code>&nbsp;prop in component&rsquo;s&nbsp;<code>props</code>option.</p>\n" +
                    "<h2 id=\"Binding-Native-Events-to-Components\"><a class=\"headerlink\" title=\"Binding Native Events to Components\" href=\"https://vuejs.org/v2/guide/components-custom-events.html#Binding-Native-Events-to-Components\" data-scroll=\"\">Binding Native Events to Components</a></h2>\n" +
                    "<p>There may be times when you want to listen directly to a native event on the root element of a component. In these cases, you can use the&nbsp;<code>.native</code>&nbsp;modifier for&nbsp;<code>v-on</code>:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">base-input</span> <span class=\"attr\">v-on:focus.native</span>=<span class=\"string\">\"onFocus\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">base-input</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>This can be useful sometimes, but it&rsquo;s not a good idea when you&rsquo;re trying to listen on a very specific element, like an&nbsp;<code>&lt;input&gt;</code>. For example, the&nbsp;<code>&lt;base-input&gt;</code>&nbsp;component above might refactor so that the root element is actually a&nbsp;<code>&lt;label&gt;</code>&nbsp;element:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">label</span>&gt;</span></span><br /><span class=\"line\">  {{ label }}</span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">input</span></span></span><br /><span class=\"line\"><span class=\"tag\">    <span class=\"attr\">v-bind</span>=<span class=\"string\">\"$attrs\"</span></span></span><br /><span class=\"line\"><span class=\"tag\">    <span class=\"attr\">v-bind:value</span>=<span class=\"string\">\"value\"</span></span></span><br /><span class=\"line\"><span class=\"tag\">    <span class=\"attr\">v-on:input</span>=<span class=\"string\">\"$emit('input', $event.target.value)\"</span></span></span><br /><span class=\"line\"><span class=\"tag\">  &gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">label</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>In that case, the&nbsp;<code>.native</code>&nbsp;listener in the parent would silently break. There would be no errors, but the&nbsp;<code>onFocus</code>&nbsp;handler wouldn&rsquo;t be called when we expected it to.</p>\n" +
                    "<p>To solve this problem, Vue provides a&nbsp;<code>$listeners</code>&nbsp;property containing an object of listeners being used on the component. For example:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\">{</span><br /><span class=\"line\">  focus: <span class=\"function\"><span class=\"keyword\">function</span> (<span class=\"params\">event</span>) </span>{ <span class=\"comment\">/* ... */</span> }</span><br /><span class=\"line\">  input: <span class=\"function\"><span class=\"keyword\">function</span> (<span class=\"params\">value</span>) </span>{ <span class=\"comment\">/* ... */</span> },</span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Using the&nbsp;<code>$listeners</code>&nbsp;property, you can forward all event listeners on the component to a specific child element with&nbsp;<code>v-on=\"$listeners\"</code>. For elements like&nbsp;<code>&lt;input&gt;</code>, that you also want to work with&nbsp;<code>v-model</code>, it&rsquo;s often useful to create a new computed property for listeners, like&nbsp;<code>inputListeners</code>&nbsp;below:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\">Vue.component(<span class=\"string\">'base-input'</span>, {</span><br /><span class=\"line\">  inheritAttrs: <span class=\"literal\">false</span>,</span><br /><span class=\"line\">  props: [<span class=\"string\">'label'</span>, <span class=\"string\">'value'</span>],</span><br /><span class=\"line\">  computed: {</span><br /><span class=\"line\">    inputListeners: <span class=\"function\"><span class=\"keyword\">function</span> () </span>{</span><br /><span class=\"line\">      <span class=\"keyword\">var</span> vm = <span class=\"keyword\">this</span></span><br /><span class=\"line\">      <span class=\"comment\">// `Object.assign` merges objects together to form a new object</span></span><br /><span class=\"line\">      <span class=\"keyword\">return</span> <span class=\"built_in\">Object</span>.assign({},</span><br /><span class=\"line\">        <span class=\"comment\">// We add all the listeners from the parent</span></span><br /><span class=\"line\">        <span class=\"keyword\">this</span>.$listeners,</span><br /><span class=\"line\">        <span class=\"comment\">// Then we can add custom listeners or override the</span></span><br /><span class=\"line\">        <span class=\"comment\">// behavior of some listeners.</span></span><br /><span class=\"line\">        {</span><br /><span class=\"line\">          <span class=\"comment\">// This ensures that the component works with v-model</span></span><br /><span class=\"line\">          input: <span class=\"function\"><span class=\"keyword\">function</span> (<span class=\"params\">event</span>) </span>{</span><br /><span class=\"line\">            vm.$emit(<span class=\"string\">'input'</span>, event.target.value)</span><br /><span class=\"line\">          }</span><br /><span class=\"line\">        }</span><br /><span class=\"line\">      )</span><br /><span class=\"line\">    }</span><br /><span class=\"line\">  },</span><br /><span class=\"line\">  template: <span class=\"string\">`</span></span><br /><span class=\"line\"><span class=\"string\">    &lt;label&gt;</span></span><br /><span class=\"line\"><span class=\"string\">      {{ label }}</span></span><br /><span class=\"line\"><span class=\"string\">      &lt;input</span></span><br /><span class=\"line\"><span class=\"string\">        v-bind=\"$attrs\"</span></span><br /><span class=\"line\"><span class=\"string\">        v-bind:value=\"value\"</span></span><br /><span class=\"line\"><span class=\"string\">        v-on=\"inputListeners\"</span></span><br /><span class=\"line\"><span class=\"string\">      &gt;</span></span><br /><span class=\"line\"><span class=\"string\">    &lt;/label&gt;</span></span><br /><span class=\"line\"><span class=\"string\">  `</span></span><br /><span class=\"line\">})</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Now the&nbsp;<code>&lt;base-input&gt;</code>&nbsp;component is a&nbsp;<strong>fully transparent wrapper</strong>, meaning it can be used exactly like a normal&nbsp;<code>&lt;input&gt;</code>&nbsp;element: all the same attributes and listeners will work, without the&nbsp;<code>.native</code>&nbsp;modifier.</p>\n" +
                    "<h2 id=\"sync-Modifier\"><a class=\"headerlink\" title=\".sync Modifier\" href=\"https://vuejs.org/v2/guide/components-custom-events.html#sync-Modifier\" data-scroll=\"\"><code>.sync</code>&nbsp;Modifier</a></h2>\n" +
                    "<blockquote>\n" +
                    "<p>New in 2.3.0+</p>\n" +
                    "</blockquote>\n" +
                    "<p>In some cases, we may need &ldquo;two-way binding&rdquo; for a prop. Unfortunately, true two-way binding can create maintenance issues, because child components can mutate the parent without the source of that mutation being obvious in both the parent and the child.</p>\n" +
                    "<p>That&rsquo;s why instead, we recommend emitting events in the pattern of&nbsp;<code>update:myPropName</code>. For example, in a hypothetical component with a&nbsp;<code>title</code>&nbsp;prop, we could communicate the intent of assigning a new value with:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"keyword\">this</span>.$emit(<span class=\"string\">'update:title'</span>, newTitle)</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Then the parent can listen to that event and update a local data property, if it wants to. For example:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">text-document</span></span></span><br /><span class=\"line\"><span class=\"tag\">  <span class=\"attr\">v-bind:title</span>=<span class=\"string\">\"doc.title\"</span></span></span><br /><span class=\"line\"><span class=\"tag\">  <span class=\"attr\">v-on:update:title</span>=<span class=\"string\">\"doc.title = $event\"</span></span></span><br /><span class=\"line\"><span class=\"tag\">&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">text-document</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>For convenience, we offer a shorthand for this pattern with the&nbsp;<code>.sync</code>&nbsp;modifier:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">text-document</span> <span class=\"attr\">v-bind:title.sync</span>=<span class=\"string\">\"doc.title\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">text-document</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p class=\"tip\">Note that&nbsp;<code>v-bind</code>&nbsp;with the&nbsp;<code>.sync</code>&nbsp;modifier does&nbsp;<strong>not</strong>&nbsp;work with expressions (e.g.&nbsp;<code>v-bind:title.sync=&rdquo;doc.title + &lsquo;!&rsquo;&rdquo;</code>&nbsp;is invalid). Instead, you must only provide the name of the property you want to bind, similar to&nbsp;<code>v-model</code>.</p>\n" +
                    "<p>The&nbsp;<code>.sync</code>&nbsp;modifier can also be used with&nbsp;<code>v-bind</code>&nbsp;when using an object to set multiple props at once:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">text-document</span> <span class=\"attr\">v-bind.sync</span>=<span class=\"string\">\"doc\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">text-document</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>This passes each property in the&nbsp;<code>doc</code>&nbsp;object (e.g.&nbsp;<code>title</code>) as an individual prop, then adds&nbsp;<code>v-on</code>&nbsp;update listeners for each one.</p>\n" +
                    "<p class=\"tip\">Using&nbsp;<code>v-bind.sync</code>&nbsp;with a literal object, such as in&nbsp;<code>v-bind.sync=&rdquo;{ title: doc.title }&rdquo;</code>, will not work, because there are too many edge cases to consider in parsing a complex expression like this.</p>");
            sec7Vue1.setLesson(vueJsLesson1);
            vueJsLesson1.getSections().add(sec7Vue1);

            Section sec1Vue2 = new Section();
            sec1Vue2.setOrdinalNumber(1);
            sec1Vue2.setDescription("Production Deployment");
            sec1Vue2.setContent("<h2 id=\"Turn-on-Production-Mode\"><a class=\"headerlink\" title=\"Turn on Production Mode\" href=\"https://vuejs.org/v2/guide/deployment.html#Turn-on-Production-Mode\" data-scroll=\"\">Turn on Production Mode</a></h2>\n" +
                    "<p>During development, Vue provides a lot of warnings to help you with common errors and pitfalls. However, these warning strings become useless in production and bloat your app&rsquo;s payload size. In addition, some of these warning checks have small runtime costs that can be avoided in production mode.</p>\n" +
                    "<h3 id=\"Without-Build-Tools\"><a class=\"headerlink\" title=\"Without Build Tools\" href=\"https://vuejs.org/v2/guide/deployment.html#Without-Build-Tools\" data-scroll=\"\">Without Build Tools</a></h3>\n" +
                    "<p>If you are using the full build, i.e. directly including Vue via a script tag without a build tool, make sure to use the minified version (<code>vue.min.js</code>) for production. Both versions can be found in the&nbsp;<a href=\"https://vuejs.org/v2/guide/installation.html#Direct-lt-script-gt-Include\">Installation guide</a>.</p>\n" +
                    "<h3 id=\"With-Build-Tools\"><a class=\"headerlink\" title=\"With Build Tools\" href=\"https://vuejs.org/v2/guide/deployment.html#With-Build-Tools\" data-scroll=\"\">With Build Tools</a></h3>\n" +
                    "<p>When using a build tool like Webpack or Browserify, the production mode will be determined by&nbsp;<code>process.env.NODE_ENV</code>&nbsp;inside Vue&rsquo;s source code, and it will be in development mode by default. Both build tools provide ways to overwrite this variable to enable Vue&rsquo;s production mode, and warnings will be stripped by minifiers during the build. All&nbsp;<code>vue-cli</code>&nbsp;templates have these pre-configured for you, but it would be beneficial to know how it is done:</p>\n" +
                    "<h4 id=\"Webpack\">Webpack</h4>\n" +
                    "<p>In Webpack 4+, you can use the&nbsp;<code>mode</code>&nbsp;option:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"built_in\">module</span>.exports = {</span><br /><span class=\"line\">  mode: <span class=\"string\">'production'</span></span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>But in Webpack 3 and earlier, you&rsquo;ll need to use&nbsp;<a href=\"https://webpack.js.org/plugins/define-plugin/\" target=\"_blank\" rel=\"noopener\">DefinePlugin</a>:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"keyword\">var</span> webpack = <span class=\"built_in\">require</span>(<span class=\"string\">'webpack'</span>)</span><br /><br /><span class=\"line\"><span class=\"built_in\">module</span>.exports = {</span><br /><span class=\"line\">  <span class=\"comment\">// ...</span></span><br /><span class=\"line\">  plugins: [</span><br /><span class=\"line\">    <span class=\"comment\">// ...</span></span><br /><span class=\"line\">    <span class=\"keyword\">new</span> webpack.DefinePlugin({</span><br /><span class=\"line\">      <span class=\"string\">'process.env.NODE_ENV'</span>: <span class=\"built_in\">JSON</span>.stringify(<span class=\"string\">'production'</span>)</span><br /><span class=\"line\">    })</span><br /><span class=\"line\">  ]</span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<h4 id=\"Browserify\">Browserify</h4>\n" +
                    "<ul>\n" +
                    "<li>\n" +
                    "<p>Run your bundling command with the actual&nbsp;<code>NODE_ENV</code>&nbsp;environment variable set to&nbsp;<code>\"production\"</code>. This tells&nbsp;<code>vueify</code>&nbsp;to avoid including hot-reload and development related code.</p>\n" +
                    "</li>\n" +
                    "<li>\n" +
                    "<p>Apply a global&nbsp;<a href=\"https://github.com/hughsk/envify\" target=\"_blank\" rel=\"noopener\">envify</a>&nbsp;transform to your bundle. This allows the minifier to strip out all the warnings in Vue&rsquo;s source code wrapped in env variable conditional blocks. For example:</p>\n" +
                    "<figure class=\"highlight bash\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\">NODE_ENV=production browserify -g envify -e main.js | uglifyjs -c -m &gt; build.js</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "</li>\n" +
                    "<li>\n" +
                    "<p>Or, using&nbsp;<a href=\"https://github.com/hughsk/envify\" target=\"_blank\" rel=\"noopener\">envify</a>&nbsp;with Gulp:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"comment\">// Use the envify custom module to specify environment variables</span></span><br /><span class=\"line\"><span class=\"keyword\">var</span> envify = <span class=\"built_in\">require</span>(<span class=\"string\">'envify/custom'</span>)</span><br /><br /><span class=\"line\">browserify(browserifyOptions)</span><br /><span class=\"line\">  .transform(vueify)</span><br /><span class=\"line\">  .transform(</span><br /><span class=\"line\">    <span class=\"comment\">// Required in order to process node_modules files</span></span><br /><span class=\"line\">    { <span class=\"attr\">global</span>: <span class=\"literal\">true</span> },</span><br /><span class=\"line\">    envify({ <span class=\"attr\">NODE_ENV</span>: <span class=\"string\">'production'</span> })</span><br /><span class=\"line\">  )</span><br /><span class=\"line\">  .bundle()</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "</li>\n" +
                    "<li>\n" +
                    "<p>Or, using&nbsp;<a href=\"https://github.com/hughsk/envify\" target=\"_blank\" rel=\"noopener\">envify</a>&nbsp;with Grunt and&nbsp;<a href=\"https://github.com/jmreidy/grunt-browserify\" target=\"_blank\" rel=\"noopener\">grunt-browserify</a>:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"comment\">// Use the envify custom module to specify environment variables</span></span><br /><span class=\"line\"><span class=\"keyword\">var</span> envify = <span class=\"built_in\">require</span>(<span class=\"string\">'envify/custom'</span>)</span><br /><br /><span class=\"line\">browserify: {</span><br /><span class=\"line\">  dist: {</span><br /><span class=\"line\">    options: {</span><br /><span class=\"line\">      <span class=\"comment\">// Function to deviate from grunt-browserify's default order</span></span><br /><span class=\"line\">      configure: <span class=\"function\"><span class=\"params\">b</span> =&gt;</span> b</span><br /><span class=\"line\">        .transform(<span class=\"string\">'vueify'</span>)</span><br /><span class=\"line\">        .transform(</span><br /><span class=\"line\">          <span class=\"comment\">// Required in order to process node_modules files</span></span><br /><span class=\"line\">          { <span class=\"attr\">global</span>: <span class=\"literal\">true</span> },</span><br /><span class=\"line\">          envify({ <span class=\"attr\">NODE_ENV</span>: <span class=\"string\">'production'</span> })</span><br /><span class=\"line\">        )</span><br /><span class=\"line\">        .bundle()</span><br /><span class=\"line\">    }</span><br /><span class=\"line\">  }</span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "</li>\n" +
                    "</ul>\n" +
                    "<h4 id=\"Rollup\">Rollup</h4>\n" +
                    "<p>Use&nbsp;<a href=\"https://github.com/rollup/rollup-plugin-replace\" target=\"_blank\" rel=\"noopener\">rollup-plugin-replace</a>:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"keyword\">const</span> replace = <span class=\"built_in\">require</span>(<span class=\"string\">'rollup-plugin-replace'</span>)</span><br /><br /><span class=\"line\">rollup({</span><br /><span class=\"line\">  <span class=\"comment\">// ...</span></span><br /><span class=\"line\">  plugins: [</span><br /><span class=\"line\">    replace({</span><br /><span class=\"line\">      <span class=\"string\">'process.env.NODE_ENV'</span>: <span class=\"built_in\">JSON</span>.stringify( <span class=\"string\">'production'</span> )</span><br /><span class=\"line\">    })</span><br /><span class=\"line\">  ]</span><br /><span class=\"line\">}).then(...)</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<h2 id=\"Pre-Compiling-Templates\"><a class=\"headerlink\" title=\"Pre-Compiling Templates\" href=\"https://vuejs.org/v2/guide/deployment.html#Pre-Compiling-Templates\" data-scroll=\"\">Pre-Compiling Templates</a></h2>\n" +
                    "<p>When using in-DOM templates or in-JavaScript template strings, the template-to-render-function compilation is performed on the fly. This is usually fast enough in most cases, but is best avoided if your application is performance-sensitive.</p>\n" +
                    "<p>The easiest way to pre-compile templates is using&nbsp;<a href=\"https://vuejs.org/v2/guide/single-file-components.html\">Single-File Components</a>&nbsp;- the associated build setups automatically performs pre-compilation for you, so the built code contains the already compiled render functions instead of raw template strings.</p>\n" +
                    "<p>If you are using Webpack, and prefer separating JavaScript and template files, you can use&nbsp;<a href=\"https://github.com/ktsn/vue-template-loader\" target=\"_blank\" rel=\"noopener\">vue-template-loader</a>, which also transforms the template files into JavaScript render functions during the build step.</p>");
            sec1Vue2.setLesson(vueJsLesson2);
            vueJsLesson2.getSections().add(sec1Vue2);

            Section sec2Vue2 = new Section();
            sec2Vue2.setOrdinalNumber(2);
            sec2Vue2.setDescription("Single File Components");
            sec2Vue2.setContent("<p>In many Vue projects, global components will be defined using&nbsp;<code>Vue.component</code>, followed by&nbsp;<code>new Vue({ el: '#container' })</code>&nbsp;to target a container element in the body of every page.</p>\n" +
                    "<p>This can work very well for small to medium-sized projects, where JavaScript is only used to enhance certain views. In more complex projects however, or when your frontend is entirely driven by JavaScript, these disadvantages become apparent:</p>\n" +
                    "<ul>\n" +
                    "<li><strong>Global definitions</strong>&nbsp;force unique names for every component</li>\n" +
                    "<li><strong>String templates</strong>&nbsp;lack syntax highlighting and require ugly slashes for multiline HTML</li>\n" +
                    "<li><strong>No CSS support</strong>&nbsp;means that while HTML and JavaScript are modularized into components, CSS is conspicuously left out</li>\n" +
                    "<li><strong>No build step</strong>&nbsp;restricts us to HTML and ES5 JavaScript, rather than preprocessors like Pug (formerly Jade) and Babel</li>\n" +
                    "</ul>\n" +
                    "<p>All of these are solved by&nbsp;<strong>single-file components</strong>&nbsp;with a&nbsp;<code>.vue</code>&nbsp;extension, made possible with build tools such as Webpack or Browserify.</p>\n" +
                    "<p>Here&rsquo;s an example of a file we&rsquo;ll call&nbsp;<code>Hello.vue</code>:</p>\n" +
                    "<p><a href=\"https://gist.github.com/chrisvfritz/e2b6a6110e0829d78fa4aedf7cf6b235\" target=\"_blank\" rel=\"noopener noreferrer\"><img src=\"https://vuejs.org/images/vue-component.png\" alt=\"Single-file component example (click for code as text)\" /></a></p>\n" +
                    "<p>Now we get:</p>\n" +
                    "<ul>\n" +
                    "<li><a href=\"https://github.com/vuejs/awesome-vue#source-code-editing\" target=\"_blank\" rel=\"noopener\">Complete syntax highlighting</a></li>\n" +
                    "<li><a href=\"https://webpack.js.org/concepts/modules/#what-is-a-webpack-module\" target=\"_blank\" rel=\"noopener\">CommonJS modules</a></li>\n" +
                    "<li><a href=\"https://vue-loader.vuejs.org/en/features/scoped-css.html\" target=\"_blank\" rel=\"noopener\">Component-scoped CSS</a></li>\n" +
                    "</ul>\n" +
                    "<p>As promised, we can also use preprocessors such as Pug, Babel (with ES2015 modules), and Stylus for cleaner and more feature-rich components.</p>\n" +
                    "<p><a href=\"https://gist.github.com/chrisvfritz/1c9f2daea9bc078dcb47e9a82e5f7587\" target=\"_blank\" rel=\"noopener noreferrer\"><img src=\"https://vuejs.org/images/vue-component-with-preprocessors.png\" alt=\"Single-file component example with preprocessors (click for code as text)\" /></a></p>\n" +
                    "<p>These specific languages are only examples. You could as easily use Bubl&eacute;, TypeScript, SCSS, PostCSS - or whatever other preprocessors that help you be productive. If using Webpack with&nbsp;<code>vue-loader</code>, it also has first-class support for CSS Modules.</p>\n" +
                    "<h3 id=\"What-About-Separation-of-Concerns\"><a class=\"headerlink\" title=\"What About Separation of Concerns?\" href=\"https://vuejs.org/v2/guide/single-file-components.html#What-About-Separation-of-Concerns\" data-scroll=\"\">What About Separation of Concerns?</a></h3>\n" +
                    "<p>One important thing to note is that&nbsp;<strong>separation of concerns is not equal to separation of file types.</strong>&nbsp;In modern UI development, we have found that instead of dividing the codebase into three huge layers that interweave with one another, it makes much more sense to divide them into loosely-coupled components and compose them. Inside a component, its template, logic and styles are inherently coupled, and collocating them actually makes the component more cohesive and maintainable.</p>\n" +
                    "<p>Even if you don&rsquo;t like the idea of Single-File Components, you can still leverage its hot-reloading and pre-compilation features by separating your JavaScript and CSS into separate files:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"comment\">&lt;!-- my-component.vue --&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">template</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">div</span>&gt;</span>This will be pre-compiled<span class=\"tag\">&lt;/<span class=\"name\">div</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">template</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">script</span> <span class=\"attr\">src</span>=<span class=\"string\">\"./my-component.js\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">script</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">style</span> <span class=\"attr\">src</span>=<span class=\"string\">\"./my-component.css\"</span>&gt;</span><span class=\"tag\">&lt;/<span class=\"name\">style</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<h2 id=\"Getting-Started\"><a class=\"headerlink\" title=\"Getting Started\" href=\"https://vuejs.org/v2/guide/single-file-components.html#Getting-Started\" data-scroll=\"\">Getting Started</a></h2>\n" +
                    "<h3 id=\"Example-Sandbox\"><a class=\"headerlink\" title=\"Example Sandbox\" href=\"https://vuejs.org/v2/guide/single-file-components.html#Example-Sandbox\" data-scroll=\"\">Example Sandbox</a></h3>\n" +
                    "<p>If you want to dive right in and start playing with single-file components, check out&nbsp;<a href=\"https://codesandbox.io/s/o29j95wx9\" target=\"_blank\" rel=\"noopener\">this simple todo app</a>&nbsp;on CodeSandbox.</p>\n" +
                    "<h3 id=\"For-Users-New-to-Module-Build-Systems-in-JavaScript\"><a class=\"headerlink\" title=\"For Users New to Module Build Systems in JavaScript\" href=\"https://vuejs.org/v2/guide/single-file-components.html#For-Users-New-to-Module-Build-Systems-in-JavaScript\" data-scroll=\"\">For Users New to Module Build Systems in JavaScript</a></h3>\n" +
                    "<p>With&nbsp;<code>.vue</code>&nbsp;components, we&rsquo;re entering the realm of advanced JavaScript applications. That means learning to use a few additional tools if you haven&rsquo;t already:</p>\n" +
                    "<ul>\n" +
                    "<li>\n" +
                    "<p><strong>Node Package Manager (NPM)</strong>: Read the&nbsp;<a href=\"https://docs.npmjs.com/getting-started/what-is-npm\" target=\"_blank\" rel=\"noopener\">Getting Started guide</a>&nbsp;through section&nbsp;<em>10: Uninstalling global packages</em>.</p>\n" +
                    "</li>\n" +
                    "<li>\n" +
                    "<p><strong>Modern JavaScript with ES2015/16</strong>: Read through Babel&rsquo;s&nbsp;<a href=\"https://babeljs.io/docs/learn-es2015/\" target=\"_blank\" rel=\"noopener\">Learn ES2015 guide</a>. You don&rsquo;t have to memorize every feature right now, but keep this page as a reference you can come back to.</p>\n" +
                    "</li>\n" +
                    "</ul>\n" +
                    "<p>After you&rsquo;ve taken a day to dive into these resources, we recommend checking out the&nbsp;<a href=\"https://vuejs-templates.github.io/webpack\" target=\"_blank\" rel=\"noopener\">webpack</a>&nbsp;template. Follow the instructions and you should have a Vue project with&nbsp;<code>.vue</code>&nbsp;components, ES2015, and hot-reloading in no time!</p>\n" +
                    "<p>To learn more about Webpack itself, check out&nbsp;<a href=\"https://webpack.js.org/configuration/\" target=\"_blank\" rel=\"noopener\">their official docs</a>&nbsp;and&nbsp;<a href=\"https://webpack.academy/p/the-core-concepts\" target=\"_blank\" rel=\"noopener\">Webpack Academy</a>. In Webpack, each file can be transformed by a &ldquo;loader&rdquo; before being included in the bundle, and Vue offers the&nbsp;<a href=\"https://vue-loader.vuejs.org/\" target=\"_blank\" rel=\"noopener\">vue-loader</a>&nbsp;plugin to translate single-file (<code>.vue</code>) components.</p>");
            sec2Vue2.setLesson(vueJsLesson2);
            vueJsLesson2.getSections().add(sec2Vue2);

            Section sec3Vue2 = new Section();
            sec3Vue2.setOrdinalNumber(3);
            sec3Vue2.setDescription("Unit Testing");
            sec3Vue2.setContent("<p>Anything compatible with a module-based build system will work, but if you&rsquo;re looking for a specific recommendation try the&nbsp;<a href=\"http://karma-runner.github.io/\" target=\"_blank\" rel=\"noopener\">Karma</a>&nbsp;test runner. It has a lot of community plugins, including support for&nbsp;<a href=\"https://github.com/webpack/karma-webpack\" target=\"_blank\" rel=\"noopener\">Webpack</a>&nbsp;and&nbsp;<a href=\"https://github.com/Nikku/karma-browserify\" target=\"_blank\" rel=\"noopener\">Browserify</a>. For detailed setup please refer to each project&rsquo;s respective documentation. These example Karma configurations for&nbsp;<a href=\"https://github.com/vuejs-templates/webpack/blob/master/template/test/unit/karma.conf.js\" target=\"_blank\" rel=\"noopener\">Webpack</a>&nbsp;and&nbsp;<a href=\"https://github.com/vuejs-templates/browserify/blob/master/template/karma.conf.js\" target=\"_blank\" rel=\"noopener\">Browserify</a>&nbsp;can help you get started.</p>\n" +
                    "<h2 id=\"Simple-Assertions\"><a class=\"headerlink\" title=\"Simple Assertions\" href=\"https://vuejs.org/v2/guide/unit-testing.html#Simple-Assertions\" data-scroll=\"\">Simple Assertions</a></h2>\n" +
                    "<p>You don&rsquo;t have to do anything special in your components to make them testable. Export the raw options:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">template</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">span</span>&gt;</span>{{ message }}<span class=\"tag\">&lt;/<span class=\"name\">span</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">template</span>&gt;</span></span><br /><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">script</span>&gt;</span></span><br /><span class=\"line\"><span class=\"javascript\">  <span class=\"keyword\">export</span> <span class=\"keyword\">default</span> {</span></span><br /><span class=\"line\"><span class=\"undefined\">    data () {</span></span><br /><span class=\"line\"><span class=\"javascript\">      <span class=\"keyword\">return</span> {</span></span><br /><span class=\"line\"><span class=\"javascript\">        message: <span class=\"string\">'hello!'</span></span></span><br /><span class=\"line\"><span class=\"undefined\">      }</span></span><br /><span class=\"line\"><span class=\"undefined\">    },</span></span><br /><span class=\"line\"><span class=\"undefined\">    created () {</span></span><br /><span class=\"line\"><span class=\"javascript\">      <span class=\"keyword\">this</span>.message = <span class=\"string\">'bye!'</span></span></span><br /><span class=\"line\"><span class=\"undefined\">    }</span></span><br /><span class=\"line\"><span class=\"undefined\">  }</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">script</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Then import the component options along with Vue, and you can make many common assertions:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"comment\">// Import Vue and the component being tested</span></span><br /><span class=\"line\"><span class=\"keyword\">import</span> Vue <span class=\"keyword\">from</span> <span class=\"string\">'vue'</span></span><br /><span class=\"line\"><span class=\"keyword\">import</span> MyComponent <span class=\"keyword\">from</span> <span class=\"string\">'path/to/MyComponent.vue'</span></span><br /><br /><span class=\"line\"><span class=\"comment\">// Here are some Jasmine 2.0 tests, though you can</span></span><br /><span class=\"line\"><span class=\"comment\">// use any test runner / assertion library combo you prefer</span></span><br /><span class=\"line\">describe(<span class=\"string\">'MyComponent'</span>, () =&gt; {</span><br /><span class=\"line\">  <span class=\"comment\">// Inspect the raw component options</span></span><br /><span class=\"line\">  it(<span class=\"string\">'has a created hook'</span>, () =&gt; {</span><br /><span class=\"line\">    expect(<span class=\"keyword\">typeof</span> MyComponent.created).toBe(<span class=\"string\">'function'</span>)</span><br /><span class=\"line\">  })</span><br /><br /><span class=\"line\">  <span class=\"comment\">// Evaluate the results of functions in</span></span><br /><span class=\"line\">  <span class=\"comment\">// the raw component options</span></span><br /><span class=\"line\">  it(<span class=\"string\">'sets the correct default data'</span>, () =&gt; {</span><br /><span class=\"line\">    expect(<span class=\"keyword\">typeof</span> MyComponent.data).toBe(<span class=\"string\">'function'</span>)</span><br /><span class=\"line\">    <span class=\"keyword\">const</span> defaultData = MyComponent.data()</span><br /><span class=\"line\">    expect(defaultData.message).toBe(<span class=\"string\">'hello!'</span>)</span><br /><span class=\"line\">  })</span><br /><br /><span class=\"line\">  <span class=\"comment\">// Inspect the component instance on mount</span></span><br /><span class=\"line\">  it(<span class=\"string\">'correctly sets the message when created'</span>, () =&gt; {</span><br /><span class=\"line\">    <span class=\"keyword\">const</span> vm = <span class=\"keyword\">new</span> Vue(MyComponent).$mount()</span><br /><span class=\"line\">    expect(vm.message).toBe(<span class=\"string\">'bye!'</span>)</span><br /><span class=\"line\">  })</span><br /><br /><span class=\"line\">  <span class=\"comment\">// Mount an instance and inspect the render output</span></span><br /><span class=\"line\">  it(<span class=\"string\">'renders the correct message'</span>, () =&gt; {</span><br /><span class=\"line\">    <span class=\"keyword\">const</span> Constructor = Vue.extend(MyComponent)</span><br /><span class=\"line\">    <span class=\"keyword\">const</span> vm = <span class=\"keyword\">new</span> Constructor().$mount()</span><br /><span class=\"line\">    expect(vm.$el.textContent).toBe(<span class=\"string\">'bye!'</span>)</span><br /><span class=\"line\">  })</span><br /><span class=\"line\">})</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<h2 id=\"Writing-Testable-Components\"><a class=\"headerlink\" title=\"Writing Testable Components\" href=\"https://vuejs.org/v2/guide/unit-testing.html#Writing-Testable-Components\" data-scroll=\"\">Writing Testable Components</a></h2>\n" +
                    "<p>A component&rsquo;s render output is primarily determined by the props it receives. If a component&rsquo;s render output solely depends on its props it becomes straightforward to test, similar to asserting the return value of a pure function with different arguments. Take a simplified example:</p>\n" +
                    "<figure class=\"highlight html\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">template</span>&gt;</span></span><br /><span class=\"line\">  <span class=\"tag\">&lt;<span class=\"name\">p</span>&gt;</span>{{ msg }}<span class=\"tag\">&lt;/<span class=\"name\">p</span>&gt;</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">template</span>&gt;</span></span><br /><br /><span class=\"line\"><span class=\"tag\">&lt;<span class=\"name\">script</span>&gt;</span></span><br /><span class=\"line\"><span class=\"javascript\">  <span class=\"keyword\">export</span> <span class=\"keyword\">default</span> {</span></span><br /><span class=\"line\"><span class=\"javascript\">    props: [<span class=\"string\">'msg'</span>]</span></span><br /><span class=\"line\"><span class=\"undefined\">  }</span></span><br /><span class=\"line\"><span class=\"tag\">&lt;/<span class=\"name\">script</span>&gt;</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>You can assert its render output with different props using the&nbsp;<code>propsData</code>&nbsp;option:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"keyword\">import</span> Vue <span class=\"keyword\">from</span> <span class=\"string\">'vue'</span></span><br /><span class=\"line\"><span class=\"keyword\">import</span> MyComponent <span class=\"keyword\">from</span> <span class=\"string\">'./MyComponent.vue'</span></span><br /><br /><span class=\"line\"><span class=\"comment\">// helper function that mounts and returns the rendered text</span></span><br /><span class=\"line\"><span class=\"function\"><span class=\"keyword\">function</span> <span class=\"title\">getRenderedText</span> (<span class=\"params\">Component, propsData</span>) </span>{</span><br /><span class=\"line\">  <span class=\"keyword\">const</span> Constructor = Vue.extend(Component)</span><br /><span class=\"line\">  <span class=\"keyword\">const</span> vm = <span class=\"keyword\">new</span> Constructor({ <span class=\"attr\">propsData</span>: propsData }).$mount()</span><br /><span class=\"line\">  <span class=\"keyword\">return</span> vm.$el.textContent</span><br /><span class=\"line\">}</span><br /><br /><span class=\"line\">describe(<span class=\"string\">'MyComponent'</span>, () =&gt; {</span><br /><span class=\"line\">  it(<span class=\"string\">'renders correctly with different props'</span>, () =&gt; {</span><br /><span class=\"line\">    expect(getRenderedText(MyComponent, {</span><br /><span class=\"line\">      msg: <span class=\"string\">'Hello'</span></span><br /><span class=\"line\">    })).toBe(<span class=\"string\">'Hello'</span>)</span><br /><br /><span class=\"line\">    expect(getRenderedText(MyComponent, {</span><br /><span class=\"line\">      msg: <span class=\"string\">'Bye'</span></span><br /><span class=\"line\">    })).toBe(<span class=\"string\">'Bye'</span>)</span><br /><span class=\"line\">  })</span><br /><span class=\"line\">})</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<h2 id=\"Asserting-Asynchronous-Updates\"><a class=\"headerlink\" title=\"Asserting Asynchronous Updates\" href=\"https://vuejs.org/v2/guide/unit-testing.html#Asserting-Asynchronous-Updates\" data-scroll=\"\">Asserting Asynchronous Updates</a></h2>\n" +
                    "<p>Since Vue&nbsp;<a href=\"https://vuejs.org/v2/guide/reactivity.html#Async-Update-Queue\">performs DOM updates asynchronously</a>, assertions on DOM updates resulting from state change will have to be made in a&nbsp;<code>Vue.nextTick</code>&nbsp;callback:</p>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"comment\">// Inspect the generated HTML after a state update</span></span><br /><span class=\"line\">it(<span class=\"string\">'updates the rendered message when vm.message updates'</span>, done =&gt; {</span><br /><span class=\"line\">  <span class=\"keyword\">const</span> vm = <span class=\"keyword\">new</span> Vue(MyComponent).$mount()</span><br /><span class=\"line\">  vm.message = <span class=\"string\">'foo'</span></span><br /><br /><span class=\"line\">  <span class=\"comment\">// wait a \"tick\" after state change before asserting DOM updates</span></span><br /><span class=\"line\">  Vue.nextTick(<span class=\"function\"><span class=\"params\">()</span> =&gt;</span> {</span><br /><span class=\"line\">    expect(vm.$el.textContent).toBe(<span class=\"string\">'foo'</span>)</span><br /><span class=\"line\">    done()</span><br /><span class=\"line\">  })</span><br /><span class=\"line\">})</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>We are planning to work on a collection of common test helpers to make it easier to render components with different constraints (e.g. shallow rendering that ignores child components) and assert their output.</p>");
            sec3Vue2.setLesson(vueJsLesson2);
            vueJsLesson2.getSections().add(sec3Vue2);

            Section sec4Vue2 = new Section();
            sec4Vue2.setOrdinalNumber(4);
            sec4Vue2.setDescription("TypeScript Support");
            sec4Vue2.setContent("<p>A static type system can help prevent many potential runtime errors, especially as applications grow. That&rsquo;s why Vue ships with&nbsp;<a href=\"https://github.com/vuejs/vue/tree/dev/types\" target=\"_blank\" rel=\"noopener\">official type declarations</a>&nbsp;for&nbsp;<a href=\"https://www.typescriptlang.org/\" target=\"_blank\" rel=\"noopener\">TypeScript</a>&nbsp;- not only in Vue core, but also for&nbsp;<a href=\"https://github.com/vuejs/vue-router/tree/dev/types\" target=\"_blank\" rel=\"noopener\">vue-router</a>&nbsp;and&nbsp;<a href=\"https://github.com/vuejs/vuex/tree/dev/types\" target=\"_blank\" rel=\"noopener\">vuex</a>&nbsp;as well.</p>\n" +
                    "<p>Since these are&nbsp;<a href=\"https://cdn.jsdelivr.net/npm/vue/types/\" target=\"_blank\" rel=\"noopener\">published on NPM</a>, and the latest TypeScript knows how to resolve type declarations in NPM packages, this means when installed via NPM, you don&rsquo;t need any additional tooling to use TypeScript with Vue.</p>\n" +
                    "<h2 id=\"Recommended-Configuration\"><a class=\"headerlink\" title=\"Recommended Configuration\" href=\"https://vuejs.org/v2/guide/typescript.html#Recommended-Configuration\" data-scroll=\"\">Recommended Configuration</a></h2>\n" +
                    "<figure class=\"highlight js\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"comment\">// tsconfig.json</span></span><br /><span class=\"line\">{</span><br /><span class=\"line\">  <span class=\"string\">\"compilerOptions\"</span>: {</span><br /><span class=\"line\">    <span class=\"comment\">// this aligns with Vue's browser support</span></span><br /><span class=\"line\">    <span class=\"string\">\"target\"</span>: <span class=\"string\">\"es5\"</span>,</span><br /><span class=\"line\">    <span class=\"comment\">// this enables stricter inference for data properties on `this`</span></span><br /><span class=\"line\">    <span class=\"string\">\"strict\"</span>: <span class=\"literal\">true</span>,</span><br /><span class=\"line\">    <span class=\"comment\">// if using webpack 2+ or rollup, to leverage tree shaking:</span></span><br /><span class=\"line\">    <span class=\"string\">\"module\"</span>: <span class=\"string\">\"es2015\"</span>,</span><br /><span class=\"line\">    <span class=\"string\">\"moduleResolution\"</span>: <span class=\"string\">\"node\"</span></span><br /><span class=\"line\">  }</span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>Note that you have to include&nbsp;<code>strict: true</code>&nbsp;(or at least&nbsp;<code>noImplicitThis: true</code>which is a part of&nbsp;<code>strict</code>&nbsp;flag) to leverage type checking of&nbsp;<code>this</code>&nbsp;in component methods otherwise it is always treated as&nbsp;<code>any</code>&nbsp;type.</p>\n" +
                    "<p>See&nbsp;<a href=\"https://www.typescriptlang.org/docs/handbook/compiler-options.html\" target=\"_blank\" rel=\"noopener\">TypeScript compiler options docs</a>&nbsp;for more details.</p>\n" +
                    "<h2 id=\"Development-Tooling\"><a class=\"headerlink\" title=\"Development Tooling\" href=\"https://vuejs.org/v2/guide/typescript.html#Development-Tooling\" data-scroll=\"\">Development Tooling</a></h2>\n" +
                    "<h3 id=\"Project-Creation\"><a class=\"headerlink\" title=\"Project Creation\" href=\"https://vuejs.org/v2/guide/typescript.html#Project-Creation\" data-scroll=\"\">Project Creation</a></h3>\n" +
                    "<p><a href=\"https://github.com/vuejs/vue-cli\" target=\"_blank\" rel=\"noopener\">Vue CLI 3</a>&nbsp;can generate new projects that use TypeScript. To get started:</p>\n" +
                    "<figure class=\"highlight bash\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"comment\"># 1. Install Vue CLI, if it's not already installed</span></span><br /><span class=\"line\">npm install --global @vue/cli</span><br /><br /><span class=\"line\"><span class=\"comment\"># 2. Create a new project, then choose the \"Manually select features\" option</span></span><br /><span class=\"line\">vue create my-project-name</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<h3 id=\"Editor-Support\"><a class=\"headerlink\" title=\"Editor Support\" href=\"https://vuejs.org/v2/guide/typescript.html#Editor-Support\" data-scroll=\"\">Editor Support</a></h3>\n" +
                    "<p>For developing Vue applications with TypeScript, we strongly recommend using&nbsp;<a href=\"https://code.visualstudio.com/\" target=\"_blank\" rel=\"noopener\">Visual Studio Code</a>, which provides great out-of-the-box support for TypeScript. If you are using&nbsp;<a href=\"https://vuejs.org/v2/guide/single-file-components.html\">single-file components</a>&nbsp;(SFCs), get the awesome&nbsp;<a href=\"https://github.com/vuejs/vetur\" target=\"_blank\" rel=\"noopener\">Vetur extension</a>, which provides TypeScript inference inside SFCs and many other great features.</p>\n" +
                    "<p><a href=\"https://www.jetbrains.com/webstorm/\" target=\"_blank\" rel=\"noopener\">WebStorm</a>&nbsp;also provides out-of-the-box support for both TypeScript and Vue.</p>\n" +
                    "<h2 id=\"Basic-Usage\"><a class=\"headerlink\" title=\"Basic Usage\" href=\"https://vuejs.org/v2/guide/typescript.html#Basic-Usage\" data-scroll=\"\">Basic Usage</a></h2>\n" +
                    "<p>To let TypeScript properly infer types inside Vue component options, you need to define components with&nbsp;<code>Vue.component</code>&nbsp;or&nbsp;<code>Vue.extend</code>:</p>\n" +
                    "<figure class=\"highlight ts\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"keyword\">import</span> Vue <span class=\"keyword\">from</span> <span class=\"string\">'vue'</span></span><br /><br /><span class=\"line\"><span class=\"keyword\">const</span> Component = Vue.extend({</span><br /><span class=\"line\">  <span class=\"comment\">// type inference enabled</span></span><br /><span class=\"line\">})</span><br /><br /><span class=\"line\"><span class=\"keyword\">const</span> Component = {</span><br /><span class=\"line\">  <span class=\"comment\">// this will NOT have type inference,</span></span><br /><span class=\"line\">  <span class=\"comment\">// because TypeScript can't tell this is options for a Vue component.</span></span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<h2 id=\"Class-Style-Vue-Components\"><a class=\"headerlink\" title=\"Class-Style Vue Components\" href=\"https://vuejs.org/v2/guide/typescript.html#Class-Style-Vue-Components\" data-scroll=\"\">Class-Style Vue Components</a></h2>\n" +
                    "<p>If you prefer a class-based API when declaring components, you can use the officially maintained&nbsp;<a href=\"https://github.com/vuejs/vue-class-component\" target=\"_blank\" rel=\"noopener\">vue-class-component</a>&nbsp;decorator:</p>\n" +
                    "<figure class=\"highlight ts\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"keyword\">import</span> Vue <span class=\"keyword\">from</span> <span class=\"string\">'vue'</span></span><br /><span class=\"line\"><span class=\"keyword\">import</span> Component <span class=\"keyword\">from</span> <span class=\"string\">'vue-class-component'</span></span><br /><br /><span class=\"line\"><span class=\"comment\">// The @Component decorator indicates the class is a Vue component</span></span><br /><span class=\"line\"><span class=\"meta\">@Component</span>({</span><br /><span class=\"line\">  <span class=\"comment\">// All component options are allowed in here</span></span><br /><span class=\"line\">  template: <span class=\"string\">'&lt;button @click=\"onClick\"&gt;Click!&lt;/button&gt;'</span></span><br /><span class=\"line\">})</span><br /><span class=\"line\"><span class=\"keyword\">export</span> <span class=\"keyword\">default</span> <span class=\"keyword\">class</span> MyComponent <span class=\"keyword\">extends</span> Vue {</span><br /><span class=\"line\">  <span class=\"comment\">// Initial data can be declared as instance properties</span></span><br /><span class=\"line\">  message: <span class=\"built_in\">string</span> = <span class=\"string\">'Hello!'</span></span><br /><br /><span class=\"line\">  <span class=\"comment\">// Component methods can be declared as instance methods</span></span><br /><span class=\"line\">  onClick (): <span class=\"built_in\">void</span> {</span><br /><span class=\"line\">    <span class=\"built_in\">window</span>.alert(<span class=\"keyword\">this</span>.message)</span><br /><span class=\"line\">  }</span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<h2 id=\"Augmenting-Types-for-Use-with-Plugins\"><a class=\"headerlink\" title=\"Augmenting Types for Use with Plugins\" href=\"https://vuejs.org/v2/guide/typescript.html#Augmenting-Types-for-Use-with-Plugins\" data-scroll=\"\">Augmenting Types for Use with Plugins</a></h2>\n" +
                    "<p>Plugins may add to Vue&rsquo;s global/instance properties and component options. In these cases, type declarations are needed to make plugins compile in TypeScript. Fortunately, there&rsquo;s a TypeScript feature to augment existing types called&nbsp;<a href=\"https://www.typescriptlang.org/docs/handbook/declaration-merging.html#module-augmentation\" target=\"_blank\" rel=\"noopener\">module augmentation</a>.</p>\n" +
                    "<p>For example, to declare an instance property&nbsp;<code>$myProperty</code>&nbsp;with type&nbsp;<code>string</code>:</p>\n" +
                    "<figure class=\"highlight ts\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"comment\">// 1. Make sure to import 'vue' before declaring augmented types</span></span><br /><span class=\"line\"><span class=\"keyword\">import</span> Vue <span class=\"keyword\">from</span> <span class=\"string\">'vue'</span></span><br /><br /><span class=\"line\"><span class=\"comment\">// 2. Specify a file with the types you want to augment</span></span><br /><span class=\"line\"><span class=\"comment\">//    Vue has the constructor type in types/vue.d.ts</span></span><br /><span class=\"line\"><span class=\"keyword\">declare</span> <span class=\"keyword\">module</span> 'vue/types/vue' {</span><br /><span class=\"line\">  <span class=\"comment\">// 3. Declare augmentation for Vue</span></span><br /><span class=\"line\">  <span class=\"keyword\">interface</span> Vue {</span><br /><span class=\"line\">    $myProperty: <span class=\"built_in\">string</span></span><br /><span class=\"line\">  }</span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>After including the above code as a declaration file (like&nbsp;<code>my-property.d.ts</code>) in your project, you can use&nbsp;<code>$myProperty</code>&nbsp;on a Vue instance.</p>\n" +
                    "<figure class=\"highlight ts\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"keyword\">var</span> vm = <span class=\"keyword\">new</span> Vue()</span><br /><span class=\"line\"><span class=\"built_in\">console</span>.log(vm.$myProperty) <span class=\"comment\">// This should compile successfully</span></span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>You can also declare additional global properties and component options:</p>\n" +
                    "<figure class=\"highlight ts\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"keyword\">import</span> Vue <span class=\"keyword\">from</span> <span class=\"string\">'vue'</span></span><br /><br /><span class=\"line\"><span class=\"keyword\">declare</span> <span class=\"keyword\">module</span> 'vue/types/vue' {</span><br /><span class=\"line\">  <span class=\"comment\">// Global properties can be declared</span></span><br /><span class=\"line\">  <span class=\"comment\">// on the `VueConstructor` interface</span></span><br /><span class=\"line\">  <span class=\"keyword\">interface</span> VueConstructor {</span><br /><span class=\"line\">    $myGlobal: <span class=\"built_in\">string</span></span><br /><span class=\"line\">  }</span><br /><span class=\"line\">}</span><br /><br /><span class=\"line\"><span class=\"comment\">// ComponentOptions is declared in types/options.d.ts</span></span><br /><span class=\"line\"><span class=\"keyword\">declare</span> <span class=\"keyword\">module</span> 'vue/types/options' {</span><br /><span class=\"line\">  <span class=\"keyword\">interface</span> ComponentOptions&lt;V <span class=\"keyword\">extends</span> Vue&gt; {</span><br /><span class=\"line\">    myOption?: <span class=\"built_in\">string</span></span><br /><span class=\"line\">  }</span><br /><span class=\"line\">}</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>\n" +
                    "<p>The above declarations allow the following code to be compiled:</p>\n" +
                    "<figure class=\"highlight ts\">\n" +
                    "<table>\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"code\">\n" +
                    "<pre><span class=\"line\"><span class=\"comment\">// Global property</span></span><br /><span class=\"line\"><span class=\"built_in\">console</span>.log(Vue.$myGlobal)</span><br /><br /><span class=\"line\"><span class=\"comment\">// Additional component option</span></span><br /><span class=\"line\"><span class=\"keyword\">var</span> vm = <span class=\"keyword\">new</span> Vue({</span><br /><span class=\"line\">  myOption: <span class=\"string\">'Hello'</span></span><br /><span class=\"line\">})</span></pre>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</figure>");
            sec4Vue2.setLesson(vueJsLesson2);
            vueJsLesson2.getSections().add(sec4Vue2);



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
//            Lesson savedNodeJsLesson4 = lessonRepository.save(nodeJsLesson4);
//            Lesson savedNodeJsLesson5 = lessonRepository.save(nodeJsLesson5);
//            Lesson savedNodeJsLesson6 = lessonRepository.save(nodeJsLesson6);
//            Lesson savedNodeJsLesson7 = lessonRepository.save(nodeJsLesson7);
            Lesson saveReactJsLesson1 = lessonRepository.save(reactJsLesson1);
            Lesson saveReactJsLesson2 = lessonRepository.save(reactJsLesson2);
            Lesson saveReactJsLesson3 = lessonRepository.save(reactJsLesson3);
//            Lesson saveReactJsLesson4 = lessonRepository.save(reactJsLesson4);
//            Lesson saveReactJsLesson5 = lessonRepository.save(reactJsLesson5);
//            Lesson saveReactJsLesson6 = lessonRepository.save(reactJsLesson6);
//            Lesson saveReactJsLesson7 = lessonRepository.save(reactJsLesson7);
            Lesson savedVueJsLesson1 = lessonRepository.save(vueJsLesson1);
            Lesson savedVueJsLesson2 = lessonRepository.save(vueJsLesson2);
//            Lesson savedVueJsLesson3 = lessonRepository.save(vueJsLesson3);
//            Lesson savedVueJsLesson4 = lessonRepository.save(vueJsLesson4);
//            Lesson savedVueJsLesson5 = lessonRepository.save(vueJsLesson5);
//            Lesson savedVueJsLesson6 = lessonRepository.save(vueJsLesson6);
//            Lesson savedVueJsLesson7 = lessonRepository.save(vueJsLesson7);

            Lesson savedReactLesson1 = lessonRepository.save(reactJsLesson1);

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
            alex.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--T4K0Tjc_--/v1540526585/geek/irene_f2cza2.jpg","cb5cb33439d81972f13d0f0cdd7444b077e1b25a5f5b74bc7dcf62050012e66eaac88df8ae8ec604cb36bf931ca929c11b863380762b5f8bd6456442adad992a8ceeda09b42f0e2f525f8fe05113c0df69105336535951d08afb8037e1772cb71dd5ee4fcc6867eb36d60a3c1e07fb0fd9fe83d7dfe27d360cd530f2661fb3978632786ab1aa7642e187e86ca9bcabca"));
            Instructor savedA = instructorRepository.save(alex);

            Instructor quill = new Instructor();
            quill.setUsername("quill");
            quill.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            quill.getRoles().add(saved_role_instructor);
            quill.setName("Quilliam Johnson");
            quill.setCompany("TMA Solutions");
            quill.setEmail("quill@tma.com");
            quill.setQuote("Cảm giác dạy học thì giống như một người mẹ");
            quill.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--bLkxdzZn--/v1540526659/geek/captain_vonp8b.jpg","02492856ffd783f06dcd1021c7efc35c841feac4e39da1a1152107b30e00066b0daa321ba4c08edba2dec41a89569aed7bb344d8e3222f560027599c8ee7e325e85ac603b97c72de1a74d8a9bb631a2e15afd95c9e02bcfd1de058326f8c7886166edc0f366dd5795f957faa5b9db6d9e7c4e2f8dbcc93b207912ff544c52e66ecec356a3b39f6ee06792a395c12f8ee"));
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
            tripleh.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--cwxXS8Ed--/v1540526706/geek/tripleh_qadolk.jpg","f35ef04866bf07e95983ce1a7a146b814d95ef29a07a132fbe3ebf1c9a9a574d03c7c45c18a5305bfe478961c4ff8024964e5bb6da71568dd3336777097a24b59bfd46b09258833683a8ee6d315f0343728d19d0fc2f4c2ab6b16a8c17c6e0af13aa072baa32b1fdf284a4f4fc40cc215dbb5c4fa7786605517ac0badce84ec37bf1fbcecc06659d06cbc9b9e2eefb0b"));
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
            rose.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--Tc0so-9p--/v1540526758/geek/jisoo_tcpgxv.jpg","fb424ae7896c1e429cfe8b6e6ef483daa3268b4d1cd447b07f9360f282f1fe735ff53173efeaa46cdf075ea99cdefb185ce32fee45d82591af15b634a8211ade0eb4bebb976a8f71ae65c969c034396a1742138579957d406c8382cdb93ab959b9f2aa1366f46fd2a3c719baa2f72830e60eda33cc498b2aa57121933b74518d32e408ce36e087857ce3314dfd97aa9b"));
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
            mrDao.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--csfdlqRD--/v1540526799/geek/mrdao_f7t5eg.jpg","6d0b3176551e76d75bba06ac74c8ab7755539e779e5e7b38198b234c9278211f2e85f1d2a4fd16729da8b720fca2c1cff366afa5371b596441112587251063abe5355e01ff46cf2644cdfb3dbbe0f407901e544334e982f77bdd90669c5dcfc96979b624614d153fa0f6b39ded9b352e328745de7a7df8a94bdbb22dec38fb3fd3f21035da883780e2cb4a9db88cc58d"));
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
            rapMonster.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--MTUe50aj--/v1540526856/geek/rm_qy7n3r.jpg","83c23c26feb5788a8913abe18273e5d9db86f207965f48475f955b51fb06702001969ea60775c68aea00bbdc1342aa7f873d1f3d4ea51eb8eb9ac2dbd53e73601b4cd912663c96a7821420cadca1345d03eaa49622dfdadb51da52ad3871f6124d008ef9257e02b20d4a1efeec62de34b756aa1ccf3e592a6781b43ceee143d225bfc455b356fd6e7f3cc59f35ed3d13"));
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
            mrHuy.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--jGkDLJSa--/v1540526898/geek/mrhuy_vl47x9.jpg","911848ab7dcb81207e021b2f54170599b325f5202c90968d6e82c8060463bdae6c02fe49151cb883223955e7121d9435d5e8f61c00bc26daba8d710fbd03c697199eaa1913bce532de3cad0df1f40267b28910484dd32c98e98a54c2cfba599290c84399614aec01f65ca3bc0e1bb109084aa0464c39555e1936684a98ea31190e113f26bc7e7967b2f1f7cb2eb0af2e"));
            Instructor savedMrHuy = instructorRepository.save(mrHuy);

            Instructor lisa = new Instructor();
            lisa.setUsername("lisa");
            lisa.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            lisa.getRoles().add(saved_role_instructor);
            lisa.setName("Lalisa Manoban");
            lisa.setCompany("YG Copany");
            lisa.setEmail("lisa@tma.com");
            lisa.setQuote("너의 눈에 비친 나의 모습이 늘 처음 만난 그 날만 같길 소리 없이 타오르는 불꽃같이");
            lisa.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--913coQRo--/v1540526988/geek/lisa_ghvqcw.jpg","e07c565e38a2e15b5d04950a41f3ba0004bba8f168cc5e0ab65257b429e166093cdc93e7c5d13a97d4d7c80013e7d75355f21f361dbd7d0256b517af70b350346a997fbdeff9e4efa4bb720b60e619809ae31ce74f6da519304dc16d4bf484652e030f0f79be044eec447c2895efb46afabbf9230d8449e42e56c963836e699ab1707aef5a148348f26d00c3d25b9e17"));
            lisa.getCourses().add(savedcScharp);
            lisa.getCourses().add(savedphpCourse);
            lisa.getCourses().add(savedtypeScript);
            lisa.getCourses().add(savedHtml);
            lisa.getCourses().add(savedLinux);
            lisa.getCourses().add(savedCss);
            lisa.getCourses().add(savedJava);
            lisa.getCategories().add(savedcat3);
            Instructor savedLisa = instructorRepository.save(lisa);

            // Init Student--------------------------------------------------------------------------------
            Section savedSec1Node1 = sectionRepository.save(sec1Node1);
            Section savedSec3Node1 = sectionRepository.save(sec3Node1);
            Section savedSec1React1 = sectionRepository.save(sec1React1);
            Section savedSec1Vue1 = sectionRepository.save(sec1Vue1);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


            Student dinhquang = new Student();
            dinhquang.getRoles().add(saved_role_learner);
            dinhquang.getRoles().add(saved_role_admin);
            dinhquang.setUsername("dinhquang");
            dinhquang.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            dinhquang.setEmail("ledinhquang@gmail.com");
            dinhquang.setName("Lê Đình Quang");
            dinhquang.setDob(format.parse("2009-12-31"));
            dinhquang.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--913coQRo--/v1540526988/geek/lisa_ghvqcw.jpg","e07c565e38a2e15b5d04950a41f3ba0004bba8f168cc5e0ab65257b429e166093cdc93e7c5d13a97d4d7c80013e7d75355f21f361dbd7d0256b517af70b350346a997fbdeff9e4efa4bb720b60e619809ae31ce74f6da519304dc16d4bf484652e030f0f79be044eec447c2895efb46afabbf9230d8449e42e56c963836e699ab1707aef5a148348f26d00c3d25b9e17"));
            dinhquang.setSchool("UTE");

            Student savedDinhQuang = studentRepository.save(dinhquang);

            StudentCourse studentCourseDinhquang =new StudentCourse(savedDinhQuang,savedNodeJs);
            studentCourseDinhquang.setCurrentLesson(savedNodeJsLesson1);
            studentCourseDinhquang.setCurrentSection(savedSec3Node1);
            savedDinhQuang.getCourses().add(studentCourseDinhquang);

            StudentCourse studentCourseDinhquangVue =new StudentCourse(savedDinhQuang,savedVueJs);
            studentCourseDinhquangVue.setCurrentLesson(savedVueJsLesson1);
            studentCourseDinhquangVue.setCurrentSection(savedSec1Vue1);
            savedDinhQuang.getCourses().add(studentCourseDinhquangVue);


            StudentCourse studentCourseDinhquangReact =new StudentCourse(savedDinhQuang,savedReactJS);
            studentCourseDinhquangReact.setCurrentLesson(savedReactLesson1);
            studentCourseDinhquangReact.setCurrentSection(savedSec1React1);
            savedDinhQuang.getCourses().add(studentCourseDinhquangReact);
            studentRepository.save(savedDinhQuang);

            Student hongvan = new Student();
            hongvan.getRoles().add(saved_role_learner);
            hongvan.setUsername("hongvan");
            hongvan.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            hongvan.setName("Hồng Vân");
            hongvan.setDob(format.parse("2009-12-31"));
            hongvan.setEmail("hongvan@gmail.com");
            hongvan.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--913coQRo--/v1540526988/geek/lisa_ghvqcw.jpg","e07c565e38a2e15b5d04950a41f3ba0004bba8f168cc5e0ab65257b429e166093cdc93e7c5d13a97d4d7c80013e7d75355f21f361dbd7d0256b517af70b350346a997fbdeff9e4efa4bb720b60e619809ae31ce74f6da519304dc16d4bf484652e030f0f79be044eec447c2895efb46afabbf9230d8449e42e56c963836e699ab1707aef5a148348f26d00c3d25b9e17"));
            hongvan.setSchool("PVS");
            hongvan.addCourse(saveddockerCourse);
            Student savedHongVan = studentRepository.save(hongvan);

            Student khanhhoang = new Student();
            khanhhoang.getRoles().add(saved_role_learner);
            khanhhoang.setUsername("khanhhoang");
            khanhhoang.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            khanhhoang.setName("Khánh Hoàng");
            khanhhoang.setEmail("khanhhoang@gmail.com");
            khanhhoang.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--913coQRo--/v1540526988/geek/lisa_ghvqcw.jpg","e07c565e38a2e15b5d04950a41f3ba0004bba8f168cc5e0ab65257b429e166093cdc93e7c5d13a97d4d7c80013e7d75355f21f361dbd7d0256b517af70b350346a997fbdeff9e4efa4bb720b60e619809ae31ce74f6da519304dc16d4bf484652e030f0f79be044eec447c2895efb46afabbf9230d8449e42e56c963836e699ab1707aef5a148348f26d00c3d25b9e17"));
            khanhhoang.setSchool("PVS");
            khanhhoang.setDob(format.parse("2009-12-31"));


            Student savedKhanhHoang = studentRepository.save(khanhhoang);


            StudentCourse studentCourse=new StudentCourse(savedKhanhHoang,saveddockerCourse);
//            studentCourse.setCourse(saveddockerCourse);
//            studentCourse.setStudent(savedKhanhHoang);

            savedKhanhHoang.getCourses().add(studentCourse);

            studentRepository.save(savedKhanhHoang);

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

//            Optional<Instructor> instructorOptional = instructorRepository.findByName("Quilliam Johnson");
//            if (instructorOptional.isPresent()) {
//                Instructor quillfound = instructorOptional.get();
//                Optional<Course> courseOptional = courseRepository.findByName("Node JS Basic");
//                if (courseOptional.isPresent()) {
//                    Course nodefound = courseOptional.get();
//                    quillfound.getCourses().add(nodefound);
//                    instructorRepository.save(quillfound);
//                }
//            }
//
//            Category en = categoryRepository.findByName("Engineering").get();
//
//
//            Optional<Category> optionalCategory = categoryRepository.findByNameOrId(en.getId(),en.getId());
//            if(optionalCategory.isPresent()){
//                System.out.println(optionalCategory.get().getName());
//            }

            Optional<Student> accountOptional = studentRepository.findByUsername("dinhquang");
            if (accountOptional.isPresent()) {
                System.out.println("found");
                System.out.println(accountOptional.get().getEncrytedPassword());

                System.out.println(accountOptional.get().getCourses().size());
                for (StudentCourse ac : accountOptional.get().getCourses()
                ) {
                    System.out.println(ac.getCourse().getName());
                }
            }

            Optional<Course> courseOptional = courseRepository.findByName("Docker - magic tool");
            if (courseOptional.isPresent()) {
                System.out.println("found");
                for (StudentCourse ac : courseOptional.get().getStudents()
                ) {
                    System.out.println(ac.getStudent().getName());
                }
            }
        }
    }
}
