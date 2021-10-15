package com.stream_pi.server.combobox;

import com.stream_pi.server.i18n.I18N;
import com.stream_pi.server.i18n.Language;
import com.stream_pi.server.window.ExceptionAndAlertHandler;
import com.stream_pi.util.exception.SevereException;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Locale;

public class LanguageChooserComboBox extends ComboBox<Language>
{
    public LanguageChooserComboBox()
    {
        Callback<ListView<Language>, ListCell<Language>> callbackFactory = new Callback<>() {
            @Override
            public ListCell<Language> call(ListView<Language> language) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(Language language, boolean b)
                    {
                        super.updateItem(language, b);

                        if (language != null)
                        {
                            setText(language.getFullName());
                        }
                    }
                };
            }
        };

        setCellFactory(callbackFactory);
        setButtonCell(callbackFactory.call(null));

        setItems(FXCollections.observableArrayList(I18N.getLanguages()));
    }

    public Locale getSelectedLocale()
    {
        return getSelectionModel().getSelectedItem().getLocale();
    }
}