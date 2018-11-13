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

            Lesson nodeJsLesson5 = new Lesson();
            nodeJsLesson5.setOrdinalNumber(5);
            nodeJsLesson5.setName("Node js chap 5");
            nodeJsLesson5.setDescription("Build a Slack Bot with Node.js on Kubernetes");
            nodeJsLesson5.setCourse(nodeJs);
            nodeJs.getLessons().add(nodeJsLesson5);

            Lesson nodeJsLesson6 = new Lesson();
            nodeJsLesson6.setOrdinalNumber(6);
            nodeJsLesson6.setName("Node js chap 6");
            nodeJsLesson6.setDescription("Running Node.js on a Virtual Machine");
            nodeJsLesson6.setCourse(nodeJs);
            nodeJs.getLessons().add(nodeJsLesson6);

            Lesson nodeJsLesson7 = new Lesson();
            nodeJsLesson7.setOrdinalNumber(7);
            nodeJsLesson7.setName("Node js chap 7");
            nodeJsLesson7.setDescription("Using Cloud Vision with Node.js");
            nodeJsLesson7.setCourse(nodeJs);
            nodeJs.getLessons().add(nodeJsLesson7);

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

            Lesson reactJsLesson5 = new Lesson();
            reactJsLesson5.setOrdinalNumber(5);
            reactJsLesson5.setName("React js chap 5");
            reactJsLesson5.setDescription("Advanced Guides");
            reactJsLesson5.setCourse(reactJs);
            reactJs.getLessons().add(reactJsLesson5);

            Lesson reactJsLesson6 = new Lesson();
            reactJsLesson6.setOrdinalNumber(6);
            reactJsLesson6.setName("React js chap 6");
            reactJsLesson6.setDescription("API References");
            reactJsLesson6.setCourse(reactJs);
            reactJs.getLessons().add(reactJsLesson6);

            Lesson reactJsLesson7 = new Lesson();
            reactJsLesson7.setOrdinalNumber(7);
            reactJsLesson7.setName("React js chap 7");
            reactJsLesson7.setDescription("Hooks");
            reactJsLesson7.setCourse(reactJs);
            reactJs.getLessons().add(reactJsLesson7);

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

            Lesson vueJsLesson3 = new Lesson();
            vueJsLesson3.setOrdinalNumber(3);
            vueJsLesson3.setName("Vue js chap 3");
            vueJsLesson3.setDescription("Cascading the one-to-one persist operation\n" +
                    "The CascadeType.PERSIST comes along with the CascadeType.ALL configuration, so we only have to persist the Post entity, and the associated PostDetails entity is persisted as well");
            vueJsLesson3.setCourse(vueJs);
            vueJs.getLessons().add(vueJsLesson3);

            Lesson vueJsLesson4 = new Lesson();
            vueJsLesson4.setOrdinalNumber(4);
            vueJsLesson4.setName("Vue js chap 4");
            vueJsLesson4.setDescription("Essentials");
            vueJsLesson4.setCourse(vueJs);
            vueJs.getLessons().add(vueJsLesson4);

            Lesson vueJsLesson5 = new Lesson();
            vueJsLesson5.setOrdinalNumber(5);
            vueJsLesson5.setName("Vue js chap 5");
            vueJsLesson5.setDescription("Components In-Depth");
            vueJsLesson5.setCourse(vueJs);
            vueJs.getLessons().add(vueJsLesson5);

            Lesson vueJsLesson6 = new Lesson();
            vueJsLesson6.setOrdinalNumber(6);
            vueJsLesson6.setName("Vue js chap 6");
            vueJsLesson6.setDescription("Transitions & Animation");
            vueJsLesson6.setCourse(vueJs);
            vueJs.getLessons().add(vueJsLesson6);

            Lesson vueJsLesson7 = new Lesson();
            vueJsLesson7.setOrdinalNumber(7);
            vueJsLesson7.setName("Vue js chap 7");
            vueJsLesson7.setDescription("Reusability & Composition");
            vueJsLesson7.setCourse(vueJs);
            vueJs.getLessons().add(vueJsLesson7);

            //Init Section ----------------------------------------------------------------------------------------------------------

            Section sec1Node1 = new Section();
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
            Lesson savedNodeJsLesson4 = lessonRepository.save(nodeJsLesson4);
            Lesson savedNodeJsLesson5 = lessonRepository.save(nodeJsLesson5);
            Lesson savedNodeJsLesson6 = lessonRepository.save(nodeJsLesson6);
            Lesson savedNodeJsLesson7 = lessonRepository.save(nodeJsLesson7);
            Lesson saveReactJsLesson1 = lessonRepository.save(reactJsLesson1);
            Lesson saveReactJsLesson2 = lessonRepository.save(reactJsLesson2);
            Lesson saveReactJsLesson3 = lessonRepository.save(reactJsLesson3);
            Lesson saveReactJsLesson4 = lessonRepository.save(reactJsLesson4);
            Lesson saveReactJsLesson5 = lessonRepository.save(reactJsLesson5);
            Lesson saveReactJsLesson6 = lessonRepository.save(reactJsLesson6);
            Lesson saveReactJsLesson7 = lessonRepository.save(reactJsLesson7);
            Lesson savedVueJsLesson1 = lessonRepository.save(vueJsLesson1);
            Lesson savedVueJsLesson2 = lessonRepository.save(vueJsLesson2);
            Lesson savedVueJsLesson3 = lessonRepository.save(vueJsLesson3);
            Lesson savedVueJsLesson4 = lessonRepository.save(vueJsLesson4);
            Lesson savedVueJsLesson5 = lessonRepository.save(vueJsLesson5);
            Lesson savedVueJsLesson6 = lessonRepository.save(vueJsLesson6);
            Lesson savedVueJsLesson7 = lessonRepository.save(vueJsLesson7);

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

            Student dinhquang = new Student();
            dinhquang.getRoles().add(saved_role_learner);
            dinhquang.setUsername("dinhquang");
            dinhquang.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            dinhquang.setEmail("ledinhquang@gmail.com");
            dinhquang.setName("Lê Đình Quang");
//          dinhquang.setDob(new Date("03-04-2018"));
            dinhquang.setImage(new Image("https://res.cloudinary.com/quanglibrary/image/upload/s--913coQRo--/v1540526988/geek/lisa_ghvqcw.jpg","e07c565e38a2e15b5d04950a41f3ba0004bba8f168cc5e0ab65257b429e166093cdc93e7c5d13a97d4d7c80013e7d75355f21f361dbd7d0256b517af70b350346a997fbdeff9e4efa4bb720b60e619809ae31ce74f6da519304dc16d4bf484652e030f0f79be044eec447c2895efb46afabbf9230d8449e42e56c963836e699ab1707aef5a148348f26d00c3d25b9e17"));
            dinhquang.setSchool("UTE");

            dinhquang.addCourse(saveddockerCourse);
            Student savedDinhQuang = studentRepository.save(dinhquang);

            StudentCourse studentCourseDinhquang =new StudentCourse(savedDinhQuang,savedNodeJs);
            studentCourseDinhquang.setCurrentLesson(savedNodeJsLesson1);
            studentCourseDinhquang.setCurrentSection(savedSec3Node1);
            savedDinhQuang.getCourses().add(studentCourseDinhquang);

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
