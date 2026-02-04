type PrimaryProps = {
     label : string;
     onClick? : () => void;
     type?: "button" | "submit";
}

export default function PrimaryButton({label, onClick, type = "button"} : PrimaryProps)
{
    return(
        <button
        className = "btnPrimary" onClick={onClick} type = {type}>
            {label}
        </button>
    );
}