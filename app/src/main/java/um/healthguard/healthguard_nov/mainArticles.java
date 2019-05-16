package um.healthguard.healthguard_nov;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class mainArticles extends AppCompatActivity {

    RecyclerView recyclerView;
    ArticleAdapter adapter;

    ArrayList<Article> articleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_articles);

        android.support.v7.widget.Toolbar articleToolbar = findViewById(R.id.article_toolbar);
        setSupportActionBar(articleToolbar);
        getSupportActionBar().setTitle("Articles and Guides");
//        getActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        articleList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        articleList.add(
                new Article(
                        1,
                        "Running",
                        "Why we love run. Why do we run?                ",
                        4.7,
                        R.drawable.running,
                        "\"Daddy, where are you going?\" my son asked me recently as I was lacing up my running shoes on a cold, wet Sunday morning. \"Running,\" I said. \"Why?\" he asked.\n" +
                                "\n" +
                                "He's only three. But it was a good question, and one I couldn't readily answer. I didn't really want to go. My body was still jarring from the shock of being hauled out of its cosy bed. I was training for a marathon, sure, but it was still months away. Right at that moment, it didn't feel critically important to be heading out into the unruly winter morning. I could go later. Or the next day. Or just not run the marathon. Why was I even running a marathon? But something was making me go. \"Because it's fun,\" I said, rather unconvincingly.\n" +
                                "\n" +
                                "The truth is, just before you run is the worst possible moment to try to explain to someone, or even to yourself, why you run. It just doesn't make sense. Running is hard. It requires effort. And after all the pain you usually end up right back where you started, having run in a big, pointless circle.\n" +
                                "\n" +
                                "Often people say to me they can run if they're chasing a ball, but to just run, nothing else, just one foot in front of the other, well, they find it too boring. I listen and nod, not sure I could convince them otherwise, even if I tried. Running doesn't have logic on its side.\n" +
                                "\n" +
                                "Of course, some people run to lose weight, or to get fit, and these are great reasons. Running is also easy to do, it's cheap, and you can do it when you want without having to book a court or rustle up a team. All these factors certainly contribute to the fact that running is one of the most popular sports in the UK, with more than two million people in England running at least once a week, according to Sport England.\n" +
                                "\n" +
                                "But for many of those two million runners, the real reason we head out to pound the roads until our legs hurt is more intangible than weight loss or fitness. I remember, as a keen runner in my youth, constantly correcting people who asked me if I was running to get fit. \"No,\" I would say. \"I'm getting fit to run.\" I may have thought I was being clever, but for me and many others, running has its own inherent raison d'être. What that is, however, is harder to put your finger on.\n" +
                                "\n" +
                                "Many runners become obsessed with times. The need to break the 40-minute barrier for the 10K, for example, or run under four hours for the marathon, can become the all-conquering reason. There is something reassuring about striving towards such fixed goals, measuring your progress in numbers that are not open to interpretation, but stand there as unambiguous achievements in an otherwise confusing world. Yet, really, these numbers are so arbitrary as to be almost meaningless. And as soon as they are achieved, another target is thrown out almost instantly.\n" +
                                "\n" +
                                "A runner I know last year trained with intense dedication with the goal of running a marathon in less than three hours. In the end he ran three hours and two minutes. Afterwards I spoke to him expecting him to be distraught at coming so close. On the contrary, he was pleased.\n" +
                                "\n" +
                                "\"I'm actually glad,\" he said. \"If I'd done it, that would be it. Now I've still got my target, I can try again next year.\"\n" +
                                "\n" +
                                "No, the times themselves are not the reason we run mile after mile, up hills, in wind and rain, when we could be still cosy in bed, or relaxing with a drink in the pub. The times are merely the carrots we dangle in front of ourselves. We're like little Pacmen chasing PBs (personal bests), gobbling them up before looking for more. But why do we dangle them there in the first place.\n" +
                                "\n" +
                                "\"Why do we do this to ourselves!\" It's a common refrain at running clubs up and down the country. Usually I hear it as I'm about to head out to run with a group of men and women in fluorescent tops, a sense of foreboding mingling among us in anticipation of the pain we're about to put ourselves through. But nobody ever gives a sensible answer. It's a rhetorical question. Deep down, we all know the answer.\n" +
                                "\n" +
                                "Running brings us joy. Watch small children when they are excited, at play, and mostly they can't stop running. Back and forth, up and down, in little, pointless circles. I remember, even as an older child, I'd often break into a run when walking along the street, for no reason. There's a great moment in The Catcher in the Rye when Holden Caulfield, caught in the uneasy space between childhood and adulthood, is walking across his school grounds one evening and he suddenly starts to run. \"I don't even know what I was running for – I guess I just felt like it,\" he says.\n" +
                                "\n" +
                                "This will to run is innate. In fact, humans may well have evolved the way we did because of our ability to run. Christopher McDougall's bestselling book Born to Run is largely based around a theory devised by Harvard scientists that humans evolved through persistence hunting – chasing animals down until they dropped dead. It's why we have Achillies tendons, arched feet, big bums, and a nuchal ligament at the back of our necks (to keep our heads still as we run). While even Usain Bolt would be left trailing in a sprint against most four-legged mammals, over long distances we are the Olympic champions of the animal kingdom. If they could keep them in sight for long enough, our ancestors could catch even the swiftest runners such as antelope just by running after them.\n" +
                                "\n" +
                                "Indeed, the great Kenyan runner Mike Boit told me the story of how his village held a celebration for him after he won the 1978 Commonwealth Games. He was showing off his medal when his old childhood friend came up to him and said: \"That's all very good, but can you still catch an antelope?\"\n" +
                                "\n" +
                                "But while as children, and even adolescents, we can respond to this natural urge to run and break into a trot whenever the feeling takes us, as adults it's not the done thing to just start running at any moment, without any reason. So we formalise it. We become runners. We buy running kit. We set out our carrots (our targets), we download iPhone apps, we get people to sponsor us (so there's no backing out), and once everything is set up, finally we can run.\n" +
                                "\n" +
                                "Racing along out on the trails, or even through the busy streets of a city, splashing through puddles, letting the rain drench us, the wind ruffle us, we begin to sense a faint recollection of that childish joy. Somewhere a primal essence stirs deep within us; this being born not to sit at a desk or read newspapers and drink coffee, but to live a wilder existence. As we run, the layers of responsibility and identity we have gathered in our lives, the father, mother, lawyer, teacher, Manchester United-supporter labels, all fall away, leaving us with the raw human being underneath. It's a rare thing, and it can be confronting. Some of us will stop, almost shocked by ourselves, by how our heart is pumping, by how our mind is racing, struggling with our attempts to leave it behind.\n" +
                                "\n" +
                                "But if we push on, running harder, deeper into the loneliness, further away from the world and the structure of our lives, we begin to feel strangely elated, detached yet at the same time connected, connected to ourselves. With nothing but our own two legs moving us, we begin to get a vague, tingling sense of who, or what, we really are.\n" +
                                "\n" +
                                "In Japan, the monks of mount Hiei run up to 1,000 marathons in 1,000 days in an attempt to reach enlightenment. I once stood by the roadside at around mile 24 of the London marathon, watching as person after person ran by, almost every one of them at a point in their lives they would rarely visit again. It was almost like seeing into their souls, their faces grimacing and contorted, but also alive with the effort. Each one of them soon after crossing the line would be glowing with a sense of wellbeing. Some may even be moved to tears by it (I was after my first marathon). It's the fabled runner's high, of course, but by labelling it such we diminish it. It may only be chemicals shooting around in your brain, but after a long run everything seems right in the world. Everything is at peace.\n" +
                                "\n" +
                                "To experience this is a powerful feeling, strong enough to have us coming back, again and again, for more."+"\n"));

        articleList.add(
                new Article(
                        2,
                        "How Teens Can Stay Fit",
                        "The most important thing is that you keep moving!",
                        4.0,
                        R.drawable.teen,
                        "Exercise should be a regular part of your day, like brushing your teeth, eating, and sleeping. It can be in gym class, joining a sports team, or working out on your own. Keep the following tips in mind:\n" +
                                "\n" +
                                "Stay positive and have fun. A good mental attitude is important. Find an activity that you think is fun. You are more likely to keep with it if you choose something you like. A lot of people find it's more fun to exercise with someone else, so see if you can find a friend or family member to be active with you.\n" +
                                "\n" +
                                "Take it one step at a time. Small changes can add up to better fitness. For example, walk or ride your bike to school or to a friend's house instead of getting a ride. Get on or off the bus several blocks away and walk the rest of the way. Use the stairs instead of taking the elevator or escalator.\n" +
                                "\n" +
                                "Get your heart pumping. Whatever you choose, make sure it includes aerobic activity that makes you breathe harder and increases your heart rate. This is the best type of exercise because it increases your fitness level and makes your heart and lungs work better. It also burns off body fat. Examples of aerobic activities are basketball, running, or swimming.\n" +
                                "\n" +
                                "Don't forget to warm up with some easy exercises or mild stretching before you do any physical activity. This warms your muscles up and may help protect against injury. Stretching makes your muscles and joints more flexible too. It is also important to stretch out after you exercise to cool down your muscles.\n" +
                                "\n" +
                                "Your goal should be to do some type of exercise every day. It is best to do some kind of aerobic activity without stopping for at least 20 to 30 minutes each time. Do the activity as often as possible, but don't exercise to the point of pain.\n" +
                                "\n" +
                                "A Healthy Lifestyle\n" +
                                "\n" +
                                "Watch less TV or spend less time playing computer or video games. (Use this time to exercise instead!) Or exercise while watching TV (for example, sit on the floor and do sit-ups and stretches; use hand weights; or use a stationary bike, treadmill, or stair climber).\n" +
                                "\n" +
                                "Eat 3 healthy meals a day, including at least 4 servings of fruits, 5 servings of vegetables, and 4 servings of dairy products.\n" +
                                "\n" +
                                "Make sure you drink plenty of fluids before, during, and after any exercise (water is best but flavored sports drinks can be used if they do not contain a lot of sugar). This will help replace what you lose when you sweat.\n" +
                                "\n" +
                                "Stop drinking or drink fewer regular soft drinks.\n" +
                                "\n" +
                                "Eat less junk food and fast food. (They're often full of fat, cholesterol, salt, and sugar.)\n" +
                                "\n" +
                                "Get 9 to 10 hours of sleep every night.\n" +
                                "\n" +
                                "Don't smoke cigarettes, drink alcohol, or do drugs"+"\n"));

        articleList.add(
                new Article(
                        3,
                        "Health and Fitness",
                        "The importance of good health.             ",
                        4.3,
                        R.drawable.goodhealth,
                        "HEALTH and Fitness Many people do not realize, and often underestimate, the importance of good health. Health, as they say, is wealth. Good health is necessary to carry out daily tasks. When discussing healthy, many people would consider the condition of their bodies and forget about the condition of their minds. However, health is not only about alleviating and being " +
                                "free from physical aspects of health. It also means being healthy in mind too.\n" +
                                "An unhealthy mind results in an unhealthy body. Good mental health helps you to make the most of life and enjoy it. Good mental health offers you a feeling of well-being and the inner strength needed in times of trouble or unrest. Everyone knows how to care for their bodies. This is done almost every day by the majority of people. Exercise and eating the proper foods are " +
                                "the best ways of keeping the body healthy. But, how does one keep the mind healthy? A healthy mind requires a lot of work, as well as, a combination of the right foods and exercise.\n" +
                                "Most often, the food consumed has a pivotal effect on the body, as well as, the mind. A healthy diet consists of the right food groups with right number of calories. It does not contain an excess of sugar, salt, fat and alcohol. Selecting the right foods that provide energy helps the body to be healthy. This also helps the mind. An energized person is a happy perso" +
                                "n. Happiness is a state of mind. Without proper energy, a person can become angry, tired and sad. These are not good for the mind.\n" +
                                "Exercise is extremely important to staying healthy both in body and mind. Being active can help a person continue to do things they enjoy and be independent as they age. Long term physical activity increases the benefits of long-term health. This is the reason many health experts advise individuals to be as active as possible and to set aside at least three days a" +
                                " week for some form of activity that keeps the heart beating at a steady pace. Physical exercise also has many mental benefits. For example, a person diagnosed with depression or anxiety is most often asked to conduct some form of physical activity apart from taking medication. This is because, the body produces hormones known as endorphins which improve mood and relieve " +
                                "stress. Depression can be alleviated by improving mood and anxiety can be relieved by reducing stress.\n" +
                                "Another method of keeping the mind healthy is to exercise it as often as possible. Just as physical exercise is good for the body, so is mental exercise for the mind. There are numerous ways to ensure a healthy mind through activity."+"\n"));

        articleList.add(
                new Article(
                        4,
                        "Why Drinking Water Is the Way to Go",
                        "What do you, the trees, and a hamster have in common? Give up? You all need water.",
                        3.6,
                        R.drawable.drinkwater,
                        "What do you, the trees, and a hamster have in common? Give up? You all need water. All living things must have water to survive, whether they get it from a water fountain, a rain cloud, or a little bottle attached to the side of a hamster cage.\n" +
                                "\n" +
                                "Without water, your body would stop working properly. Water makes up more than half of your body weight, and a person can't survive for more than a few days without it. Why? Your body has lots of important jobs and it needs water to do many of them. For instance, your blood, which contains a lot of water, carries oxygen to all the cells of your body. Without oxygen, those tiny cells would die and your body would stop working.\n" +
                                "\n" +
                                "Water is also in lymph (say: limf), a fluid that is part of your immune system, which helps you fight off illness. Water helps keep your temperature normal. You need water to digest your food and get rid of waste. Water is needed for digestive juices, urine (pee), and poop. And you can bet that water is the main ingredient in perspiration, also called sweat.\n" +
                                "\n" +
                                "Besides being an important part of the fluids in your body, water is needed by each cell to work.\n" +
                                "\n" +
                                "Your body doesn't get water only from drinking water. Any fluid you drink will contain water, but water and milk are the best choices. Lots of foods contain water too. Fruit contains quite a bit of water, which you could probably tell if you've ever bitten into a peach or plum and felt the juices dripping down your chin. Vegetables also contain a lot of water — think of slicing into a fat tomato or crunching into a crisp stalk of celery.\n" +
                                "\n" +
                                "How Much Is Enough?\n" +
                                "Because water is so important, you might wonder if you're drinking enough. There is no magic amount of water that kids need to drink every day. The amount kids need depends on their age, body size, health, and activity level, plus the weather (temperature and humidity levels).\n" +
                                "\n" +
                                "Usually, kids drink something with meals and should definitely drink when they're thirsty. But if you're sick, or it's warm out or you're exercising, you'll need more. Be sure to drink some extra water when you're out in warm weather, especially while playing sports or exercising.\n" +
                                "\n" +
                                "When you drink is also important. If you're going to sports practice, a game, or just working out or playing hard, drink water before, during, and after playing. Don't forget your water bottle. You can't play your best when you're thinking about how thirsty you are!\n" +
                                "\n" +
                                "When your body doesn't have enough water, that's called being dehydrated. Dehydration also can keep you from being as fast and as sharp as you'd like to be. A bad case of dehydration can make you sick. So keep that water bottle handy when the weather warms up! Not only does water fight dehydration, but it's refreshing and has no calories.\n" +
                                "\n" +
                                "Your body regulates the amount of water in your system. The body holds on to water when you don't have enough or gets rid of it if you have too much. If your pee is very light yellow, you are well hydrated. When your pee is very dark yellow, it's probably time to drink up.\n" +
                                "\n" +
                                "You can help your body by drinking when you're thirsty and drinking extra water when you exercise and when it's warm out. Your body will be able to do all of its wonderful, waterful jobs and you'll feel great!"+"\n"));

        articleList.add(
                new Article(
                        5,
                        "Health Eating",
                        "How to Eat Healthy, Lose Weight and Feel Awesome Every Day.",
                        3.2,
                        R.drawable.healthyfood,
                        "What Does \"Low-Carb, Real-Food\" Mean?\n" +
                                "Let me start by explaining a bit of terminology.\n" +
                                "\n" +
                                "A low-carbohydrate diet minimizes sugars and starches, replacing them with foods rich in protein and healthy fats.\n" +
                                "\"Real food\" means choosing foods that humans had access to throughout evolution. Processed, unnatural foods with artificial chemicals are avoided.\n" +
                                "LCRF is not a \"diet.\" It is a way of eating, a lifestyle change based on bulletproof scientific evidence.\n" +
                                "\n" +
                                "It is a way of eating that emphasizes the foods humans have evolved to eat for hundreds of thousands of years, before the agricultural and industrial revolutions.\n" +
                                "\n" +
                                "This type of diet is proven to work better than the low-fat diet still recommended all around the world.\n" +
                                "\n" +
                                "What Not to Eat\n" +
                                "You should limit the following foods.\n" +
                                "\n" +
                                "Sugar: Added sugar is addictive, fattening and a leading cause of diseases like obesity, diabetes and cardiovascular disease (1, 2, 3, 4, 5, 6).\n" +
                                "Grains: Avoid grains if you need to lose weight, including bread and pasta. Gluten grains (wheat, spelt, barley and rye) are the worst (7, 8, 9, 10, 11). Healthier grains like rice and oats are fine if you don't need to lose weight.\n" +
                                "Seed and vegetable oils: Soybean oil, corn oil and some others. These are processed fats with a high amount of Omega-6 fatty acids, which are harmful in excess (12, 13, 14).\n" +
                                "Trans fats: Chemically modified fats that are extremely bad for health. Found in some processed foods (15, 16, 17).\n" +
                                "Artificial sweeteners: Despite being calorie free, observational studies show a correlation with obesity and related diseases (18, 19, 20). If you must use sweeteners, choose Stevia.\n" +
                                "\"Diet\" and \"low-fat\" products: Most of these \"health foods\" aren't healthy at all. They tend to be highly processed and loaded with sugar or artificial sweeteners. Agave syrup is just as bad as sugar.\n" +
                                "Highly processed foods: Foods that are highly processed are usually low in nutrients and high in unhealthy and unnatural chemicals.\n" +
                                "You must read ingredient lists. You'll be surprised at the amount of \"health foods\" that can contain sugar, wheat and other harmful ingredients.\n" +
                                "\n" +
                                "Healthy Foods to Eat\n" +
                                "You should eat natural, unprocessed foods that humans are genetically adapted to eating. Research shows that such foods are great for health (21, 22, 23, 24).\n" +
                                "\n" +
                                "For healthy people who exercise and don't need to lose weight, there is absolutely no proven reason to avoid tubers like potatoes and sweet potatoes, or healthier non-gluten grains like oats and rice.\n" +
                                "\n" +
                                "If you are overweight or have metabolic issues (low HDL, high LDL cholesterol, triglycerides, belly fat, etc.) you should restrict all high-carb foods (25, 26).\n" +
                                "\n" +
                                "Meat: Beef, lamb, pork, chicken, etc. Humans have eaten meat for hundreds of thousands of years. Unprocessed meat is good for you, especially if the animals ate natural foods (like beef from grass-fed cows).\n" +
                                "Fish: Fish is great. Very healthy, fulfilling and rich in omega-3 fatty acids and other nutrients. You should eat fish (preferably fatty fish like salmon) every week.\n" +
                                "Eggs: Eggs are among the most nutritious foods on the planet. The yolk is the most nutritious and healthiest part. Omega-3 eggs are best.\n" +
                                "Vegetables: Contain fiber and many nutrients that are essential for the human body. Eat vegetables every day.\n" +
                                "Fruit: Increase variety, taste good, are easy to prepare and rich in fiber and vitamin C. They're still pretty high in sugar, so eat in moderation if you need to lose weight.\n" +
                                "Nuts and seeds: Almonds, walnuts, sunflower seeds, etc. Rich in various nutrients, but very high in calories. Eat in moderation if you need to lose weight.\n" +
                                "Potatoes: Root vegetables like potatoes and sweet potatoes are healthy, but they're still high in carbs. Eat in moderation if you need to lose weight.\n" +
                                "High-fat dairy: Cheese, cream, butter, full-fat yogurt, etc. Rich in healthy fats and calcium. Dairy from grass-fed cows will be rich in vitamin K2, which is very important for health (27, 28, 29).\n" +
                                "Fats and oils: Olive oil, butter, lard, etc. Choose saturated fats for high-heat cooking like pan frying, they are more stable in the heat.\n" +
                                "What to Drink?\n" +
                                "Coffee: Coffee is healthy and very rich in antioxidants, but people who are sensitive to caffeine should avoid it. Avoid coffee late in the day because it can ruin your sleep.\n" +
                                "Tea: Tea is healthy, rich in antioxidants and has a lot less caffeine than coffee.\n" +
                                "Water: You should drink water throughout the day and especially around workouts. No reason to drink a whole ton though, thirst is a pretty reliable indicator of your need.\n" +
                                "Carbonated soda without artificial sweeteners is fine.\n" +
                                "Avoid sodas with sugar and artificial sweeteners, fruit juice, milk and beer.\n" +
                                "\n" +
                                "Simple rule: Don't drink calories.\n" +
                                "\n" +
                                "Consume in Moderation\n" +
                                "These indulgences can be enjoyed from time to time.\n" +
                                "\n" +
                                "Dark Chocolate: Choose organic chocolate with 70% cocoa or more. Dark chocolate is rich in healthy fats and antioxidants.\n" +
                                "Alcohol: Choose dry wines and drinks that don't contain added sugar or carbs: vodka, whiskey, etc.\n" +
                                "How Many Carbs Per Day?\n" +
                                "This varies between individuals.\n" +
                                "\n" +
                                "Many people feel best eating very little carbs (under 50 grams) while others eat as much as 150 grams, which is still low-carb.\n" +
                                "\n" +
                                "You can use these numbers as a guideline:\n" +
                                "\n" +
                                "10-20 grams per day: Very low, can't eat any carbs except low-carb vegetables. Appropriate if you have a lot of weight to lose or if you have diabetes and/or the metabolic syndrome.\n" +
                                "20-50 grams per day: If you need to lose weight fast. You can eat quite a bit of vegetables and one piece of fruit per day.\n" +
                                "50-150 grams per day: If you want to achieve optimal health and lower your risk of lifestyle-related disease. There is room for several fruit per day and even a little bit of healthy starches like potatoes and rice.\n" +
                                "When you lower carbohydrates below 50 grams per day, you can't eat any sugar, bread, pasta, grains, potatoes and a maximum of one fruit per day.\n" +
                                "\n" +
                                "I recommend creating a free account on Fitday to log your food intake for a few days. This is great way to get a feel for the amount of carbs you are eating.\n" +
                                "\n" +
                                "Warning For Diabetics: Carbs in the diet are broken down into glucose in the digestive tract, then they enter the body as blood sugar. If you eat less carbs, you will need less insulin and glucose-lowering drugs.\n" +
                                "\n" +
                                "It is very dangerous if your blood sugar drops below a certain level (hypoglycemia). If you have diabetes, consult with your doctor before reducing carbohydrate intake.\n" +
                                "\n" +
                                "Why Does It Work?\n" +
                                "Humans evolved as hunter-gatherers for hundreds of thousands of years.\n" +
                                "\n" +
                                "Our diet changed drastically in the agricultural revolution, about 10,000 years ago.\n" +
                                "\n" +
                                "However, this change is small compared to the massive transformation we've seen in the last few decades with modern food processing.\n" +
                                "\n" +
                                "It is quite clear that humans today are eating a diet that is very different from the diet our ancestors thrived on throughout evolution.\n" +
                                "\n" +
                                "There are several \"primitive\" populations around the world that still live as hunter-gatherers, eating natural foods. These people are lean, in excellent health and most of the diseases that are killing western populations by the millions are rare or nonexistent (30, 31).\n" +
                                "\n" +
                                "Studies show that when people eat natural foods that were available to our hunter-gatherer ancestors (also known as the paleolithic diet), they lose weight and see massive improvements in health (21, 22, 23, 24).\n" +
                                "\n" +
                                "The Hormone Insulin\n" +
                                "The hormone insulin is well known for its role of moving glucose from the blood and into cells. A deficiency in insulin, or resistance to its effects, causes diabetes.\n" +
                                "\n" +
                                "But insulin also has other roles in the body. Insulin tells fat cells to produce fat and to stop breaking down the fat that they carry. When insulin levels are high, the body chooses not to dip in to the fat stores to provide energy.\n" +
                                "\n" +
                                "On a Western, high-carb diet, insulin levels are high all the time, keeping the fat safely locked away in the fat cells.\n" +
                                "\n" +
                                "Carbs are the main driver of insulin secretion. A low carb diet lowers and balances blood sugar and therefore lowers insulin levels (32, 33, 34).\n" +
                                "\n" +
                                "When insulin goes down, the body can easily access the calories stored in the fat cells, but it can take a few days to adapt to burning fat instead of carbs (35, 36).\n" +
                                "\n" +
                                "Low carbohydrate diets are very satiating. Appetite goes down and people start to automatically eat fewer calories than they burn, which causes weight loss (37).\n" +
                                "\n" +
                                "The main advantage of a low-carb diet is that you can eat until fullness and lose weight without counting calories. Eat low-carb and you avoid the worst side effect of calorie restricted diets: hunger.\n" +
                                "\n" +
                                "Health Benefits of a Low Carb Diet\n" +
                                "It is a common misunderstanding, even among health professionals, that low-carb diets are somehow bad for health. People who make such claims obviously haven't bothered to check out the research.\n" +
                                "\n" +
                                "Their main argument is that low-carb diets are bad because they're high in saturated fat, which raises cholesterol and causes heart disease.\n" +
                                "\n" +
                                "But recent research suggests that there is nothing to worry about. Saturated fats raise HDL (the good) cholesterol and change the \"bad\" cholesterol from small, dense LDL (very bad) to large LDL which is benign (38, 39, 40, 41).\n" +
                                "\n" +
                                "The fact is that saturated fat does not cause heart disease. This is simply a myth that has never been proven (42, 43, 44).\n" +
                                "\n" +
                                "Low-carb diets actually lead to more weight loss and further improvements in risk factors compared to a low-fat diet (45, 46).\n" +
                                "\n" +
                                "Body fat: A low-carb diet, eaten until fullness, usually causes more fat loss than a low-fat diet that is calorie restricted (47, 48, 49).\n" +
                                "Blood sugar: One of the hallmarks of diabetes and the metabolic syndrome is an elevated blood sugar, which is very harmful over the long term. Low-carb diets lower blood sugar (50, 51, 52, 53, 54).\n" +
                                "Blood pressure: If blood pressure is high, it tends to go down on a low-carb diet (55, 56, 57).\n" +
                                "High triglycerides: These are fats that circulate around in the blood and are a strong risk factor for cardiovascular disease. Low-carb diets lower triglycerides much more than low-fat diets (58, 59, 60).\n" +
                                "HDL (the good) cholesterol: Generally speaking, having more of the \"good\" cholesterol means you have a lower risk of cardiovascular disease. Low-carb diets raise HDL cholesterol much more than low-fat diets (61, 62).\n" +
                                "sdLDL (the bad) cholesterol: Low-carb diets cause LDL cholesterol to change from small, dense LDL (bad) to large LDL, which is benign (63, 64).\n" +
                                "Easier: Low-carb diets appear to be easier to stick to than low-fat diets, probably because it isn't necessary to count calories and be hungry, which is arguably the worst side effect of dieting (65, 37).\n" +
                                "The statements above have been shown to be true in randomized controlled trials - scientific studies that are the gold standard of research.\n" +
                                "\n" +
                                "Common Low-Carb Side Effects in The Beginning\n" +
                                "When carbs in the diet are replaced with protein and fat, several things need to happen for the body to efficiently use fat as fuel.\n" +
                                "\n" +
                                "There will be major changes in hormones and the body needs to ramp up production of enzymes to start burning primarily fat instead of carbs. This can last for a few days and full adaptation may take weeks.\n" +
                                "\n" +
                                "Common side effects in the first few days include:\n" +
                                "\n" +
                                "Headache\n" +
                                "Feeling Lightheaded\n" +
                                "Tiredness\n" +
                                "Irritability\n" +
                                "Constipation\n" +
                                "Side effects are usually mild and nothing to worry about. Your body has been burning mostly carbs for decades, it takes time to adapt to using fat as the primary fuel source.\n" +
                                "\n" +
                                "This is called the \"low carb flu\" and should be over within 3-4 days.\n" +
                                "\n" +
                                "On a low-carb diet, it is very important to eat enough fat. Fat is the new source of fuel for your body. If you eat low-carb and low-fat, then you're going to feel bad and abandon the whole thing.\n" +
                                "\n" +
                                "Another important thing to be aware of is that insulin makes the kidneys hold on to sodium. When you eat less carbs, the kidneys release sodium. This is one of the reasons people lose so much bloat and water weight in the first few days.\n" +
                                "\n" +
                                "To counteract this loss of sodium you can add more salt to your food or drink a cup of broth every day. A bouillon cube dissolved in a cup of hot water contains 2 grams of sodium.\n" +
                                "\n" +
                                "Many people say they feel better than ever on a low-carb diet, when the initial adaptation period is over.\n" +
                                "\n" +
                                "If you don't feel good, adding more fat and sodium should take care of it.\n" +
                                "\n" +
                                "A Meal Plan That Can Save Your Life\n" +
                                "This is a sample meal plan for one week that supplies less than 50 grams of carbs per day.\n" +
                                "\n" +
                                "Day 1 — Monday:\n" +
                                "\n" +
                                "Breakfast: Omelet with various vegetables, fried in butter or coconut oil.\n" +
                                "Lunch: Grass-fed yogurt with blueberries and a handful of almonds.\n" +
                                "Dinner: Cheeseburger (no bun), served with vegetables and salsa sauce.\n" +
                                "Day 2 — Tuesday:\n" +
                                "\n" +
                                "Breakfast: Bacon and eggs.\n" +
                                "Lunch: Leftover burgers and veggies from the night before.\n" +
                                "Dinner: Boiled Salmon with butter and vegetables.\n" +
                                "Day 3 — Wednesday:\n" +
                                "\n" +
                                "Breakfast: Eggs and vegetables, fried in butter or coconut oil.\n" +
                                "Lunch: Shrimp salad with some olive oil.\n" +
                                "Dinner: Grilled chicken with vegetables.\n" +
                                "Day 4 — Thursday:\n" +
                                "\n" +
                                "Breakfast: Omelet with various vegetables, fried in butter or coconut oil.\n" +
                                "Lunch: Smoothie with coconut milk, berries, almonds and protein powder.\n" +
                                "Dinner: Steak and veggies.\n" +
                                "Day 5 — Friday:\n" +
                                "\n" +
                                "Breakfast: Bacon and Eggs.\n" +
                                "Lunch: Chicken salad with some olive oil.\n" +
                                "Dinner: Pork chops with vegetables.\n" +
                                "Day 6 — Saturday:\n" +
                                "\n" +
                                "Breakfast: Omelet with various veggies.\n" +
                                "Lunch: Grass-fed yogurt with berries, coconut flakes and a handful of walnuts.\n" +
                                "Dinner: Meatballs with vegetables.\n" +
                                "Day 7 — Sunday:\n" +
                                "\n" +
                                "Breakfast: Bacon and Eggs.\n" +
                                "Lunch: Smoothie with coconut milk, a bit of heavy cream, chocolate-flavoured protein powder and berries.\n" +
                                "Dinner: Grilled chicken wings with some raw spinach on the side.\n" +
                                "Do your best to include a variety of vegetables in your diet. If you want to stay below 50g of carbs per day then you can safely have one piece of fruit or some berries every day.\n" +
                                "\n" +
                                "Organic and grass-fed foods are best, but only if you can easily afford them. Just make an effort to always choose the least processed option within your price range.\n" +
                                "\n" +
                                "What About Snacks?\n" +
                                "There is no scientific evidence that you should eat more than 3 meals per day. If you do get hungry between meals, here are a few ideas for snacks that are healthy, easily portable and taste good.\n" +
                                "\n" +
                                "Full-fat yogurt\n" +
                                "A piece of fruit\n" +
                                "Baby carrots\n" +
                                "Hard-boiled eggs\n" +
                                "A handful of nuts\n" +
                                "Leftovers\n" +
                                "Some cheese and meat"+"\n"));

        articleList.add(
                new Article(
                        6,
                        "Health Check: how to exercise safely in the heat",
                        "Human core body temperature typically remains around 36.5°C to 37°C, with small fluctuations across the day. Larger changes above 40°C can be dangerous.",
                        4.8,
                        R.drawable.exercisesafely,
                        "Exercise alone can be hard, but exercising in the heat is a whole lot harder. Put simply, this is due to the balance between how much heat the body generates and how much it is capable of losing.\n" +
                                "\n" +
                                "Human core body temperature typically remains around 36.5°C to 37°C, with small fluctuations across the day. Larger changes above 40°C can be dangerous.\n" +
                                "\n" +
                                "Fortunately, humans are relatively well-adapted to dealing with the heat. One theory is that humans evolved a survival advantage as hunters because they could outlast animals that were less able to manage long periods of exertion under hot conditions.\n" +
                                "\n" +
                                "How do we regulate our temperature?\n" +
                                "1. Radiation: There are so many small blood vessels in the skin that, in total, they can receive up to 60% of output from the heart at rest.\n" +
                                "\n" +
                                "As blood flows from the core of the body to the skin, opening of these small blood vessels allows more surface area for heat exchange with the environment.\n" +
                                "\n" +
                                "Radiation of heat occurs when the surrounding environment is less hot than the skin surface. At rest in a cool environment, 60% of heat loss is by radiation.\n" +
                                "\n" +
                                "\n" +
                                " stockshoppe/Shutterstock\n" +
                                "2. Evaporation: As core temperature rises, sweat glands in the skin are activated, promoting heat loss via the combined processes of convection, conduction and evaporation.\n" +
                                "\n" +
                                "These forms of heat exchange become more important as heat production rises (such as during exercise), and as the environment becomes hotter and radiation less effective.\n" +
                                "\n" +
                                "Why is it so hard to exercise in the heat?\n" +
                                "Muscles that are active during exercise demand more energy and, consequently, increased blood supply and delivery of oxygen. This means the heart has to work harder to re-circulate blood to the active muscles.\n" +
                                "\n" +
                                "Exercising muscles also generate heat, as a by-product of chemical reactions inside cells. This increases core body temperature which, if not compensated for, can compromise the ongoing function of the central nervous system and/or muscle cells themselves.\n" +
                                "\n" +
                                "To lose heat, blood needs to be sent to the small arteries under the skin surface, so that heat transfer can take place via radiation. Sweating alone is relatively ineffective if this re-distribution of blood does not occur concurrently.\n" +
                                "\n" +
                                "So when exercise occurs under circumstances where heat loss is challenged (because the gradient between skin and environmental temperatures is narrow), more blood needs to be directed to the skin at the same time as this blood is needed in the muscles to increase workload.\n" +
                                "\n" +
                                "A competition therefore develops between the skin and working muscles for the limited maximal blood flow that the heart can manage.\n" +
                                "\n" +
                                "\n" +
                                "Acclimatisation can increase a person’s capacity to heat loss.  \n" +
                                "Different theories explain fatigue (the point at which you cannot maintain exercise duration and/or intensity) as either the inability to sustain oxygen delivery to the muscle in the face of thermoregulatory demand, or an inability to control body and brain temperature during exercise in hot environments.\n" +
                                "\n" +
                                "The causes of fatigue are of great interest to exercise scientists concerned with sport and workplace performance. We know that acclimation (the process of repeated exercise in hot conditions) can enhance an individual’s capacity for heat loss and, therefore, improve exercise performance and delay fatigue.\n" +
                                "\n" +
                                "Several steps in the exercise and thermoregulatory chain are amenable to adaptations that improve performance, including enhanced function and structure of the blood vessels, the function and size of the heart and even blood volume itself.\n" +
                                "\n" +
                                "Who is at risk of heat stroke?\n" +
                                "Heat stroke is a serious illness and those most at risk include adults aged over 65 years, babies and young children, pregnant women, people with existing medical conditions and those on particular medications. Most obviously, those who already have heart problems are at particular risk.\n" +
                                "\n" +
                                "\n" +
                                "Older people are at greater risk of heat-related illness.\n" +
                                "Such is the risk of heat illness that 10,000 excess deaths occurred during a heatwave in Europe in 2003.\n" +
                                "\n" +
                                "In the Australian summer of 2009, hot conditions in Victoria and South Australia were linked with higher rates of illness and more than 200 extra deaths than would normally occur, particularly among the elderly and those with heart disease.\n" +
                                "\n" +
                                "Early signs of heat exhaustion can include dizziness, headache and nausea. More severe cases of heat stroke involve hot dry skin with (paradoxically) no sweating, confusion and fainting.\n" +
                                "\n" +
                                "Sports Medicine Australia has produced a helpful guide to performance of sport or exercise in hot weather, which details the risk and symptoms of heat illness.\n" +
                                "\n" +
                                "What’s the best way to deal with the heat?\n" +
                                "For professional athletes, exercising in warm conditions can improve performance and is sometimes essential to prepare for different environmental conditions, such as preparing for an Olympic games in a hot country.\n" +
                                "\n" +
                                "Regardless, it’s important to take precautions to reduce the likelihood of heat illness by staying hydrated, wearing appropriate clothing and knowing your limits.\n" +
                                "\n" +
                                "For people who don’t exercise regularly or those who are at increased risk of heat-related illness, avoid exercising in the heat, such as the middle of the day in summer or rooms with poor air circulation.\n" +
                                "\n" +
                                "Instead, opt for a prescribed, gradual and incremental exercise program that improves your cardiovascular and thermoregulatory tolerance. Gradual and repeated heat exposure, even in the absence of exercise, may also be good for your health.\n" +
                                "\n" +
                                "The good news is that even exercise in normal or cool conditions will improve thermoregulatory capacity and resilience under hot conditions. But if it’s out of the ordinary for you, extreme exercise or exercise in extremes, is equally unwise."+"\n"));

        articleList.add(
                new Article(
                        7,
                        "High performance chocolate milk",
                        "Why most sports supplements are more spin than substance?",
                        4.9,
                        R.drawable.chocolatemilk,
                        "Endurance athletes, from weekend warriors to the elite, seek nutritional post-exercise products to enhance training and speed recovery. But for athletes, the challenge of negotiating the massive range of post-exercise supplements is increasingly overwhelming, and for some it is downright confusing.\n" +
                                "\n" +
                                "There are a lot of products on the market. Need to replace electrolytes? A quick review revealed over 20 companies selling liquid/powder electrolyte drinks, another ten companies pushing electrolyte tablets you can add to water, and I certainly cannot leave out the heavily debated salt tablet.\n" +
                                "\n" +
                                "Need to refuel with protein too? There are approximately 20 options aimed at endurance athletes and another 25 high protein replacement drinks geared toward gaining muscle and/or weight loss.\n" +
                                "\n" +
                                "Not sure which is best? Then Michael Phelps or many of the other celebrity endorsers pushing nutritional supplements can explain how the “latest and greatest” supplement should be a part of your post-exercise regimen. Need better (or more convincing) proof? There is the (quasi) scientific evidence boasted on adverts to support the use of such products, or, the advice of the fitness “expert” who bases his or her advice on such quasi-scientific evidence.\n" +
                                "\n" +
                                "Of course there’s the real science, which is readily available to the consumer, but doesn’t seem to make the same impact. Perhaps the science is too advanced for the layperson and it adds to the consumer’s confusion. While elite athletes have coaches or sport nutritionists to advise them of the latest science and proper post-exercise regimen, how does the recreational endurance athlete survive the often divergent messaging?\n" +
                                "\n" +
                                "Unfortunately, in their efforts to surpass the competition, product marketers have created so much clutter and mixed messaging that endurance athletes struggle to understand what product is best (or even necessary). For example, marketers have convinced athletes that leading and expensive post-exercise recovery drinks are superior to and enhance performance better than a more cost-effective chocolate milk option found at your local grocer. Rather, the truth is chocolate milk is an effective supplement for endurance athletes.\n" +
                                "\n" +
                                "Recent exercise science research has shown that endurance athletes receive optimal recovery from nutrition with a balance of the macronutrients protein, carbohydrate, and fat.\n" +
                                "\n" +
                                "In addition to replenishing glycogen stores, endurance athletes must also consider electrolyte replacement. Until recently, Gatorade \u00AD- arguably the leader in this realm - for example, have only provided the athlete with a sugary electrolyte replacement with no protein option. Gatorade’s “G Series” now includes protein recovery products.\n" +
                                "\n" +
                                "\n" +
                                "Is a humble glass of chocolate milk just as effective at post exercise recovery as expensive sports supplements and drinks?\n" +
                                "Unbeknown to most athletes, the low-fat chocolate milk option not only provides a rich source of protein, but also the valued electrolytes necessary for rehydration. But it’s not just about what athletes should be using, but also the timing for when it is consumed. The timing of consumption in order to support performance is heavily researched and debated. While this has had incredible impact in the sport science world, it can certainly add to confusion among consumers that don’t understand the science (or the debate) within the sport science community.\n" +
                                "\n" +
                                "This shows just how much marketers know about selling us supplements. However, what does the athlete think, or know? Looking at what sources of information athletes seek and how they perceive sport supplement marketing is fascinating, and there is still a need for more research in this area.\n" +
                                "\n" +
                                "Interestingly, runners and triathletes seek information from training books and articles, sport-specific websites, magazine advertisements, event trade shows, and friends and family. They tend to be indifferent to celebrity endorsements when considering post-exercise supplementation. Despite the fact that they clearly seek the scientific evidence, they do not fully understand the science based on how they choose post-exercise products.\n" +
                                "\n" +
                                "Notably, the media choices listed above (and the mixed messages often communicated through these mediums) do influence product choice as do factors such as sport type and a higher volume of training hours. Triathletes seem to better understand that longer training hours require a protein-carbohydrate supplement. Runners, however, tend to just reach for the electrolyte drink, despite the evidence that they too require a carb-protein source to replenish glycogen.\n" +
                                "\n" +
                                "So what can we learn from understanding athletes’ product choices? Research tells us that media plays a big role in influencing product choices. Therefore, scientists need to better disseminate the evidence using various media as a vehicle to better arm athletes with the tools to sort fact from marketing fiction.\n" +
                                "\n" +
                                "The confusion over the flood of supplements on the market is also part of the problem athletes face in knowing what they can take, when they should take it and why. For elite athletes, this information overload underlines the crucial role of sports scientists and coaching staff in providing accurate information.\n" +
                                "\n" +
                                "These athletes depend on their experts to not only supply them with the information that will enhance their performance, but also prevent them from ingesting a product that contains ingredients on a banned performance enhancing drug list.\n" +
                                "\n" +
                                "For the rest of us at more amateur levels, it’s anyone’s guess as to how we are supposed to know what supplements we should be taking.\n" +
                                "\n" +
                                "Chocolate milk anyone?"+"\n"));

        articleList.add(
                new Article(
                        8,
                        "Just because you’re thin, doesn’t mean you’re healthy",
                        "23% of those who are not currently overweight or obese are at risk of being so in the future.",
                        4.1,
                        R.drawable.thin,
                        "According to the Australian Institute of Health and Welfare, 63% of Australian adults are overweight or obese.\n" +
                                "\n" +
                                "But it’s much harder to estimate how many are within a healthy weight range but have poor diets or sedentary lifestyles. These can cause significant health problems that will often be missed because the person appears to look “healthy”.\n" +
                                "\n" +
                                "How do we judge the health of weight?\n" +
                                "Obesity statistics often take estimates of body fat using body mass index (BMI). Although BMI isn’t perfectly correlated with body fat percentage, it’s a quick and easy method for collecting data using just the person’s height and weight. If the BMI is higher than 25, a person is considered “overweight”. If it’s above 30, they’re considered “obese”. But BMI doesn’t tell us how healthy someone is on the inside.\n" +
                                "\n" +
                                "Using additional lifestyle measures, such as diet and exercise frequency over the last year, a recent report from the Queensland Health department estimated 23% of those who are not currently overweight or obese are at risk of being so in the future.\n" +
                                "\n" +
                                "These figures indicate that the percentage of unhealthy-weight individuals does not accurately capture the percentage of unhealthy-lifestyle individuals, with the latter number likely to be much higher.\n" +
                                "\n" +
                                "Read more:  We asked five experts: is BMI a good way to tell if my weight is healthy?\n" +
                                "\n" +
                                "If you’re not overweight, does a healthy lifestyle matter?\n" +
                                "Many people think if they’re able to stay lean while eating poorly and not exercising, then that’s OK. But though you might appear healthy on the outside, you could have the same health concerns as overweight and obese individuals on the inside.\n" +
                                "\n" +
                                "When considering risk factors associated with heart disease and stroke or cancer, we often think about health indicators such as smoking, cholesterol, blood pressure, and body weight. But poor diet and physical inactivity also each increase the risk for heart disease and have a role to play in the development of some cancers.\n" +
                                "\n" +
                                "So even if you don’t smoke and you’re not overweight, being inactive and eating badly increases your risk of developing heart disease.\n" +
                                "\n" +
                                "Little research has been done to compare the risk diet and exercise contributes to the development of heart disease in overweight versus skinny but unhealthy individuals. However, one study measured the risk of different lifestyle factors associated with complications following acute coronary syndrome – a sudden reduction in blood flow to the heart.\n" +
                                "\n" +
                                "It found adherence to a healthy diet and exercise regime halved the risk of having a major complication (such as stroke or death) in the six months following the initial incident compared with non-adherence.\n" +
                                "\n" +
                                "Unhealthy diets are bad for your body, but what about your brain?\n" +
                                "Recent research has also shown overconsumption of high-fat and high-sugar foods may have negative effects on your brain, causing learning and memory deficits. Studies have found obesity is associated with impairments in cognitive functioning, as assessed by a range of learning and memory tests, such as the ability to remember a list of words previously presented some minutes or hours earlier.\n" +
                                "\n" +
                                "Notably, this relationship between body weight and cognitive functioning was present even after controlling for a range of factors including education level and existing medical conditions.\n" +
                                "\n" +
                                "Of particular relevance to this discussion is the growing body of evidence that diet-induced cognitive impairments can emerge rapidly — within weeks or even days. For example, a study conducted at Oxford University found healthy adults assigned to a high-fat diet (75% of energy intake) for five days showed impaired attention, memory, and mood compared to a low-fat diet control group.\n" +
                                "\n" +
                                "Another study conducted at Macquarie University also found eating a high-fat and high-sugar breakfast each day for as little as four days resulted in learning and memory deficits similar to those observed in overweight and obese individuals.\n" +
                                "\n" +
                                "These findings confirm the results of rodent studies showing specific forms of memories can be impaired after only a few days on a diet containing sugar water and human “junk” foods such as cakes and biscuits.\n" +
                                "\n" +
                                "Body weight was not hugely different between the groups eating a healthy diet and those on high fat and sugar diets. So this shows negative consequences of poor dietary intake can occur even when body weight has not noticeably changed. These studies show body weight is not always the best predictor of internal health.\n" +
                                "\n" +
                                "We still don’t know much about the mechanism(s) through which these high-fat and high-sugar foods impair cognitive functioning over such short periods. One possible mechanism is the changes to blood glucose levels from eating high-fat and high-sugar foods. Fluctuations in blood glucose levels may impair glucose metabolism and insulin signalling in the brain.\n" +
                                "\n" +
                                "Many people use low body weight to excuse unhealthy eating and physical inactivity. But body weight is not the best indicator of internal well-being. A much better indicator is your diet. When it comes to your health, it’s what’s on the inside that counts and you really are what you eat."+"\n"));

        articleList.add(
                new Article(
                        9,
                        "More education leads to a healthier lifestyle",
                        "Why do some people invest more in a healthy lifestyle than others?",
                        3.9,
                        R.drawable.healtheducate,
                        "It is recognised that healthy habits account for large differences in health outcomes. Unhealthy behaviour has been cited as the main predictor of premature and preventable disease.\n" +
                                "\n" +
                                "But this raises an important, policy-related question. Why do some people invest more in a healthy lifestyle than others?\n" +
                                "\n" +
                                "Health economists argue that better educated people are more likely to choose healthier lifestyles. This is in part because future returns for healthy behaviour (in terms of both health and lifetime earnings) are higher for the better educated, thus leading them to invest more in a healthy lifestyle.\n" +
                                "\n" +
                                "People of higher educational background are on average less likely to smoke, abuse alcohol, and will exercise more, eat healthier foods, and have more frequent health checks than the average population.\n" +
                                "\n" +
                                "This can be explained by a variety of different reasons. For instance, students with healthier lifestyles may be more efficient in acquiring knowledge so they tend to perform well in their education. One could also imagine that people who value future consumptions more than current consumption will stay in school for longer, work more at younger ages and invest more in positive health-related behaviours.\n" +
                                "\n" +
                                "New research in the area\n" +
                                "Most of the existing evidence cannot truly separate the true effect of education itself on health habits from other confounding factors as mentioned above.\n" +
                                "\n" +
                                "My colleague and I have recently conducted research to address this important question. We used an econometric technique to empirically identify the causal effect of education on a range of health behaviours among Australian adults aged 22 to 65. We rely on school reforms in Australia on minimum compulsory school-leaving age as a natural experiment to identify this causal relationship.\n" +
                                "\n" +
                                "This research shows that among Australians, there is a sizable effect of staying an additional year in school on later health habits, including diet, exercise, and the decision to engage in risky health behaviours.\n" +
                                "\n" +
                                "Results also show that the positive effect of staying an additional year in school on health behaviours is larger for Australian women than for Australian men. Interestingly, previous studies from UK and Germany have found the opposite, that is that the health benefits from staying an additional year in school are larger for men than for women in these two countries.\n" +
                                "\n" +
                                "Does context matter?\n" +
                                "While we found a positive effect of education on health among Australians, previous studies from other countries indicate this is not necessarily true in different countries.\n" +
                                "\n" +
                                "Studies in Denmark and South Korea found similar evidence as ours, but no such evidence has been found in the US, the UK and Germany. This might be a reflection of the differences in the education and health care systems, or an interaction between these two systems, across different countries.\n" +
                                "\n" +
                                "Not only the context of the residing country but also the context in terms of early-life family circumstances may moderate the causal effect of education on health behaviours. Our study demonstrates that the magnitude of the education effect is larger for people from a poorer background when they were about 14 years old.\n" +
                                "\n" +
                                "Potential mechanisms\n" +
                                "There are many theories to why more education will lead to better health behaviours. We provide evidence that one of the reasons is because more education raises the individual’s conscientiousness levels and the perceived sense of control over one’s life, which in turn contributes to adopting healthier lifestyles.\n" +
                                "\n" +
                                "The intuition is that individual with different education levels may differ in their psychological capacity to make behaviour changes. This echoes some psychological theories which claim that in order to adopt certain behaviour or change certain lifestyles, individuals need to be “ready” to change and feel able to do so.\n" +
                                "\n" +
                                "This new finding may also explain why in previous studies other important individual attributes such as cognition function and knowledge can only explain some, but not all, of the causal effect of education on health behaviours.\n" +
                                "\n" +
                                "Policy implications\n" +
                                "The direct implication of these findings is that an increase in spending on education can lead to the overall improvement of the nation’s health. This provides a way of saving money for our health system, given that preventable diseases are often directly related to health habits.\n" +
                                "\n" +
                                "While we have found an important effect of education on later health behaviours for people who were directly affected by changes in the compulsory schooling laws in Australia, we have also demonstrated that there is a considerable difference in the education effect across different groups of individuals.\n" +
                                "\n" +
                                "Future research – especially qualitative research – should come back to investigate how different predetermined characteristics and early home environments can moderate the causal effect of education on health behaviours.\n" +
                                "\n" +
                                "Given that an additional year of schooling also caused a change in psychological traits that are known to govern healthy behaviour, there is scope for later policy interventions to try to improve personality traits that are related to healthy habits."+"\n"));

        articleList.add(
                new Article(
                        10,
                        "Stress causes cancer",
                        "Stress is, nonetheless, a significant health issue. ",
                        4.3,
                        R.drawable.stress,
                        "Cancer is a disease of the body’s cells that affects around half of all Australians by the age of 85. Normally cells grow and multiply in a controlled way. But if something causes a mistake to occur in the cells’ genetic blueprints, this control can be lost.\n" +
                                "\n" +
                                "There are a number of chemical, physical and biological agents that have been shown to trigger the mistakes in the cell blueprint that cause cancer – but stress isn’t one of them.\n" +
                                "\n" +
                                "We all encounter short- and long-term stresses in our lives, such as work challenges, relationship problems and illness, which have varying degrees of psychological impact. Stress can be nature’s way to help energise us to deal with these adverse events.\n" +
                                "\n" +
                                "But high levels of stress can lead to anxiety and depression. These are serious, often interconnected, mental health problems that can affect your ability to work, maintain relationships and lead a fulfilled life. But three decades of study have found no direct association between stress and cancer, not even when stress is high enough to cause an anxiety disorder or depression.\n" +
                                "\n" +
                                "So if you want to reduce your risk of cancer, the most important thing you can do is avoid or reduce the known risk factors – such as smoking, being overweight, having a poor diet, being physically inactive, exposing yourself to UV radiation and consuming excessive amounts of alcohol. Avoiding these risk factors is known as adopting a “cancer-smart” lifestyle.\n" +
                                "\n" +
                                "Someone who feels stressed but lives a cancer-smart lifestyle is at no higher risk of cancer than a relaxed person with an equally healthy lifestyle. By the same token, a person who doesn’t feel stressed but smokes or does other things that are known to cause cancer is at higher risk than even the most anxious individual who has a cancer-smart lifestyle.\n" +
                                "\n" +
                                "\n" +
                                "It may increase your risk of depression and anxiety but stress doesn’t cause cancer.\n" +
                                "So, in the absence of evidence, why do so many people think stress causes cancer?\n" +
                                "\n" +
                                "One reason could be that people who are stressed tend to smoke, drink excessively, be inactive and have poor diets. But this does not make stress itself a cancer risk factor. (Ironically, tobacco use, physical inactivity, excessive drinking and consumption of “comfort foods” can actually increase, rather than alleviate, stress levels.)\n" +
                                "\n" +
                                "Another reason for the myth might be the relationship between stress and the body’s immune system. There is some evidence that stress can lower immunity – the body’s natural defence against disease. Reduced immunity makes us more susceptible to some virus-related cancers, such as certain forms of lymphoma and Kaposi’s sarcoma. However, evidence of causation is limited and, again, complicated by the direct impact of behavioural risk factors on the immune system.\n" +
                                "\n" +
                                "Studies also show that people who are emotionally distressed are more likely to think they are sick. The flip side is that dealing with serious illnesses like cancer can be stressful. But again, neither equates to stress being a cause of cancer.\n" +
                                "\n" +
                                "The idea that a positive outlook will affect your chances of remission from cancer or your survival is another myth, based on stories we hear about people who “beat” their cancer through their “fighting spirit” or “determination”. There is no conclusive evidence that people who are distressed by their cancer experience have poorer clinical outcomes than those who feel “positive” – provided they follow evidence-based advice on treatment and care.\n" +
                                "\n" +
                                "The perception that some patients did not survive because they were not as positive as others is unfounded and unfair. Dealing with a cancer diagnosis is tough enough; being pressured into thinking that the only way through it is to remain positive and thus minimise your stress can add to a patient’s individual burden.\n" +
                                "\n" +
                                "Stress is, nonetheless, a significant health issue. If it’s a problem for you, you can learn calming techniques to help deal with it. Speak to your doctor or contact referral services such as Beyond Blue or Lifeline, which provide information and support to people with depression and anxiety. Improving your health and fitness by being more active and avoiding substances like alcohol and tobacco can also assist. And a healthier lifestyle will reduce your risk of cancer.\n" +
                                "\n" +
                                "Fortunately, there’s no evidence that stress causes cancer – so it’s one less thing we need to worry about."+"\n"));

        adapter = new ArticleAdapter(this, articleList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
