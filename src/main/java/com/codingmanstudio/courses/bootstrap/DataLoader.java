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
            dinhquang.addCourse(savedphpCourse);
            Student savedDinhQuang = studentRepository.save(dinhquang);

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


            StudentCourse studentCourse=new StudentCourse(khanhhoang,saveddockerCourse);

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
