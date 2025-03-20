package com.example.betaforall.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.betaforall.R;
import com.example.betaforall.adapter.ItemAdapter;
import com.example.betaforall.databinding.FragmentHomeBinding;
import com.example.betaforall.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Получаем массивы строк из ресурсов
        String[] textArray1 = getResources().getStringArray(R.array.item_texts1);
        String[] textArray2 = getResources().getStringArray(R.array.item_texts2);
        String[] textArray3 = getResources().getStringArray(R.array.item_texts3);

        List<ItemModel> itemList = new ArrayList<>();
        for (int i = 0; i < textArray1.length; i++) {
            itemList.add(new ItemModel(
                    textArray1[i],
                    textArray2.length > i ? textArray2[i] : "",
                    textArray3.length > i ? textArray3[i] : "",
                    R.drawable.dall_e_2025_03_10_12_36_23___a_3d_visualization_of_an_anonymous_family_car_styled_as_a_solid_opaque_glass_figurine__the_car_s_body_has_smooth_lines__increased_interior_space__and_
            ));
        }

        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ItemAdapter(getContext(), itemList));

        return root;
    }
}
