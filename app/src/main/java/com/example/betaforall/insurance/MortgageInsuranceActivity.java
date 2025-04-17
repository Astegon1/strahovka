package com.example.betaforall.insurance;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.betaforall.R;
import com.example.betaforall.adapter.ExpandableAdapter;
import com.example.betaforall.adapter.InfoBlockAdapter;
import com.example.betaforall.adapter.InfoImageBlockAdapter;
import com.example.betaforall.adapter.StepBlockAdapter;
import com.example.betaforall.model.ExpandableItem;
import com.example.betaforall.model.InfoBlockItem;
import com.example.betaforall.model.InfoImageBlockItem;
import com.example.betaforall.model.StepBlockItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MortgageInsuranceActivity extends AppCompatActivity {

    // Элементы шагов
    private TextView step1, step2, backButton;
    private LinearLayout step1View, step2View;
    private Button nextButton;
    private int currentStep = 1;

    // RecyclerViews
    private RecyclerView mortgage1RecyclerView;
    private RecyclerView mortgageExtra1RecyclerView;
    private RecyclerView mortgage2RecyclerView;
    private RecyclerView mortgageExtra2RecyclerView;
    private RecyclerView mortgage3RecyclerView;
    private RecyclerView mortgage4RecyclerView;
    private RecyclerView mortgage5RecyclerView;
    private RecyclerView questionsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage_insurance);

        // Инициализация элементов шагов
        step1 = findViewById(R.id.step1);
        step2 = findViewById(R.id.step2);
        step1View = findViewById(R.id.step1View);
        step2View = findViewById(R.id.step2View);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backText);

        // Настройка обработчиков кнопок
        nextButton.setOnClickListener(v -> navigateToNextStep());
        backButton.setOnClickListener(v -> navigateToPreviousStep());

        // Инициализация RecyclerViews
        mortgage1RecyclerView = findViewById(R.id.mortgage1);
        mortgageExtra1RecyclerView = findViewById(R.id.mortgageExtra1);
        mortgage2RecyclerView = findViewById(R.id.mortgage2);
        mortgageExtra2RecyclerView = findViewById(R.id.mortgageExtra2);
        mortgage3RecyclerView = findViewById(R.id.mortgage3);
        mortgage4RecyclerView = findViewById(R.id.mortgage4);
        mortgage5RecyclerView = findViewById(R.id.mortgage5);
        questionsRecyclerView = findViewById(R.id.vopros);

        // Настройка адаптеров
        setupAdapters();

        // Обновление UI первого шага
        updateStepUI();
    }

    private void setupAdapters() {
        // Настройка первого RecyclerView (преимущества с иконками)
        List<InfoImageBlockItem> benefitsList = new ArrayList<>();
        benefitsList.add(new InfoImageBlockItem(R.drawable.fileusersolid, "Оформление онлайн", "Без медицинского обследования, длинных анкет и похода в офис. Полис в банк отправим сами"));
        benefitsList.add(new InfoImageBlockItem(R.drawable.personcall24filled, "Персональный менеджер", "При страховом случае подскажет, какие документы нужны, свяжется после принятия решения о выплате"));
        benefitsList.add(new InfoImageBlockItem(R.drawable.shieldsolid, "Помощь 24/7", "Всегда на связи по телефону, в чате и мессенджерах. Ответим на вопросы, поможем при страховом случае"));

        InfoImageBlockAdapter benefitsAdapter = new InfoImageBlockAdapter(benefitsList);
        mortgage1RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mortgage1RecyclerView.setAdapter(benefitsAdapter);

        // Настройка дополнительного инфоблока 1
        List<StepBlockItem> extra1List = Arrays.asList(
                new StepBlockItem("Заполните данные и узнайте цену"),
                new StepBlockItem("Оплатите картой онлайн"),
                new StepBlockItem("Получите полис по эл. почте")
        );

        StepBlockAdapter extra1Adapter = new StepBlockAdapter(extra1List);
        mortgageExtra1RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mortgageExtra1RecyclerView.setAdapter(extra1Adapter);

        // Настройка второго RecyclerView (преимущества)
        List<InfoBlockItem> benefits2List = Arrays.asList(
            new InfoBlockItem("Перевели выплату, когда из‑за залива пострадали полы в квартире",
                    "Что произошло\n" +
                    "\n" +
                    "Ипотечную квартиру клиента Т‑Страхования залило из‑за ошибки застройщика: лопнула труба с горячей водой в стяжке пола. Протечку обнаружили только через сутки. В результате во всей квартире вымокли перекрытия и черновые полы, в бетоне пошли трещины.\n" +
                    "\n" +
                    "Как помогли\n" +
                    "\n" +
                    "Для оценки ущерба мы направили эксперта, а акт о заливе от управляющей компании и другие документы клиент прислал онлайн." + "\n" +"Выплатили 760 000 ₽ на ремонт квартиры" , "Подробнее"),
                new InfoBlockItem("Перевели деньги на ремонт квартиры",
                        "Что произошло\n" +
                                "\n" +
                                "В квартире клиента Т‑Страхования произошел пожар. Сгорело одно из окон, еще несколько оплавились из‑за огня. Пострадала входная дверь: ее выломали пожарные, чтобы попасть внутрь.\n" +
                                "\n" +
                                "Как помогли\n" +
                                "\n" +
                                "Для осмотра повреждений и оценки ущерба мы направили эксперта. Нужные документы клиент прислал онлайн — как только их получили, перевели деньги ему на карту." + "\n" +
                                "Выплатили 120 000 ₽ на ремонт квартиры", "Подробнее")
        );
        InfoBlockAdapter benefits2Adapter = new InfoBlockAdapter(benefits2List,null);
        mortgage2RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mortgage2RecyclerView.setAdapter(benefits2Adapter);
        // Настройка дополнительного инфоблока 2
        List<InfoImageBlockItem> extra2List = new ArrayList<>();
        extra2List.add(new InfoImageBlockItem(R.drawable.star11, "Дешевле до 30%", "У нас нет расходов на агентов и офисы продаж, поэтому мы можем предлагать более выгодные цены."));
        extra2List.add(new InfoImageBlockItem(R.drawable.clockcirclefilled, "Оформление за пару минут", "Онлайн, без поездок в офис и очередей\n" +
                "Простой калькулятор вместо сложных анкет\n" +
                "Не нужно сканировать и загружать документы по ипотеке"));
        extra2List.add(new InfoImageBlockItem(R.drawable.bellfilled, "Страхование без переживаний", "Напомним об окончании страховки, чтобы вы успели ее продлить и банк не повысил ставку по ипотеке\n" +
                "При страховом случае позаботимся о быстром урегулировании и поможем погасить ипотеку"));
        extra2List.add(new InfoImageBlockItem(R.drawable.mobilefilled, "Все сервисы в одном приложении", "Оформление и продление страховки"+ "\n" +"Оформление страхового случая"));


        InfoImageBlockAdapter extra2Adapter = new InfoImageBlockAdapter(extra2List);
        mortgageExtra2RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mortgageExtra2RecyclerView.setAdapter(extra2Adapter);

        // Настройка третьего RecyclerView (преимущества)
        List<InfoBlockItem> benefits3List = Arrays.asList(
                new InfoBlockItem("Страхование квартиры",
                        "Поможем, если разрушены стены или перекрытия в результате:\n" +
                                "\n" +
                                "— Пожара, взрыва, удара молнии\n" +
                                "\n" +
                                "— Падения дронов и других летательных аппаратов\n" +
                                "\n" +
                                "— Ремонта в соседних помещениях\n" +
                                "\n" +
                                "— Стихийных бедствий\n" +
                                "\n" +
                                "— Залива" , ""),
                new InfoBlockItem("Страхование заемщика",
                        "Поможем, если заемщик заболел или произошел несчастный случай, который повлек:\n" +
                                "\n" +
                                "— Установление инвалидности I или II группы\n" +
                                "\n" +
                                "— Уход из жизни", ""),
        new InfoBlockItem("Титульное страхование",
                "Поможем, если возникли проблемы с правом собственности на квартиру:\n" +
                        "\n" +
                        "— Утрата права собственности из-за признания сделки недействительной\n" +
                        "\n" +
                        "— Ограничение права собственности по решению суда", "")
        );

        InfoBlockAdapter benefits3Adapter = new InfoBlockAdapter(benefits3List,null);
        mortgage3RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mortgage3RecyclerView.setAdapter(benefits3Adapter);

        // Настройка третьего RecyclerView (преимущества)
        List<InfoBlockItem> benefits4List = Arrays.asList(
                new InfoBlockItem("ВТБ",
                        "Мы сами отправим страховку в банк. Вам не нужно об этом беспокоиться" , ""),
                new InfoBlockItem("СберБанк",
                        "Загрузите страховку на сайте Домклик. Мы будем на связи и поможем решить все вопросы", ""),
                new InfoBlockItem("Другие банки",
                        "Как правило, страховку достаточно отправить по эл. почте или загрузить на сайте банка. В некоторых случаях нужно принести ее в офис. После оформления страховки мы пришлем инструкцию по дальнейшим шагам и проконсультируем в чате", "")
        );

        InfoBlockAdapter benefits4Adapter = new InfoBlockAdapter(benefits4List,null);
        mortgage4RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mortgage4RecyclerView.setAdapter(benefits4Adapter);

        // Настройка пятого RecyclerView (преимущества)
        List<InfoImageBlockItem> benefits5List = new ArrayList<>();
        benefits5List.add(new InfoImageBlockItem(R.drawable.formatpainterfilled, "Ремонт в квартире", "Возместим стоимость ремонта, если из-за страхового случая осыпался потолок, вздулся ламинат, пострадали обои или краска на стенах"));
        benefits5List.add(new InfoImageBlockItem(R.drawable.couch24filled, "Мебель, техника и другие вещи", "Выплатим деньги на ремонт или покупку нового дивана, ноутбука и других вещей, если их повредили при пожаре, заливе либо украли"));
        benefits5List.add(new InfoImageBlockItem(R.drawable.businessperson, "Ответственность перед соседями", "Компенсируем за вас ущерб соседям, если вы их зальете, например, после подключения стиральной машины"));

        InfoImageBlockAdapter benefits5Adapter = new InfoImageBlockAdapter(benefits5List);
        mortgage5RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mortgage5RecyclerView.setAdapter(benefits5Adapter);

        // Настройка RecyclerView с вопросами
        String[] questions = getResources().getStringArray(R.array.mortgage_insurance_faq_questions);
        String[] answers = getResources().getStringArray(R.array.mortgage_insurance_faq_answers);

        List<ExpandableItem> questionsList = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            questionsList.add(new ExpandableItem(questions[i], answers[i]));
        }


        ExpandableAdapter questionsAdapter = new ExpandableAdapter(questionsList);
        questionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        questionsRecyclerView.setAdapter(questionsAdapter);
    }

    private void navigateToNextStep() {
        if (currentStep < 2) {
            currentStep++;
            updateStepViews();
            updateStepUI();
        }
    }

    private void navigateToPreviousStep() {
        if (currentStep > 1) {
            currentStep--;
            updateStepViews();
            updateStepUI();
        }
    }

    private void updateStepViews() {
        step1View.setVisibility(currentStep == 1 ? View.VISIBLE : View.GONE);
        step2View.setVisibility(currentStep == 2 ? View.VISIBLE : View.GONE);
        backButton.setVisibility(currentStep > 1 ? View.VISIBLE : View.GONE);
    }

    private void updateStepUI() {
        // Сброс всех шагов
        resetStepUI();

        // Выделение текущего шага
        switch (currentStep) {
            case 1:
                step1.setTextColor(Color.BLACK);
                step1.setTypeface(null, Typeface.BOLD);
                step1.setBackgroundResource(R.drawable.circle_filled);
                break;
            case 2:
                step2.setTextColor(Color.BLACK);
                step2.setTypeface(null, Typeface.BOLD);
                step2.setBackgroundResource(R.drawable.circle_filled);
                break;
        }
    }

    private void resetStepUI() {
        step1.setTextColor(getResources().getColor(R.color.step_default));
        step1.setTypeface(null, Typeface.NORMAL);
        step1.setBackgroundResource(R.drawable.circle_border);

        step2.setTextColor(getResources().getColor(R.color.step_default));
        step2.setTypeface(null, Typeface.NORMAL);
        step2.setBackgroundResource(R.drawable.circle_border);
    }
}