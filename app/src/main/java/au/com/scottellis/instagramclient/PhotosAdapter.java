package au.com.scottellis.instagramclient;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.joanzapata.iconify.widget.IconTextView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.PeriodFormat;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.util.List;

import au.com.scottellis.instagramclient.model.Caption;
import au.com.scottellis.instagramclient.model.Photo;

/**
 * Adapter for list view
 */
public class PhotosAdapter extends ArrayAdapter<Photo> {
    PeriodFormatter ageFormatter = new PeriodFormatterBuilder()
            .appendLiteral("{fa-clock-o} ")
            .printZeroRarelyLast()
            .appendDays()
            .appendSuffix("d")
            .appendSeparator(" ")
            .appendHours()
            .appendSuffix("h")
            .appendSeparator(" ")
            .appendMinutes()
            .appendSuffix("m")
            .toFormatter();

    public PhotosAdapter(Context context, List<Photo> objects) {
        super(context, R.layout.item_photo, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Photo photo = getItem(position);

        final ViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
            holder = new ViewHolder();
            holder.ivImage = (ImageView)convertView.findViewById(R.id.ivImage);
            holder.rivUserPic = (RoundedImageView)convertView.findViewById(R.id.rivUserPic);
            holder.tvUsername = (TextView)convertView.findViewById(R.id.tvUsername);
            holder.tvAge = (IconTextView)convertView.findViewById(R.id.tvAge);
            holder.tvCaption = (TextView)convertView.findViewById(R.id.tvCaption);
            holder.tvLikes = (IconTextView)convertView.findViewById(R.id.tvLikes);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvUsername.setText(photo.getUser().getUsername());

        Duration age = new Duration(photo.getCreatedTime(), DateTime.now());
        Period agePeriod = age.toPeriod(PeriodType.standard());
        holder.tvAge.setText(ageFormatter.print(agePeriod));

        Caption caption = photo.getCaption();
        if(caption != null) {
            String text = String.format(convertView.getResources().getString(R.string.caption_string),
                    caption.getFrom().getUsername(),
                    caption.getText());
            holder.tvCaption.setText(Html.fromHtml(text));
        } else {
            holder.tvCaption.setText("");
        }

        String likesText = String.format(convertView.getResources().getString(R.string.likes_string),
                photo.getLikes().getCount());
        holder.tvLikes.setText(likesText);

        Picasso.with(getContext()).load(photo.getImages().getStandardResolution().getUrl()).into(holder.ivImage);
        Picasso.with(getContext()).load(photo.getUser().getProfilePic()).into(holder.rivUserPic);

        return convertView;
    }

    private class ViewHolder {
        ImageView ivImage;
        RoundedImageView rivUserPic;
        TextView tvUsername;
        IconTextView tvAge;
        TextView tvCaption;
        IconTextView tvLikes;
    }
}
