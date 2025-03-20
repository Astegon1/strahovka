package com.example.betaforall.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.betaforall.MainActivity;
import com.example.betaforall.R;
import com.example.betaforall.databinding.FragmentDashboardBinding;
import com.example.betaforall.model.Client;
import com.example.betaforall.ui.home.HomeFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private TextView textViewEmail;
    private Button buttonLogout, buttonSave, buttonUpdate;
    private EditText editTextFirstName, editTextLastName, editTextMiddleName, editTextDateOfBirth;
    private TextView textViewFirstName, textViewLastName, textViewMiddleName, textViewDateOfBirth;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Инициализация Firebase
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Инициализация UI компонентов
        textViewEmail = root.findViewById(R.id.textViewEmailLabel);
        buttonLogout = root.findViewById(R.id.buttonLogout);
        buttonSave = root.findViewById(R.id.buttonSave);
        buttonUpdate = root.findViewById(R.id.buttonUpdate);

        // Инициализация EditText
        editTextFirstName = root.findViewById(R.id.editTextFirstName);
        editTextLastName = root.findViewById(R.id.editTextLastName);
        editTextMiddleName = root.findViewById(R.id.editTextMiddleName);
        editTextDateOfBirth = root.findViewById(R.id.editTextDateOfBirth);

        // Инициализация TextView
        textViewFirstName = root.findViewById(R.id.textViewFirstName);
        textViewLastName = root.findViewById(R.id.textViewLastName);
        textViewMiddleName = root.findViewById(R.id.textViewMiddleName);
        textViewDateOfBirth = root.findViewById(R.id.textViewDateOfBirth);

        // Получаем текущего пользователя
        String currentUserEmail = mAuth.getCurrentUser().getEmail();
        textViewEmail.setText(currentUserEmail);

        // Проверяем данные клиента
        checkAndDisplayClientData();

        // Обработчик кнопки выхода
        buttonLogout.setOnClickListener(v -> {
            mAuth.signOut();
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);

        });

        // Обработчик кнопки "Сохранить"
        buttonSave.setOnClickListener(v -> saveClientData());

        // Обработчик кнопки "Обновить"
        buttonUpdate.setOnClickListener(v -> enableEditMode());

        // Открываем календарь при клике на EditText


        return root;
    }

    private void checkAndDisplayClientData() {
        String userId = mAuth.getCurrentUser().getUid();

        mDatabase.child("clients").child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // Данные найдены, отображаем их в TextView
                    Client client = snapshot.getValue(Client.class);
                    displayClientData(client);
                } else {
                    // Если данных нет, показываем поля ввода и кнопку "Сохранить"
                    buttonSave.setVisibility(View.VISIBLE);
                    buttonUpdate.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Обработка ошибки чтения из базы данных
            }
        });
    }

    private void displayClientData(Client client) {
        // Отображаем данные в TextView
        textViewFirstName.setText(client.getFirstName());
        textViewLastName.setText(client.getLastName());
        textViewMiddleName.setText(client.getMiddleName());
        textViewDateOfBirth.setText(client.getDateOfBirth());

        // Скрываем кнопки "Сохранить" и показываем кнопку "Обновить"
        buttonSave.setVisibility(View.GONE);
        buttonUpdate.setVisibility(View.VISIBLE);

        // Показываем только TextView, скрываем EditText
        setVisibilityForFields(View.VISIBLE, View.GONE);
    }

    private void setVisibilityForFields(int textViewVisibility, int editTextVisibility) {
        textViewFirstName.setVisibility(textViewVisibility);
        textViewLastName.setVisibility(textViewVisibility);
        textViewMiddleName.setVisibility(textViewVisibility);
        textViewDateOfBirth.setVisibility(textViewVisibility);

        editTextFirstName.setVisibility(editTextVisibility);
        editTextLastName.setVisibility(editTextVisibility);
        editTextMiddleName.setVisibility(editTextVisibility);
        editTextDateOfBirth.setVisibility(editTextVisibility);
    }

    private void enableEditMode() {
        // Переводим все поля в режим редактирования
        setVisibilityForFields(View.GONE, View.VISIBLE);

        // Скрыть кнопку "Обновить" и показать кнопку "Сохранить"
        buttonSave.setVisibility(View.VISIBLE);
        buttonUpdate.setVisibility(View.GONE);

        // Передаем данные из TextView в EditText
        editTextFirstName.setText(textViewFirstName.getText().toString());
        editTextLastName.setText(textViewLastName.getText().toString());
        editTextMiddleName.setText(textViewMiddleName.getText().toString());
        editTextDateOfBirth.setText(textViewDateOfBirth.getText().toString());
    }


    private void saveClientData() {
        String userId = mAuth.getCurrentUser().getUid();
        String firstName = editTextFirstName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String middleName = editTextMiddleName.getText().toString();
        String dateOfBirth = editTextDateOfBirth.getText().toString();
        String email = mAuth.getCurrentUser().getEmail();

        Client client = new Client(userId, firstName, lastName, middleName, dateOfBirth, email);

        mDatabase.child("clients").child(userId).setValue(client).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // Уведомление об успешной записи
                displayClientData(client); // Отображаем данные с помощью TextView
            } else {
                // Уведомление об ошибке
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
