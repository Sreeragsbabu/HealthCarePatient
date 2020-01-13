package com.example.healthcarepatient;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import de.hdodenhof.circleimageview.CircleImageView;

public class ConfirmAlertDialogFragment extends DialogFragment {

    ConstraintLayout constraintLayoutOk;
    RelativeLayout relativeLayout;
    ConstraintLayout container;
    ConfirmAlertDialogFragment dialogFragment;
    Context context;
    DialogListener dialogListener;

    public ConfirmAlertDialogFragment(Context context) {
        dialogListener = (DialogListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.book_confirm_alert,null);
        builder.setView(view);

        constraintLayoutOk = view.findViewById(R.id.constraintlayout_ok_thanks);
        container = view.findViewById(R.id.my_container);


        constraintLayoutOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"next view",Toast.LENGTH_SHORT).show();

                dialogListener.onOkay();
            }
        });

        return builder.create();


    }
}
